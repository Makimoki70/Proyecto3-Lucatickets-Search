package com.proyecto.spring.event;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.proyecto.spring.event.controller.SearchController;
import com.proyecto.spring.event.model.response.EventResponse;
import com.proyecto.spring.event.model.response.Recinto;
import com.proyecto.spring.event.model.response.Tipo;

@WebMvcTest(SearchController.class)
public class Test10_FindEventsByType {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SearchController sc;

	@Test
	void contextLoads() throws Exception {
		
		EventResponse eventResponse = new EventResponse();
		
		LocalDate myDate = LocalDate.parse("01-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		LocalTime myHora = LocalTime.parse("20:00");
		LocalTime myMinimo = LocalTime.parse("17:00");
		LocalTime myMaximo = LocalTime.parse("22:00");

		eventResponse.setNombre("Concierto SoldeVita");
		eventResponse.setCorta("concierto debut del grupo");
		eventResponse.setExtendida("concierto debut del grupo conformado por 8 miembros prometedores de Latino america y Espana");
		eventResponse.setFoto("c:/SolDeVita/FotoDebut");
		eventResponse.setNormas("Solo personal invitado");
		eventResponse.setFecha(myDate);
		eventResponse.setHora(myHora);
		eventResponse.setMinimo(myMinimo);
		eventResponse.setMaximo(myMaximo);
		eventResponse.setPrecio(200.0);
		
		Recinto sala = new Recinto();
		sala.setNombre("Terraza Rincon de los poetas");
		sala.setCiudad("Madrid");
		sala.setDireccion("Gran via");
		sala.setTipoRecinto(Tipo.terraza);
		sala.setAforo(500);
		
		eventResponse.setSala(sala);
		
		List<EventResponse> list = new ArrayList<>();
		list.add(eventResponse);
		
		when(sc.getEventByType("terraza")).thenReturn(list);
		
		assertThat(sc.getEventByType("terraza").size()==1);
	}
}
