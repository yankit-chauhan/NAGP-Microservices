package com.nagarro.orders.service.impl;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.lang.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.nagarro.orders.dao.OrdersDAO;
import com.nagarro.orders.enums.OrderStatus;
import com.nagarro.orders.model.Cart;
import com.nagarro.orders.model.Order;
import com.nagarro.orders.service.CartService;
import com.nagarro.orders.service.OrderService;

/**
 * Provides implementation of Order Service
 * 
 * @author yankitchauhan
 *
 */
@Service
public class DefaultOrderService implements OrderService {

	@Resource
	private OrdersDAO ordersDao;

	@Autowired
	private CartService cartService;

	@Value("${server.port}")
	private int port;

	@Resource
	private RestTemplate restTemplate2;

	@Autowired
	LoadBalancerClient loadBalancerClient;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate2() {
		return new RestTemplate();
	}

	private static final Logger logger = LoggerFactory.getLogger(DefaultOrderService.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getOrdersForUser(String userId) {
		logger.info("In DefaultOrderService -> getOrdersForUser Method");
		logger.info("Working from port " + port + " of orders service");
		return ordersDao.getOrdersForUser(userId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order placeOrder(String orderCode) {
		logger.info("In DefaultOrderService -> placeOrder Method");
		Cart cart = cartService.getCartForCode(orderCode);
		Order order = null;
		if (Objects.nonNull(cart)) {
			Boolean paymentStatus = getPaymentStatus(orderCode);
			if (BooleanUtils.isTrue(paymentStatus)) {
				logger.info("Payment Successful");
				order = new Order(cart.getOrderCode(), cart.getOrderEntries(), cart.getTotalPrice(), cart.getUserId(),
						OrderStatus.CREATED);
			} else {
				logger.info("Payment Failed");
				order = new Order(cart.getOrderCode(), cart.getOrderEntries(), cart.getTotalPrice(), cart.getUserId(),
						OrderStatus.PAYMENTFAILED);
			}
		} else {
			logger.error("Order Not Found");
		}
		logger.info("Exiting DefaultOrderService -> placeOrder Method");
		return order;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean getPaymentStatus(String orderCode) {
		logger.info("In DefaultOrderService -> getPaymentStatus Method");
		String basePaymentUrl = loadBalancerClient.choose("payments").getUri().toString() + "/payments";
		ResponseEntity<Boolean> paymentResponse = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			UriComponentsBuilder paymentBuilder = UriComponentsBuilder.fromUriString(basePaymentUrl)
					.queryParam("orderCode", orderCode);
			paymentResponse = restTemplate.exchange(paymentBuilder.buildAndExpand().toUri(), HttpMethod.GET, null,
					Boolean.class);
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		logger.info("Exiting DefaultOrderService -> getPaymentStatus Method");
		return paymentResponse.getBody();
	}

}
