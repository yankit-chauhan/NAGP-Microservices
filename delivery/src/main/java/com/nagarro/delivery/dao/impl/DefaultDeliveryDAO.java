package com.nagarro.delivery.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nagarro.delivery.dao.DeliveryDAO;
import com.nagarro.delivery.enums.DeliveryStatus;
import com.nagarro.delivery.model.Delivery;

/**
 * This class implements the methods of DeliveryDAO to provide delivery
 * information of orders.
 * 
 * @author yankitchauhan
 *
 */
@Repository("deliveryDAO")
public class DefaultDeliveryDAO implements DeliveryDAO {

	public static final Logger logger = LoggerFactory.getLogger(DefaultDeliveryDAO.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Delivery> getDeliveryOfAllOrders() {
		logger.info("In DefaultDeliveryDAO  -->> getDeliveryOfAllOrders method");
		List<Delivery> deliveries = new ArrayList<>();
		deliveries.add(new Delivery("1000001", DeliveryStatus.CREATED));
		deliveries.add(new Delivery("1000002", DeliveryStatus.CREATED));
		deliveries.add(new Delivery("1000003", DeliveryStatus.CREATED));
		deliveries.add(new Delivery("1000004", DeliveryStatus.CREATED));
		deliveries.add(new Delivery("1000005", DeliveryStatus.CREATED));
		logger.info("Exiting DefaultDeliveryDAO  -->> getDeliveryOfAllOrders method");
		return deliveries;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Delivery getDeliveryForOrderCode(String orderCode) {
		Delivery delivery = null;
		Optional<Delivery> result = getDeliveryOfAllOrders().stream()
				.filter(d -> d.getOrderCode().equalsIgnoreCase(orderCode)).findFirst();
		if (result.isPresent()) {
			delivery = result.get();
		}
		return delivery;
	}

}
