package com.nagarro.prices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * This class contains Main method of the Prices Microservice.
 * 
 * @author yankitchauhan
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PricesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PricesApplication.class, args);
	}

}
