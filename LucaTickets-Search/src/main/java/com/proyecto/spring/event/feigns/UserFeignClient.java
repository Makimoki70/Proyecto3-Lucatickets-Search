package com.proyecto.spring.event.feigns;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.spring.event.model.response.UserResponse;

@FeignClient(name = "user", url= "http://localhost:8888")
public interface UserFeignClient {
	@GetMapping("/user/")
    public List<UserResponse> getAllUsers();
}
