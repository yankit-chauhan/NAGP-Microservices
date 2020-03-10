package com.nagarro.orders.dao;

import java.util.List;

import com.nagarro.orders.model.Cart;

/**
 * Interface to define methods to provide access to Carts database.
 * 
 * @author yankitchauhan
 *
 */
public interface CartsDAO {

	/**
	 * Returns all carts in system
	 * 
	 * @return list of cart
	 */
	public List<Cart> getAllCarts();

}
