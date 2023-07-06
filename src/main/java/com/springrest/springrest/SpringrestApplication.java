package com.springrest.springrest;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring-Boot Course Application", version = "1.0", description = "My first REST Application in Java Springboot"
))

public class SpringrestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringrestApplication.class, args);
	}

}
