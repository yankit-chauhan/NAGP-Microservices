package com.nagarro.orders.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.orders.dao.CartsDAO;
import com.nagarro.orders.model.Cart;
import com.nagarro.orders.model.OrderEntry;
import com.nagarro.orders.service.CartService;
import com.nagarro.orders.service.OrderEntryService;

/**
 * Provides implementation of Cart Service
 * 
 * @author yankitchauhan
 *
 */
@Service
public class DefaultCartService implements CartService {

	@Autowired
	CartsDAO cartsDAO;

	@Value("${server.port}")
	private int port;

	@Autowired
	LoadBalancerClient loadBalancerClient;

	@Resource
	private RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(DefaultCartService.class);

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	private OrderEntryService orderEntryService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Cart addToCart(String productCode, Long quantity, String userId) {
		logger.info("In DefaultCartService -> addToCart Method");
		Cart cart = getCartForUser(userId);
		OrderEntry entry = orderEntryService.createOrderEntry(productCode, quantity);
		entry.setOrderCode(cart.getOrderCode());

		List<OrderEntry> orderEntries = cart.getOrderEntries();
		orderEntries.add(entry);

		cart.setOrderEntries(orderEntries);
		logger.info("Exiting DefaultCartService -> addToCart Method");
		return cart;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Cart deleteFromCart(String productCode, Long quantity, String userId) {
		logger.info("In DefaultCartService -> deleteFromCart Method");
		Cart cart = getCartForUser(userId);
		OrderEntry entry = orderEntryService.getOrderEntryForProduct(productCode, cart.getOrderCode());
		entry.setOrderCode(null);
		logger.info("Exiting DefaultCartService -> addToCart Method");
		return cart;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Cart> getAllCarts() {
		return cartsDAO.getAllCarts();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Cart getCartForUser(String userId) {
		logger.info("In DefaultCartService -> getCartForUser Method");
		Cart cart = null;
		Optional<Cart> result = getAllCarts().stream().filter(c -> userId.equals(c.getUserId())).findFirst();
		if (result.isPresent()) {
			cart = result.get();
		} else {
			cart = new Cart("1000005", new ArrayList<OrderEntry>(), Double.valueOf(0), userId);
		}
		logger.info("Exiting DefaultCartService -> getCartForUser Method");
		return cart;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Cart getCartForCode(String orderCode) {
		logger.info("In DefaultCartService -> getCartForCode Method");
		Cart cart = null;
		Optional<Cart> result = getAllCarts().stream().filter(c -> orderCode.equals(c.getOrderCode())).findFirst();
		if (result.isPresent()) {
			cart = result.get();
		}
		logger.info("Exiting DefaultCartService -> getCartForCode Method");
		return cart;
	}

	/**
	 * @return the cartsDAO
	 */
	public CartsDAO getCartsDAO() {
		return cartsDAO;
	}

	/**
	 * @param cartsDAO the cartsDAO to set
	 */
	public void setCartsDAO(CartsDAO cartsDAO) {
		this.cartsDAO = cartsDAO;
	}

}
