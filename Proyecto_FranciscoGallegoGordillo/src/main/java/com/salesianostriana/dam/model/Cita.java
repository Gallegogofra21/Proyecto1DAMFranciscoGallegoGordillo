package com.salesianostriana.dam.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Clase modelo Cita anotada con etiquetas para que se generen constructores, getters and setters, hashcode, equals y toString automáticamente y 
 * asignándola como una Entidad.
 * @author Fran
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Cita {

	@Id
	@GeneratedValue

	private long id;

	private String zonaCuerpo;
	private double tamanioPieza;

	@DateTimeFormat (iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime horaCita;

	private LocalTime tiempoPrevisto;
	private double precio;

	@ManyToOne
	private Cliente cliente;
	
	/**
	 * Constructor sin el id ya que es un atributo autogenerado.
	 * @param zonaCuerpo
	 * @param tamanioPieza
	 * @param horaCita
	 * @param tiempoPrevisto
	 * @param precio
	 * @param cliente
	 */

	public Cita(String zonaCuerpo, double tamanioPieza, LocalDateTime horaCita, LocalTime tiempoPrevisto, double precio,
			Cliente cliente) {
		super();
		this.zonaCuerpo = zonaCuerpo;
		this.tamanioPieza = tamanioPieza;
		this.horaCita = horaCita;
		this.tiempoPrevisto = tiempoPrevisto;
		this.precio = precio;
		this.cliente = cliente;
	}

	/**
	 * Constructor sin el Objeto Cliente.
	 * @param id
	 * @param zonaCuerpo
	 * @param tamanioPieza
	 * @param horaCita
	 * @param tiempoPrevisto
	 * @param precio
	 */
	public Cita(long id, String zonaCuerpo, double tamanioPieza, LocalDateTime horaCita, LocalTime tiempoPrevisto,
			double precio) {
		super();
		this.id = id;
		this.zonaCuerpo = zonaCuerpo;
		this.tamanioPieza = tamanioPieza;
		this.horaCita = horaCita;
		this.tiempoPrevisto = tiempoPrevisto;
		this.precio = precio;
	}
	
	
	
	

	
	
}
