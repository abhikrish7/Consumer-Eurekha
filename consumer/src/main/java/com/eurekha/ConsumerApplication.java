package com.eurekha;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.eurekha.controller.ConsumerController;

@SpringBootApplication
public class ConsumerApplication {

	
	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext context= SpringApplication.run(ConsumerApplication.class, args);
		ConsumerController consumerController = context.getBean(ConsumerController.class);
		System.out.println("Consumer Application");
		consumerController.getStudentinfo();		
	}
	
	@Bean
	public ConsumerController consumerController() {
		
		return new ConsumerController();
	}
}
