package com.peter.demo.controller;

import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.peter.demo.controller.client.RestClient;

@RestController
public class MainController {
	

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	RestClient restClient;

	@RequestMapping(path = "/auth/{id}", method = RequestMethod.GET)
	public Object serviceAuth(@PathVariable("id") String id) throws URISyntaxException {
		
		System.out.println("Client Id" + id); 
		
		return restClient.getAccessToken(); 
	}

	
}
