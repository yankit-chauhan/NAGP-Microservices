package com.nagarro.delivery.service.impl;

import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nagarro.delivery.dao.DeliveryDAO;
import com.nagarro.delivery.enums.DeliveryStatus;
import com.nagarro.delivery.model.Delivery;
import com.nagarro.delivery.service.DeliveryService;

/**
 * This class implements the methods of DeliveryService to provide delivery
 * information of orders.
 * 
 * @author yankitchauhan
 *
 */
@Service("deliveryService")
public class DefaultDeliveryService implements DeliveryService {

	@Resource
	private DeliveryDAO deliveryDAO;

	private static final Logger logger = LoggerFactory.getLogger(DefaultDeliveryService.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Delivery getDeliveryStatus(String orderCode) {
		return deliveryDAO.getDeliveryForOrderCode(orderCode);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Delivery changeDeliveryStatus(String orderCode, DeliveryStatus status) {
		Delivery delivery = deliveryDAO.getDeliveryForOrderCode(orderCode);
		if (Objects.nonNull(delivery)) {
			logger.info("Old Delivery Status : " + delivery.getStatus().toString());
			delivery.setStatus(status);
			logger.info("New Delivery Status : " + delivery.getStatus().toString());
		}
		return delivery;
	}

}
