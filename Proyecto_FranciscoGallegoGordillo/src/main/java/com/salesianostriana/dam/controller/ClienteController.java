package com.salesianostriana.dam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.model.Cita;
import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.servicio.CitaServicio;
import com.salesianostriana.dam.servicio.ClienteServicio;

import lombok.RequiredArgsConstructor;


/**
 * Esta clase es casi idéntica a CitaController, pero con algunas novedades.
 * 
 * @author Fran
 * @version1.0
 */
@Controller
@RequestMapping("/admin/cliente")
public class ClienteController {

	@Autowired
	private CitaServicio citaServicio;

	@Autowired
	private ClienteServicio clienteServicio;

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	
	/**
	 * Método que añade al modelo una lista de clientes.
	 * También se le añade un formulario con un campo para buscar mediante una consulta,
	 * si el resultado de la consulta está vacío imprime la lista.
	 * Si el resultado no está vacío imprime la lista de clientes buscando únicamente los clientes
	 * que ha devuelto la consulta.
	 * @param model
	 * @param consulta
	 * @return String con el nombre del html que contiene la lista de clientes.
	 */
	@GetMapping("/clientes")
	public String gestionCitas(Model model, @RequestParam("q") Optional<String> consulta) {

		List<Cliente> clientes;

		if (consulta.isEmpty()) {
			clientes = clienteServicio.findAll();
		} else {
			clientes = clienteServicio.clientesNombre(consulta.get());
		}

		model.addAttribute("clientes", clientes);
		return "admin/list-clientes";
	}
	
	/**
	 * Método que recoge el id de un cliente que le pasemos y busca una lista 
	 * de citas que tiene ese cliente.
	 * @param id
	 * @param model
	 * @return String con el nombre del html que contiene la lista de citas del cliente que se le haya pasado.
	 */

	@GetMapping("/detalles/{id}")
	public String showDetails(@PathVariable("id") Long id, Model model) {
		model.addAttribute("cliente", clienteServicio.findById(id));

		model.addAttribute("citas", clienteServicio.findById(id).getCitas());

		return "detail";

	}

	@GetMapping("/nuevo")
	public String nuevoCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "admin/form-clientes";
	}

	@PostMapping("/nuevo/submit")
	public String submitNuevoCliente(@ModelAttribute("cliente") Cliente cliente, Model model) {
		clienteServicio.save(cliente);
		return "redirect:/admin/cliente/clientes";
	}

	@GetMapping("/editar/{id}")
	public String editarCliente(@PathVariable("id") Long id, Model model) {
		Cliente cliente = clienteServicio.findById(id);

		if (cliente != null) {
			model.addAttribute("cliente", cliente);
			return "admin/form-clientes";
		} else {
			return "redirect:/admin/cliente/";
		}
	}

	@GetMapping("/borrar/{id}")
	public String borrarCliente(@PathVariable("id") Long id, Model model) {

		Cliente cliente = clienteServicio.findById(id);

		if (cliente != null) {
			if (citaServicio.numeroCitasCliente(cliente) == 0) {
				clienteServicio.delete(cliente);
			} else {
				return "redirect:/admin/cliente/clientes?error=true";
			}
		}

		return "redirect:/admin/cliente/clientes";
	}
}
