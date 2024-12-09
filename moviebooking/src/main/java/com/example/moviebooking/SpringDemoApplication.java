package com.example.moviebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableJpaRepositories(basePackages = "com.example.moviebooking.repository")
@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
