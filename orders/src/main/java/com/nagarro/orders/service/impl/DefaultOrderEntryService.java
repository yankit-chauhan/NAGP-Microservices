package com.nagarro.orders.service.impl;

import javax.annotation.Resource;

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

import com.nagarro.orders.model.OrderEntry;
import com.nagarro.orders.model.Product;
import com.nagarro.orders.service.OrderEntryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Provides implementation of Order Entry Service
 * 
 * @author yankitchauhan
 *
 */
@Service("orderEntryService")
public class DefaultOrderEntryService implements OrderEntryService {

	@Value("${server.port}")
	private int port;

	@Autowired
	LoadBalancerClient loadBalancerClient;

	@Resource
	private RestTemplate restTemp2;

	private static final Logger logger = LoggerFactory.getLogger(DefaultOrderEntryService.class);

	@Bean
	@LoadBalanced
	public RestTemplate restTemp2() {
		return new RestTemplate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrderEntry createOrderEntry(String productCode, Long quantity) {
		logger.info("In DefaultOrderEntryService -> createOrderEntry Method");
		Product product = getProductByCode(productCode);
		logger.info("Exiting DefaultOrderEntryService -> createOrderEntry Method");
		return new OrderEntry(1, product, quantity, product.getPrice() * quantity, product.getPrice(), null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrderEntry getOrderEntryForProduct(String productCode, String orderCode) {
		logger.info("In DefaultOrderEntryService -> getOrderEntryForProduct Method");
		OrderEntry entry = getOrderEntryForProductCodeAndCartId(productCode, orderCode);
		logger.info("Exiting DefaultOrderEntryService -> getOrderEntryForProduct Method");
		return entry;
	}

	@HystrixCommand(fallbackMethod = "getDefaultProduct")
	private Product getProductByCode(String code) {
		logger.info("In DefaultOrderEntryService -> getProductByCode Method");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product> productResponse = null;
		String baseProductUrl = loadBalancerClient.choose("products").getUri().toString() + "/products/" + code;
		try {
			UriComponentsBuilder productBuilder = UriComponentsBuilder.fromUriString(baseProductUrl);
			productResponse = restTemplate.exchange(productBuilder.buildAndExpand().toUri(), HttpMethod.GET, null,
					Product.class);
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		logger.info("Exiting DefaultOrderEntryService -> getProductByCode Method");
		return productResponse.getBody();
	}

	/**
	 * Fallback method to provide default product in case product is not found.
	 * 
	 * @param code the product code
	 * @return Product
	 */
	public Product getDefaultProduct(String code) {
		return new Product("PROD001", "Apple iPhone 11", "qwertyuiopasdfghjkl", Double.valueOf(70000),
				Long.valueOf(97));
	}

	/**
	 * Returns the specific Order Entry of the product code the the the mentioned
	 * order.
	 * 
	 * @param productCode the product code
	 * @param orderCode   the order code
	 * @return Order Entry
	 */
	private OrderEntry getOrderEntryForProductCodeAndCartId(String productCode, String orderCode) {
		logger.info("In DefaultOrderEntryService -> getOrderEntryForProductCodeAndCartId Method");
		return new OrderEntry();
	}

}
