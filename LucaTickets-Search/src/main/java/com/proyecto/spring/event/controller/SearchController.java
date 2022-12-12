package com.proyecto.spring.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.spring.event.model.response.EventResponse;
import com.proyecto.spring.event.service.SearchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * 
 * Nombre de clase: SearchController. Descripcion: Controlador del microservicio Search.
 * Implementa el metodo add a la base de datos, las busquedas por nombre y tipo de evento.
 * Fecha: 09/12/2022
 * 
 * @author Alberto Egea y Joel Pascual
 * @version 0.2
 * @since 0.1
 * 
 */

@RestController
@RequestMapping("/search/")
public class SearchController {
	@Autowired
	private SearchService searchService;
	
	@Operation(summary = "Pedir lista eventos", 
			description = "Pide los eventos al microservicio de Event, devuelve una lista de todos los locales", tags= {"search"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista devuelta", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			})
	@GetMapping("/events")
	public List<EventResponse> getAllEvent(){
		return searchService.getAllEvent();
	}
	
	@Operation(summary = "Pedir lista de eventos por tipo de local", 
			description = "Pide los eventos al microservicio de Event, devuelve una lista de todos los eventos que tengan el tipo de local especificado", tags= {"search"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista devuelta", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			})
	@GetMapping("/events/type/{tipo}")
	public List<EventResponse> getEventByType(@PathVariable String tipo){
		return searchService.getEventByType(tipo);		
	}
	
	@Operation(summary = "Pedir lista de eventos por nombre", 
			description = "Pide los eventos al microservicio de Event, devuelve una lista de todos los eventos que tengan el nombre especificado", tags= {"search"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista devuelta", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			})
	@GetMapping("/events/name/{name}")
	public List<EventResponse> getEventByName(@PathVariable String name){
		return searchService.getEventByName(name);	
	}
	
	@Operation(summary = "Actualizar un evento existente", 
			description = "Pide un evento concreto por medio de la id al microservicio Event, devuelve el evento con la update aplicada", tags= {"search"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento actualizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Evento inexistente ", content = @Content),
			})
	@GetMapping("/events/{id}")
	public List<EventResponse> updateEvent(@PathVariable Long id){
		return searchService.updateEvent(id);	
	}
}