package com.salesianostriana.dam.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.model.Cita;
import com.salesianostriana.dam.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByNombreContainsIgnoreCaseOrderByNombreAsc(String nombre);

}
