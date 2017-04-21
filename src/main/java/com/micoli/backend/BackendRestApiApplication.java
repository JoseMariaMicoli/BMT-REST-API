package com.micoli.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class BackendRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendRestApiApplication.class, args);
	}
}
