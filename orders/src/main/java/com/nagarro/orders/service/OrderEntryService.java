package com.nagarro.orders.service;

import com.nagarro.orders.model.OrderEntry;

/**
 * Interface to various Order Entry Services.
 * 
 * @author yankitchauhan
 *
 */
public interface OrderEntryService {

	/**
	 * Creates and return Order Entry
	 * 
	 * @param productCode the product code
	 * @param quantity    the quantity of product
	 * @return orderEntry
	 */
	OrderEntry createOrderEntry(String productCode, Long quantity);

	/**
	 * Returns Order Entry for the product.
	 * 
	 * @param productCode the product code
	 * @param orderCode   the order code
	 * @return orderEntry
	 */
	OrderEntry getOrderEntryForProduct(String productCode, String orderCode);
}
