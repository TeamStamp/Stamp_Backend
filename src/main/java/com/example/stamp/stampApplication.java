package com.example.stamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication


public class stampApplication {

	public static void main(String[] args) {
		SpringApplication.run(stampApplication.class, args);
	}

}
