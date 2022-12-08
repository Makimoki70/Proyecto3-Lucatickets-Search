package com.proyecto.spring.event.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.proyecto.spring.event.feignEvents.EventFeignClient;
import com.proyecto.spring.event.model.response.EventResponse;


@Service
public class SearchService {
	@Autowired
	private EventFeignClient eventFeign;
	
	public List<EventResponse> getAllEvent() {
		return eventFeign.getAllEvent();
	}
	
	public List<EventResponse> getEventByType(@PathVariable String tipo){
		
		return eventFeign.getEventByType(tipo);
		
	}
	
	
	
}
