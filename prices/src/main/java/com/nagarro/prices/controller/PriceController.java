package com.nagarro.prices.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.prices.service.PriceCalculationService;

/**
 * This controller contains all the methods to provide prices of products.
 * 
 * @author yankitchauhan
 *
 */
@RestController
@RequestMapping(value = "/prices")
public class PriceController {

	@Value("${server.port}")
	private int port;

	@Resource
	PriceCalculationService priceCalculationService;
	
	private static final Logger logger = LoggerFactory.getLogger(PriceController.class);

	/**
	 * Returns price for specific product
	 * 
	 * @param productCode
	 * @return product price
	 */
	@GetMapping
	Double getProductPrice(@RequestParam(name = "productCode") String productCode) {
		logger.info("In Price Controller  -->>  getProductPrice Method");
		logger.info("Working from port " + port + " of price service");
		return priceCalculationService.getPriceforProductCode(productCode);
	}

	/**
	 * @return the priceCalculationService
	 */
	public PriceCalculationService getPriceCalculationService() {
		return priceCalculationService;
	}

	/**
	 * @param priceCalculationService the priceCalculationService to set
	 */
	public void setPriceCalculationService(PriceCalculationService priceCalculationService) {
		this.priceCalculationService = priceCalculationService;
	}

}
