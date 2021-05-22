package com.salesianostriana.dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.model.Cita;
import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.model.DataMaster;
import com.salesianostriana.dam.servicio.CitaServicio;
import com.salesianostriana.dam.servicio.ClienteServicio;

import lombok.RequiredArgsConstructor;

/**
 * La clase CitaController se encarga de trabajar y mappear la aplicación. Está
 * anotada con @RequestMapping, que significa que todas las peticiones que
 * atienda, tendrán la ruta /admin/cita/...
 * 
 * @author Fran
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/admin/cita")
public class CitaController {

	@Autowired
	private CitaServicio citaServicio;

	@Autowired
	private ClienteServicio clienteServicio;

	/**
	 * Método que sirve para mostrar la página principal al escribir en el navegador
	 * "/" gracias a la anotación @GetMapping("/")
	 * 
	 * @param model
	 * @return Devuelve un tipo String con el nombre de nuestra página principal sin
	 *         la extensión.
	 */
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	/**
	 * Método que añade al modelo una lista de citas. Funciona en el momento en el
	 * que en el navegador se le llama escribiendo "/citas".
	 * 
	 * @param model
	 * @return Devuelve un tipo String con el nombre de la página web en la que
	 *         mostramos las listas mediante una tabla.
	 */

	@GetMapping("/citas")
	public String gestionCitas(Model model) {
		model.addAttribute("citas", citaServicio.findAll());
		return "admin/list-citas";
	}

	
	/**
	 * Método para redirigir al formulario para insertar una nueva cita.
	 * @param model
	 * @return String con el nombre de la página en la que tenemos el formulario.
	 */
	@GetMapping("/nueva")
	public String nuevaCita(Model model) {
		model.addAttribute("cita", new Cita());
		model.addAttribute("clientes", clienteServicio.findAll());
		return "admin/form-citas";
	}

	
	/**
	 * Método que crea una nueva cita, la guarda en la base de datos y redirije a la
	 * página en la que se encuentra la lista de citas mostrando la nueva.
	 * @param cita
	 * @param model
	 * @return String con el nombre de la página html en la que tenemos la lista de citas
	 */
	@PostMapping("/nueva/submit")
	public String submitNuevaCita(@ModelAttribute("cita") Cita cita, Model model) {
		citaServicio.save(cita);
		return "redirect:/admin/cita/citas";
	}
	
	/**
	 * Método que recoge el id de la cita que le pasamos, si la cita es null (no se encuentra),
	 * nos redirije a la página en la que tenemos la lista de las citas.
	 * @param id
	 * @param model
	 * @return String con el nombre de la página del formulario para insertar una nueva cita,
	 * si no encuentra la cita que le pasamos, devuelve String con el nombre de la página en la 
	 * que tenemos la lista de citas.
	 */

	@GetMapping("/editar/{id}")
	public String editarCita(@PathVariable("id") Long id, Model model) {
		Cita cita = citaServicio.findById(id);

		if (cita != null) {
			model.addAttribute("cita", cita);
			model.addAttribute("clientes", clienteServicio.findAll());
			return "admin/form-citas";
		} else {
			return "redirect:/admin/cita/citas";
		}
	}
	
	/**
	 * Método para el borrado de citas, tiene el mismo funcionamiento que el método anterior,
	 * pero al encontrar la cita recogiendo el id, la elimina.
	 * @param id
	 * @param model
	 * @return String con el nombre del html en el que se encuentra la lista de citas.
	 */

	@GetMapping("/borrar/{id}")
	public String borrarCita(@PathVariable("id") Long id, Model model) {

		Cita cita = citaServicio.findById(id);

		if (cita != null) {
			citaServicio.delete(cita);

		}

		return "redirect:/admin/cita/citas";
	}
	
	/**
	 * Método que añade al modelo una lista de Strings
	 * @return Devuelve un método que devuelve una lista de Strings.
	 */

	@ModelAttribute("zonasCuerpos")
	public List<String> zonasCuerpo() {
		return DataMaster.zonasCuerpo();
	}
}
