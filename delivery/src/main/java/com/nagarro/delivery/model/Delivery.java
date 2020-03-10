package com.nagarro.delivery.model;

import com.nagarro.delivery.enums.DeliveryStatus;

/**
 * Delivery Model
 * 
 * @author yankitchauhan
 *
 */
public class Delivery {

	private String orderCode;
	private DeliveryStatus status;

	/**
	 * Constructor to create Delivery Entry
	 * 
	 * @param orderCode the order code
	 * @param status    the delivery status
	 */
	public Delivery(String orderCode, DeliveryStatus status) {
		this.setOrderCode(orderCode);
		this.setStatus(status);
	}

	/**
	 * Default Constructor
	 */
	public Delivery() {

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
	 * @return the status
	 */
	public DeliveryStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

}
