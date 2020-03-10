package com.nagarro.orders.model;

import java.util.List;

/**
 * Cart Model
 * 
 * @author yankitchauhan
 *
 */
public class Cart extends AbstractOrder {

	/**
	 * Constructor to create new object of cart
	 * 
	 * @param orderCode    the cart code
	 * @param orderEntries the list of order entries
	 * @param totalPrice   the total price of cart
	 * @param userId       the User Id
	 */
	public Cart(String orderCode, List<OrderEntry> orderEntries, Double totalPrice, String userId) {
		super(orderCode, orderEntries, totalPrice, userId);
	}

	/**
	 * Default Constructor
	 */
	public Cart() {

	}
}
