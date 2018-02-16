package com.eurekha.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ConsumerController {

	Logger logger = Logger.getLogger(ConsumerController.class);

	public void getStudentinfo() throws RestClientException, IOException {

		String studenturl = "http://localhost:8000/apps/getStudentData";
		logger.info("Started getting Student Information");
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = rest.exchange(studenturl, HttpMethod.GET, getHeaders(), String.class);
		} catch (RestClientException | IOException e) {
			System.out.println("Exception: " + e);
		}
		
		System.out.println(response.getBody());
	}

	private HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

}
