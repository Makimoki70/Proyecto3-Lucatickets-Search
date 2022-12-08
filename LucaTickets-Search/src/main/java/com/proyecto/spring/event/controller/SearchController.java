package com.proyecto.spring.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.spring.event.model.response.EventResponse;
import com.proyecto.spring.event.service.SearchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/search/")
public class SearchController {
	@Autowired
	private SearchService searchService;
	
	@Operation(summary = "Pedir lista eventos", description = "Pide los eventos al microservicio de Event, devuelve una lista", tags= {"search"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista devuelta", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			})
	@GetMapping("/events")
	public List<EventResponse> getAllEvent(){
		return searchService.getAllEvent();
	}
}