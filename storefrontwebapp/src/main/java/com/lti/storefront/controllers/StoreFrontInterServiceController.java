package com.lti.storefront.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class StoreFrontInterServiceController {
	
	@Autowired
	private RestTemplate restTemplate;
		
	@Value("${inventoryServiceUrl}")
	private String serviceUrl;
		
		
	@GetMapping("/categories")
	public String loadCategories()
	{
	
		//synchronized inter service communication
	 ResponseEntity<String> response=restTemplate.exchange(serviceUrl, 
			 HttpMethod.GET,null,String.class);		  
	 return response.getBody();
	 
	}
}
