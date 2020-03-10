package com.nagarro.stocks.dao;

import java.util.List;

import com.nagarro.stocks.model.Stock;

/**
 * Interface to access Stock Data
 * 
 * @author yankitchauhan
 *
 */
public interface StockDAO {

	/**
	 * Returns stocks of all products.
	 * 
	 * @return list of stocks
	 */
	List<Stock> getStocksOfAllProducts();
}
