package com.techtest.Movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	public WebMvcConfigurer corsConfigurer() {
			 return new WebMvcConfigurer() {
					 @Override
					 public void addCorsMappings(CorsRegistry registry) {
							 registry.addMapping("/movies").allowedOrigins("*");
					 }
			 };
	 }

}
