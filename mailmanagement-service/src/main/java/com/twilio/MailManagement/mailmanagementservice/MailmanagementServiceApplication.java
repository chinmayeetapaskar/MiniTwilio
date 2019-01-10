package com.twilio.MailManagement.mailmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@EnableEurekaClient
@SpringBootApplication
public class MailmanagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailmanagementServiceApplication.class, args);
	}

}

