package com.Quiz_Microservice.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class CorsConfiguration {

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/Quiz**")
		.allowedOrigins("http://localhost:3000")
		.allowedMethods("*")
		.allowedHeaders("authorization", "application");
	
		

	}
}


