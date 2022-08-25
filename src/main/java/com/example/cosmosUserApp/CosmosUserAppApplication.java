package com.example.cosmosUserApp;

import com.example.cosmosUserApp.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class CosmosUserAppApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(CosmosUserAppApplication.class);

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CosmosUserAppApplication.class, args);
	}
}