package com.nagarro.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * This class contains Main method of the Delivery Microservice.
 * 
 * @author yankitchauhan
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryApplication.class, args);
	}

}
