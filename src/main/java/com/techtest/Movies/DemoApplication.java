package com.techtest.Movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public WebMvcConfigurer corsConfigurer() {
			 return new WebMvcConfigurer() {
					 @Override
					 public void addCorsMappings(CorsRegistry registry) {
							 registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
					 }
			 };
	 }

}
