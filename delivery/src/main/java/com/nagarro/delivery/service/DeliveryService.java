package com.nagarro.delivery.service;

import com.nagarro.delivery.enums.DeliveryStatus;
import com.nagarro.delivery.model.Delivery;

/**
 * Interface that exposes various Delivery related methods.
 * 
 * @author yankitchauhan
 *
 */
public interface DeliveryService {

	/**
	 * Returns Delivery Status for specific order.
	 * 
	 * @param orderCode the order code
	 * @return Delivery Information
	 */
	Delivery getDeliveryStatus(String orderCode);

	/**
	 * Updates Delivery Status of specific order.
	 * 
	 * @param orderCode the order code
	 * @param status    the delivery status
	 * @return Updated Delivery Information
	 */
	Delivery changeDeliveryStatus(String orderCode, DeliveryStatus status);

}
