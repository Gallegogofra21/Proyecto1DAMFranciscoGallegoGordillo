package com.salesianostriana.dam.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.model.Cita;
import com.salesianostriana.dam.model.Cliente;

public interface CitaRepository extends JpaRepository<Cita, Long>{

	public List<Cita> findByCliente(Cliente cliente);
	
	@Query("select p.id from Cita p")
	public List<Long> obtenerIds();
	
	@Query("select p from Cita p where p.cliente.id = ?1")
	public List<Cita> findByClienteId(Long clienteId);
	
	@Query("select count(p) from Cita p where p.cliente = ?1")
	public int findNumCitasByClientes(Cliente cliente);

	
	
	
}
