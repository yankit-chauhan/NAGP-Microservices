package com.nagarro.prices.service;

import java.util.List;

import com.nagarro.prices.model.Price;

/**
 * Interface that exposes various price related methods
 * 
 * @author yankitchauhan
 *
 */
public interface PriceCalculationService {

	/**
	 * Returns prices of all products.
	 * 
	 * @return list of all products.
	 */
	List<Price> getAllPrices();

	/**
	 * Returns price of all products
	 * 
	 * @param productCode the product code
	 * @return price
	 */
	Double getPriceforProductCode(String productCode);
}
