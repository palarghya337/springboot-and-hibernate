package com.practice.hibernate.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.practice.hibernate")
public class HibernatePracticeMain {

	public static void main(String[] args) {
		
		SpringApplication.run(HibernatePracticeMain.class, args);
	}
}
