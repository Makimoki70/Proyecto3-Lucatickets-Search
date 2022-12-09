package com.proyecto.spring.event.feignEvents;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.proyecto.spring.event.model.response.EventResponse;

@FeignClient(name = "event", url= "http://localhost:7777")
public interface EventFeignClient {
	@GetMapping("/event/")
    public List<EventResponse> getAllEvent();
	
	@GetMapping("/event/tipo/{tipo}")
	public List<EventResponse> getEventByType(@PathVariable String tipo);
	
	@GetMapping("/event/name/{name}")
	public List<EventResponse> getEventByName(@PathVariable String name);
}