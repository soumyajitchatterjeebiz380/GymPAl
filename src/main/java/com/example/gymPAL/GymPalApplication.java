package com.example.gymPAL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class GymPalApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GymPalApplication.class, args);
	}

}
