package com.proyecto.spring.event.feignEvents;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.spring.event.model.response.EventResponse;

@FeignClient(name = "event", url= "http://localhost:7777")
public interface EventFeignClient {
	@GetMapping("/event/")
    public List<EventResponse> getAllEvent();
}