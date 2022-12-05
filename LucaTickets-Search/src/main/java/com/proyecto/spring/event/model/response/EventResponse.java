package com.proyecto.spring.event.model.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

public @Data class EventResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombre, corta, extendida, foto, normas;
	private LocalDate fecha;
	private LocalTime hora, minimo, maximo;
	private Double precio;
	private Recinto sala;	
}
