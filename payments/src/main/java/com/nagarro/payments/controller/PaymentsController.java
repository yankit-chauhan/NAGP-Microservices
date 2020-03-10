package com.nagarro.payments.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller exposes all payment APIs.
 * 
 * @author yankitchauhan
 *
 */
@RestController
@RequestMapping(value = "/payments")
public class PaymentsController {

	@Value("${server.port}")
	private int port;

	private static final Logger logger = LoggerFactory.getLogger(PaymentsController.class);

	/**
	 * Returns payment status
	 * 
	 * @param orderCode
	 * @return payment status
	 */
	@GetMapping
	Boolean getPaymentStatus(@RequestParam(name = "orderCode") String orderCode) {
		logger.info("In Payments Controller  -->>  getPaymentStatus Method");
		return true;
	}

}
