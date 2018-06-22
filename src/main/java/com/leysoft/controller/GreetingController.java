package com.leysoft.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leysoft.dto.GreetingRequest;
import com.leysoft.dto.GreetingResponse;

@RestController
@RequestMapping(value = {"/greeting"})
public class GreetingController {
	
	@PostMapping
	public GreetingResponse greeting(GreetingRequest request) {
		GreetingResponse response = new GreetingResponse();
		response.setMessage("Hello " + request.getName());
		return response;
	}
}
