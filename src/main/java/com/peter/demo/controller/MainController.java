package com.peter.demo.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.peter.demo.controller.client.RestClient;
import com.peter.demo.entity.TokenEntity;

@RestController
public class MainController {


	@Autowired
	RestTemplate restTemplate;

	@Autowired
	RestClient restClient;
	@Autowired
	private EntityService entityService;

	@RequestMapping(path = "/auth/{id}", method = RequestMethod.GET)
	public Object serviceAuth(@PathVariable("id") String id) throws URISyntaxException {

		System.out.println("Client Id" + id); 

		return restClient.getAccessToken(); 
	}

	@RequestMapping(path="/tokens", method=RequestMethod.GET)
	public ResponseEntity<Object> findAll(){ 
		System.out.println("get all stored tokens"); 
		List<TokenEntity> list = entityService.findAll();
		System.out.println("get all stored tokens" + list); 
		return ResponseEntity.ok(list);
	}


}
