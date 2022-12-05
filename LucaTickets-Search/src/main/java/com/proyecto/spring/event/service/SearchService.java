package com.proyecto.spring.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.event.feignEvents.EventFeignClient;
import com.proyecto.spring.event.model.response.EventResponse;

@Service
public class SearchService {
	@Autowired
	private EventFeignClient eventFeign;
	
	public List<EventResponse> getAllEvent() {
		return eventFeign.getAllEvent();
	}
}
