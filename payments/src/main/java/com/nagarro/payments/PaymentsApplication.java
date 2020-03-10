package com.nagarro.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * This class contains Main method of the Payments Microservice.
 * 
 * @author yankitchauhan
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsApplication.class, args);
	}

}
