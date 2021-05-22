package com.salesianostriana.dam.servicio.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.model.Cita;
import com.salesianostriana.dam.model.Cliente;

public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> implements IBaseService<T, ID>{
	
	@Autowired
	protected R repository;
	
	
	
	
	public BaseService(R repo) {
		super();
		this.repository = repo;
	}

	public List<T> findAll(){
		return repository.findAll();
	}
	
	public T findById(ID id) {
		return repository.findById(id).orElse(null);
	}
	
	public T save(T t) {
		return repository.save(t);
	}
	
	public T edit(T t) {
		return save(t);
	}
	
	public void delete(T cita) {
		repository.delete(cita);
	}
	
	public void deleteById(ID id) {
		repository.deleteById(id);
	}
}
