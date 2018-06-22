package com.leysoft.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/greeting"})
public class GreetingController {
	
	@PostMapping
	public String greeting(String name) {
		return "Hello " + name;
	}
}
