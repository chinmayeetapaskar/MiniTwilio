package com.twilio.databaseservice.databaseservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.twilio.databaseservice.databaseservice.document.Customers;


public interface CustomersRepository  extends MongoRepository<Customers, String>{

	Customers findByUserName(String username);

}
