package com.nagarro.delivery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.delivery.enums.DeliveryStatus;
import com.nagarro.delivery.model.Delivery;
import com.nagarro.delivery.service.DeliveryService;

/**
 * Controller to expose various order delivery related APIs.
 * 
 * @author yankitchauhan
 *
 */
@RestController
@RequestMapping(value = "/delivery")
public class DeliveryController {

	@Value("${server.port}")
	private int port;

	@Autowired
	DeliveryService deliveryService;

	private static final Logger logger = LoggerFactory.getLogger(DeliveryController.class);

	/**
	 * Returns Delivery Status for Order Code
	 * 
	 * @param orderCode the order Code
	 * @return Delivery Object
	 */
	@GetMapping(value = "/status")
	Delivery getDeliveryStatus(@RequestParam(name = "orderCode") String orderCode) {
		logger.info("In DeliveryController  --  >>  getDeliveryStatus Method");
		logger.info("Working from port " + port + " of delivery service");
		return deliveryService.getDeliveryStatus(orderCode);
	}

	/**
	 * Changes and return the new delivery status
	 * 
	 * @param orderCode the order code
	 * @param status    the new delivery status
	 * @return Delivery Object
	 */
	@PostMapping("/changeStatus")
	Delivery changeDeliveryStatus(@RequestParam(name = "orderCode") String orderCode,
			@RequestParam(name = "deliveryStatus") DeliveryStatus status) {
		logger.info("In DeliveryController  --  >>  changeDeliveryStatus Method");
		logger.info("Working from port " + port + " of delivery service");
		return deliveryService.changeDeliveryStatus(orderCode, status);
	}
}
