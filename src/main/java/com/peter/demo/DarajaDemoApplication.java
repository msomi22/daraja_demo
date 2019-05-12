package com.peter.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author t_pnjeru
 *
 */
@SpringBootApplication
public class DarajaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DarajaDemoApplication.class, args);
	}
	
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate(); 
	}
	
	@Component
	public class CustomHealthIndicator implements HealthIndicator {
	 
	 @Override
	 public Health health() {
	  int errorCode = 0; 
	  // In the above line,I am simple assigning zero,but you can call Health check related code like below commented line and that method can return the appropriate code.
	  // int errorCode = performHealthCheck();
	  if (errorCode != 0) {
	   return Health.down().withDetail("Error Code", errorCode).build();
	  }
	  return Health.up().build();
	 }
	 
	}

}
