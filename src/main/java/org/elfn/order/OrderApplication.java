package org.elfn.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Bean  // Déclare un bean pour le contexte Spring.
	@LoadBalanced
	// Indique que le RestTemplate utilisera Ribbon pour le Load Balancing entre les instances de service.
	public RestTemplate getRestTemplate() {
		return new RestTemplate();  // Crée et retourne une nouvelle instance de RestTemplate.
	}


}
