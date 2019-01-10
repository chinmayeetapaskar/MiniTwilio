package com.twilio.MailManagement.mailmanagementservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.twilio.MailManagement.mailmanagementservice.model.Customers;


@RestController
@RequestMapping("/rest/mailmanagement")
public class MailManagementResource {

	@Autowired
	RestTemplate restTemplate;

	
	@GetMapping("/{username}")
	public List<String> getClientList(@PathVariable("username") String userName){
	
		ResponseEntity<List<String>> clientResponse = restTemplate.exchange("http://localhost:8080/db/customers/" +  userName,HttpMethod.GET,
				null, new ParameterizedTypeReference<List<String>>() {});
		
		
		List<String> client = clientResponse.getBody();
		return client;
	}
	
	@GetMapping("/gettoken/{username}")
	public String getAuthToken(@PathVariable("username") String userName){
	
		String authToken= restTemplate.getForObject("http://localhost:8080/rest/customers/gettoken/" + userName, String.class);
		return authToken;
	}
}
