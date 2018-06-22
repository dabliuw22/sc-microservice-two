package com.leysoft.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leysoft.dto.GreetingRequest;
import com.leysoft.dto.GreetingResponse;

@RestController
@RequestMapping(value = {"/greeting"})
public class GreetingController {
	
	@PostMapping
	public GreetingResponse greeting(@RequestBody GreetingRequest request) {
		GreetingResponse response = new GreetingResponse();
		response.setMessage("Hello " + request.getName());
		return response;
	}
}
