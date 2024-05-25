package com.ms.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Server;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApiAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApiAppApplication.class, args);
		System.out.println("Application Started on port number 9090");
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
