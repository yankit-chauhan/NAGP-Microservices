package com.nagarro.orders.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.orders.dto.OrderEntryDTO;
import com.nagarro.orders.model.Cart;
import com.nagarro.orders.model.Order;
import com.nagarro.orders.model.Product;
import com.nagarro.orders.service.CartService;
import com.nagarro.orders.service.OrderService;

/**
 * Controller to expose various cart/order related APIs.
 * 
 * @author yankitchauhan
 *
 */
@RestController
@RequestMapping(value = "/orders")
@EnableCircuitBreaker
public class CartController {

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private int port;

	@Autowired
	private CartService cartService;

	@Autowired
	private OrderService orderService;

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	/**
	 * Method to add product to cart
	 * 
	 * @param orderEntryDTO the orderEntryDTO
	 * @return updated cart
	 */
	@PostMapping("/addToCart")
	public Cart addProductToCart(@RequestBody OrderEntryDTO orderEntryDTO) {
		logger.info("In CartController -> addProductToCart Method");
		logger.info("Working from port " + port + " of product service");
		Cart cart = cartService.addToCart(orderEntryDTO.getCode(), orderEntryDTO.getQuantity(),
				orderEntryDTO.getUserId());
		logger.info("Exiting CartController -> addProductToCart Method");
		return cart;
	}

	/**
	 * Return product details for product code
	 * 
	 * @param code the product code
	 * @return Product
	 */
	@GetMapping(value = "/product/{code}")
	public Product getProductDetails(@PathVariable(name = "code") String code) {
		logger.info("In Cart Controller  -->>  getProductDetails Method");
		String url = "/products?code=" + code;

		url = "http://products" + url;
		ResponseEntity<Product> response = restTemplate.exchange(url, HttpMethod.GET, null, Product.class);
		Product product = response.getBody();

		logger.info("Exiting Cart Controller  -->>  getProductDetails Method");
		return product;
	}

	/**
	 * Removes the product from the cart.
	 * 
	 * @param orderEntryDTO the orderEntryDTO
	 * @return updated cart
	 */
	@PostMapping("/remove")
	public Cart removeProductFromCart(@RequestBody OrderEntryDTO orderEntryDTO) {
		logger.info("In CartController -->>  removeProductFromCart");
		logger.info("Request params are : code = " + orderEntryDTO.getCode() + ", quantity = "
				+ orderEntryDTO.getQuantity() + ", and User Id = " + orderEntryDTO.getUserId());
		Cart cart = cartService.deleteFromCart(orderEntryDTO.getCode(), orderEntryDTO.getQuantity(),
				orderEntryDTO.getUserId());
		logger.info("Exiting CartController -->>  removeProductFromCart");
		return cart;
	}

	/**
	 * Method to Place Order.
	 * 
	 * @param orderCode the order code
	 * @return order
	 */
	@PostMapping("/placeOrder")
	Order placeOrder(@RequestParam(name = "orderCode") String orderCode) {
		logger.info("In CartController  -->>  placeOrder Method");
		Order order = orderService.placeOrder(orderCode);
		logger.info("Exiting CartController  -->>  placeOrder Method");
		return order;
	}

	/**
	 * Returns all orders of user
	 * 
	 * @param userId the User Id
	 * @return list of all orders placed by user
	 */
	@GetMapping(value = "getOrders/{userId}")
	List<Order> getOrdersForUser(@PathVariable(name = "userId") String userId) {
		logger.info("In CartController  -->>  getOrdersForUser Method");
		List<Order> orders = orderService.getOrdersForUser(userId);
		logger.info("Exiting CartController  -->>  getOrdersForUser Method");
		return orders;
	}

}
