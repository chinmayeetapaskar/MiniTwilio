package com.twilio.auth.authenticationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/db/authToken")
public class AuthTokenController {

	@GetMapping("/hello")
	public String getAuthToken() {
		//String authToken = null;
		return "Hello world";
		
	}
	
	@PostMapping("/addAuthToken")
	public String insertAuthToken() {
		return null;
		
	}
}

