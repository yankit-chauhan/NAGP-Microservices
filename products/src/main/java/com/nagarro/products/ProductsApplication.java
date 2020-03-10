package com.nagarro.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * This class contains Main method of the Product Microservice.
 * 
 * @author yankitchauhan
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

	@Bean(name = "restTemp")
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
