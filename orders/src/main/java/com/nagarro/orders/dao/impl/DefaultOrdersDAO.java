package com.nagarro.orders.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nagarro.orders.dao.OrdersDAO;
import com.nagarro.orders.enums.OrderStatus;
import com.nagarro.orders.model.Order;
import com.nagarro.orders.model.OrderEntry;

/**
 * This class implements the methods of OrdersDAO to provide all orders present
 * in the system.
 * 
 * @author yankitchauhan
 *
 */
@Repository(value = "ordersDAO")
public class DefaultOrdersDAO implements OrdersDAO {

	private static final Logger logger = LoggerFactory.getLogger(DefaultOrdersDAO.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getAllOrders() {
		logger.info("In DefaultOrdersDAO  -->>  getAllOrders method");
		List<Order> orders = new ArrayList<>();
		orders.add(new Order("1000001", new ArrayList<OrderEntry>(), 0.0D, "ABAB001", OrderStatus.CREATED));
		orders.add(new Order("1000002", new ArrayList<OrderEntry>(), 0.0D, "ABAB001", OrderStatus.COMPLETED));
		orders.add(new Order("1000003", new ArrayList<OrderEntry>(), 0.0D, "ABAB001", OrderStatus.COMPLETED));
		orders.add(new Order("1000004", new ArrayList<OrderEntry>(), 0.0D, "ABAB001", OrderStatus.DELIVERED));
		orders.add(new Order("1000005", new ArrayList<OrderEntry>(), 0.0D, "ABAB001", OrderStatus.PAYMENTFAILED));
		orders.add(new Order("1000006", new ArrayList<OrderEntry>(), 0.0D, "ABAB001", OrderStatus.CANCELLED));
		orders.add(new Order("1000007", new ArrayList<OrderEntry>(), 0.0D, "ABAB002", OrderStatus.CREATED));
		orders.add(new Order("1000008", new ArrayList<OrderEntry>(), 0.0D, "ABAB002", OrderStatus.COMPLETED));
		orders.add(new Order("1000009", new ArrayList<OrderEntry>(), 0.0D, "ABAB002", OrderStatus.COMPLETED));
		orders.add(new Order("1000010", new ArrayList<OrderEntry>(), 0.0D, "ABAB002", OrderStatus.DELIVERED));
		orders.add(new Order("1000011", new ArrayList<OrderEntry>(), 0.0D, "ABAB002", OrderStatus.PAYMENTFAILED));
		orders.add(new Order("1000012", new ArrayList<OrderEntry>(), 0.0D, "ABAB002", OrderStatus.CANCELLED));
		logger.info("Exiting DefaultOrdersDAO  -->>  getAllOrders method");
		return orders;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getOrdersForUser(String userId) {
		return getAllOrders().stream().filter(order -> order.getUserId().equalsIgnoreCase(userId))
				.collect(Collectors.toList());
	}

}
