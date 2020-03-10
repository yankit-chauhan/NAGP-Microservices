package com.nagarro.orders.model;

import java.util.List;

import com.nagarro.orders.enums.OrderStatus;

/**
 * Order Model
 * 
 * @author yankitchauhan
 *
 */
public class Order extends AbstractOrder {
	private OrderStatus orderStatus;

	/**
	 * Constructor to create new object of Order
	 * 
	 * @param orderCode    the order code
	 * @param orderEntries the list of order entries
	 * @param totalPrice   the total price of order
	 * @param userId       the User Id
	 * @param status       the Order Status
	 */
	public Order(String orderCode, List<OrderEntry> orderEntries, Double totalPrice, String userId,
			OrderStatus status) {
		super(orderCode, orderEntries, totalPrice, userId);
		this.orderStatus = status;
	}

	/**
	 * Default Constructor
	 */
	public Order() {

	}

	/**
	 * @return the orderStatus
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

}
