package com.nagarro.stocks.sevice;

import java.util.List;

import com.nagarro.stocks.model.Stock;

/**
 * Interface that exposes various stock related methods.
 * 
 * @author yankitchauhan
 *
 */
public interface StockService {

	/**
	 * Returns Stock of all products.
	 * 
	 * @return list of stocks
	 */
	List<Stock> getStocksofAllProducts();

	/**
	 * Return stock for single product.
	 * 
	 * @param productCode the product code
	 * @return available quantity
	 */
	Long getStockForProductCode(String productCode);
}
