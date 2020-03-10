package com.nagarro.delivery.dao;

import java.util.List;

import com.nagarro.delivery.model.Delivery;

/**
 * Interface to access Order Delivery Data
 * 
 * @author yankitchauhan
 *
 */
public interface DeliveryDAO {

	/**
	 * Returns Delivery Information of all orders.
	 * 
	 * @return list of delivery
	 */
	List<Delivery> getDeliveryOfAllOrders();

	/**
	 * Returns Delivery Information for single order.
	 * 
	 * @param orderCode the order code
	 * @return delivery information for order code
	 */
	Delivery getDeliveryForOrderCode(String orderCode);
}
