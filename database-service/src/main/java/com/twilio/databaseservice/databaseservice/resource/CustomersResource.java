package com.twilio.databaseservice.databaseservice.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.databaseservice.databaseservice.document.Customers;
import com.twilio.databaseservice.databaseservice.repository.CustomersRepository;

@RestController
@RequestMapping("/rest/db")
public class CustomersResource {


private CustomersRepository customerRepository;
	

	public CustomersResource(CustomersRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@GetMapping("/gettoken/{username}")
	public String getauthToken(@PathVariable("username") String username) {
		Customers customer= this.customerRepository.findByUserName(username);
		return customer.getAuthToken();
	}
	
	@PostMapping("/add")
	public String insert(@RequestBody Customers customer) {
		this.customerRepository.insert(customer);
		return "added";
		
	}
	
	@GetMapping("/{username}")
	public List<String> getClient(@PathVariable("username") String username) {
		Customers customer= this.customerRepository.findByUserName(username);
		return customer.getClientEmailIds();
	}
}
