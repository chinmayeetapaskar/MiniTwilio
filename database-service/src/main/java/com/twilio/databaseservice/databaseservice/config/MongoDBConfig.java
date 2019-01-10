package com.twilio.databaseservice.databaseservice.config;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.twilio.databaseservice.databaseservice.repository.CustomersRepository;

import com.twilio.databaseservice.databaseservice.document.Customers;

@EnableMongoRepositories(basePackageClasses=CustomersRepository.class)
@Configuration
public class MongoDBConfig {
	
	private CustomersRepository customerRepository;
	
	

	public MongoDBConfig(CustomersRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}



	@Bean
	CommandLineRunner commandLineRunner(CustomersRepository customerRepository) {
		return strings ->{
			customerRepository.save(new Customers("sss","Uber","Uber@gmail.com","Uber", new ArrayList<String>()));
			customerRepository.save(new Customers("lll","Lyft","Uber@gmail.com","Uber", new ArrayList<String>()));
		};
		
		 
	}
}
