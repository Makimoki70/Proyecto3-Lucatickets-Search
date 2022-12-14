package com.proyecto.spring.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.proyecto.spring.event.feigns.EventFeignClient;
import com.proyecto.spring.event.feigns.UserFeignClient;
import com.proyecto.spring.event.model.response.EventResponse;
import com.proyecto.spring.event.model.response.UserResponse;


/**
 * 
 * Nombre de clase: EventService
 * Descripcion: Clase de la capa service, añade los siguientes metodos:
 * getAllEvent, que mostrara todos los eventos añadidos actualmente a la BBDD.
 * getEventsByType, que filtra entre los eventos y busca por tipo de sala de recinto.
 * getEventsByName, que filtra entre los eventos y busca por nombre.
 * Fecha: 05/12/2022
 * @author Joel y Alberto
 * @version 0.1
 * @since 0.1
 * 
 * */
@Service
public class SearchService {
	@Autowired
	private EventFeignClient eventFeign;
	
	@Autowired
	private UserFeignClient userFeign;
	
	/**
     * Método que toma del microservicio Event un listado de los eventos en la BBDD.
     * @return el listado de eventos actualmente existente en la BBDD
     */
	public List<EventResponse> getAllEvent() {
		return eventFeign.getAllEvent();
	}
	
	/**
     * Método que toma del microservicio Event un listado de los eventos en la BBDD por tipo de recinto.
     * @return el listado de eventos actualmente existente en la BBDD filtrado por tipo
     */
	public List<EventResponse> getEventByType(@PathVariable String tipo){
		return eventFeign.getEventByType(tipo);
	}
	
	/**
     * Método que toma del microservicio Event un listado de los eventos en la BBDD por nombre.
     * @return el listado de eventos actualmente existente en la BBDD filtrado por nombre
     */
	public List<EventResponse> getEventByName(@PathVariable String name){
		return eventFeign.getEventByName(name);
	}
	
	public List<UserResponse> getAllUsers() {
		return userFeign.getAllUsers();
	}
}
