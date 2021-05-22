package com.salesianostriana.dam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.model.Cita;
import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.servicio.CitaServicio;
import com.salesianostriana.dam.servicio.ClienteServicio;

import lombok.RequiredArgsConstructor;

/**
 * Clase para insertar datos de ejemplo.
 * @author Fran
 *
 */
@Component
@RequiredArgsConstructor
public class InitData {
	
	private final ClienteServicio clienteServicio;
	
	private final CitaServicio citaServicio;
	
	@PostConstruct
	public void init() {
		
	
	
	Cliente cl1 = new Cliente ("Francisco", "Gallego Gordillo", "47566488G", 675681277, "frangallego03@gmail.com");
	Cliente cl2 = new Cliente ("Juan Carlos", "Ardana Murillo", "53257823Q", 635259206, "juancarlos@gmail.com");
	Cliente cl3 = new Cliente ("Angel", "Naranjo Gonzalez", "42567274H", 625786478, "angelnaranjo@gmail.com");
	Cliente cl4 = new Cliente ("Sergio", "Chamorro Garcia", "92869385P", 626310495, "sergiochamorro@gmail.com");
	Cliente cl5 = new Cliente ("Jesus", "Barco Perez", "68275038W", 681989378, "jesusbarco@gmail.com");
	
	Cita c1 = new Cita ("Pierna", 45, LocalDateTime.of(2021, 10, 19, 20, 0, 0), LocalTime.of(4, 0), 150, cl1);
	Cita c2 = new Cita ("Gemelo", 60, LocalDateTime.of(2021, 8, 24, 13, 0, 0), LocalTime.of(2, 0), 120, cl2);
	Cita c3 = new Cita ("Espalda", 70, LocalDateTime.of(2021, 9, 15, 12, 0, 0), LocalTime.of(5, 0), 200, cl3);
	Cita c4 = new Cita ("Cuello", 25, LocalDateTime.of(2021, 6, 29, 14, 0, 0), LocalTime.of(1, 0), 75, cl4);
	Cita c5 = new Cita ("Vientre", 68, LocalDateTime.of(2021, 10, 13, 17, 0, 0), LocalTime.of(2, 0), 100, cl5);
	
	clienteServicio.save(cl1);
	clienteServicio.save(cl2);
	clienteServicio.save(cl3);
	clienteServicio.save(cl4);
	clienteServicio.save(cl5);
	
	citaServicio.save(c1);
	citaServicio.save(c2);
	citaServicio.save(c3);
	citaServicio.save(c4);
	citaServicio.save(c5);
	}
	
}
