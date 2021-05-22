package com.salesianostriana.dam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Clase modelo cliente con etiquetas para que se generen constructores, getters and setters, hashcode, equals y toString automáticamente y
 * asignándola como una entidad.
 * @author Fran
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

	
	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	private String apellidos;
	private String dni;
	private int telefono;
	private String email;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
	private List<Cita> citas = new ArrayList<>();
	
	/**
	 * Constructor sin el id ya que es un atributo autogenerado.
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param telefono
	 * @param email
	 */
	public Cliente(String nombre, String apellidos, String dni, int telefono, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
	}
	
	
	
	
	

	

	
	
	
	
}
