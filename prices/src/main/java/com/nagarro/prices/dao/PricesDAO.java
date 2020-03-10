package com.nagarro.prices.dao;

import java.util.List;

import com.nagarro.prices.model.Price;

/**
 * Interface to provide access to Prices Data
 * 
 * @author yankitchauhan
 *
 */
public interface PricesDAO {

	/**
	 * Returns prices of all products.
	 * 
	 * @return list of all prices
	 */
	List<Price> getAllPrices();
}
