package com.example.JavaBio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.JavaBio", "com.example.JavaBio.Controller"})
@ComponentScan(basePackages = {"com.example.JavaBio", "com.example.JavaBio.DTO"})
@ComponentScan(basePackages = {"com.example.JavaBio", "com.example.JavaBio.Entity"})
@ComponentScan(basePackages = {"com.example.JavaBio", "com.example.JavaBio.Repository"})



@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class JavaBioApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaBioApplication.class, args);
	}

}
