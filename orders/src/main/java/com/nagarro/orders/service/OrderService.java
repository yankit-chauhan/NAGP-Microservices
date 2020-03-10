package com.nagarro.orders.service;

import java.util.List;

import com.nagarro.orders.model.Order;

/**
 * Interface to provide various order services.
 * 
 * @author yankitchauhan
 *
 */
public interface OrderService {

	/**
	 * Returns all orders of a user
	 * 
	 * @param userId the user id
	 * @return list of orders
	 */
	List<Order> getOrdersForUser(String userId);
	
	/**
	 * Method to Place Order.
	 * 
	 * @param orderCode the order code
	 * @return order
	 */
	Order placeOrder(String orderCode);
	
	/**
	 * Returns Payment Status for the Order Code
	 * 
	 * @param orderCode the order code
	 * @return payment status
	 */
	Boolean getPaymentStatus(String orderCode);
}
