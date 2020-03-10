package com.nagarro.orders.model;

import java.util.List;

/**
 * Abstract Order Model
 * 
 * @author yankitchauhan
 *
 */
public abstract class AbstractOrder {

	private String orderCode;
	private List<OrderEntry> orderEntries;
	private Double totalPrice;
	private String userId;

	/**
	 * Constructor to create new object of AbstractOrder
	 * 
	 * @param orderCode    the order code
	 * @param orderEntries the list of order entries
	 * @param totalPrice   the total price of order
	 * @param userId       the User Id
	 */
	public AbstractOrder(String orderCode, List<OrderEntry> orderEntries, Double totalPrice, String userId) {
		this.orderCode = orderCode;
		this.orderEntries = orderEntries;
		this.totalPrice = totalPrice;
		this.setUserId(userId);
	}

	/**
	 * Default Constructor
	 */
	public AbstractOrder() {

	}

	/**
	 * Constructor to create new object of AbstractOrder
	 * 
	 * @param orderCode the order code
	 * @param orderEntries the list of order entries
	 */
	public AbstractOrder(String orderCode, List<OrderEntry> orderEntries) {
		this.orderCode = orderCode;
		this.orderEntries = orderEntries;
	}

	/**
	 * @return the orderCode
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * @param orderCode the orderCode to set
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * @return the orderEntries
	 */
	public List<OrderEntry> getOrderEntries() {
		return orderEntries;
	}

	/**
	 * @param orderEntries the orderEntries to set
	 */
	public void setOrderEntries(List<OrderEntry> orderEntries) {
		this.orderEntries = orderEntries;
	}

	/**
	 * @return the totalPrice
	 */
	public Double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
