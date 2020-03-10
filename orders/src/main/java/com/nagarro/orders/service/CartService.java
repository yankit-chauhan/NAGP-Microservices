package com.nagarro.orders.service;

import java.util.List;

import com.nagarro.orders.model.Cart;

/**
 * Interface to provide various cart/order services.
 * 
 * @author yankitchauhan
 *
 */
public interface CartService {

	/**
	 * Returns all carts present in the system.
	 * 
	 * @return list of carts
	 */
	List<Cart> getAllCarts();

	/**
	 * Returns cart for User Id
	 * 
	 * @param userId the User Id
	 * @return cart
	 */
	Cart getCartForUser(String userId);

	/**
	 * Adds product to cart
	 * 
	 * @param productCode the product code
	 * @param quantity    the quantity of product to be added
	 * @param userId      the User Id
	 * @return updated cart
	 */
	Cart addToCart(String productCode, Long quantity, String userId);

	/**
	 * Returns cart for cart code.
	 * 
	 * @param orderCode the order code
	 * @return cart
	 */
	Cart getCartForCode(String orderCode);

	/**
	 * Removes product from cart
	 * 
	 * @param code     the product code
	 * @param quantity the quantity of to be removed
	 * @param userId   the User Id
	 * @return updated cart
	 */
	Cart deleteFromCart(String code, Long quantity, String userId);
}
