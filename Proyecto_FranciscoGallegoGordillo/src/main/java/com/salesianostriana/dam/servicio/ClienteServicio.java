package com.salesianostriana.dam.servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Cita;
import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.repos.CitaRepository;
import com.salesianostriana.dam.repos.ClienteRepository;
import com.salesianostriana.dam.servicio.base.BaseService;

import lombok.RequiredArgsConstructor;

@Service
public class ClienteServicio extends BaseService<Cliente, Long, ClienteRepository>{
	
	@Autowired
	private ClienteRepository repositorio;
	
	public ClienteServicio(ClienteRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	

	public List<Cliente> clientesNombre(String nombre){
		return this.repositorio.findByNombreContainsIgnoreCaseOrderByNombreAsc(nombre);
	}

	

}
