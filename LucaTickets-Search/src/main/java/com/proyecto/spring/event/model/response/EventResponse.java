package com.proyecto.spring.event.model.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

/**
 * 
 * Nombre de clase: EventResponse.
 * Descripcion: model DTO
 * Fecha: 09/12/2022
 * @author Joel y Alberto
 * @version 0.1
 * @since 0.1
 * 
 * */
public @Data class EventResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param nombre: Como se llama el evento
	 * 
	 * */
	private String nombre,
	
	/**
	 * 
	 * @param corta: Descripcion corta del evento
	 * 
	 * */
	corta,
	
	/**
	 * 
	 * @param extendida: Descripcion larga del evento
	 * 
	 * */
	extendida,
	
	/**
	 * 
	 * @param foto: Imagen descriptiva del evento
	 * 
	 * */
	foto,
	
	/**
	 * 
	 * @param normas: Las normas de conducta para asistir al evento
	 * 
	 * */
	normas;
	
	/**
	 * 
	 * @param Fecha: Dia del calendario en el que da inicio el evento
	 * 
	 * */
	private LocalDate fecha;
	
	/**
	 * 
	 * @param hora: Hora a la que comienza el evento
	 * 
	 * */
	private LocalTime hora,
	
	/**
	 * 
	 * @param minimo: Hora minima, coincide con la hora de inicio del evento
	 * 
	 * */
	minimo,
	
	/**
	 * 
	 * @param maximo: Hora a la que comienza el evento
	 * 
	 * */
	maximo;
	
	/**
	 * 
	 * @param precio: Precio de venta del evento
	 * 
	 * */
	private Double precio;
	
	/**
	 * 
	 * @param sala: Tipo de sala en la que se efectua el evento
	 * 
	 * */
	private Recinto sala;	
}
