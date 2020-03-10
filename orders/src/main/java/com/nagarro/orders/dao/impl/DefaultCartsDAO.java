package com.nagarro.orders.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nagarro.orders.dao.CartsDAO;
import com.nagarro.orders.model.Cart;
import com.nagarro.orders.model.OrderEntry;

/**
 * This class implements the methods of CartsDAO to provide all carts present in
 * the system.
 * 
 * @author yankitchauhan
 *
 */
@Repository(value = "cartsDAO")
public class DefaultCartsDAO implements CartsDAO {

	private static final Logger logger = LoggerFactory.getLogger(DefaultCartsDAO.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Cart> getAllCarts() {
		logger.info("In DefaultCartsDAO  -->> getAllCarts method");
		List<Cart> carts = new ArrayList<>();
		carts.add(new Cart("1000001", new ArrayList<OrderEntry>(), 0.0D, "ABAB001"));
		carts.add(new Cart("1000002", new ArrayList<OrderEntry>(), 0.0D, "ABAB002"));
		carts.add(new Cart("1000003", new ArrayList<OrderEntry>(), 0.0D, "ABAB003"));
		carts.add(new Cart("1000004", new ArrayList<OrderEntry>(), 0.0D, "ABAB004"));
		carts.add(new Cart("1000005", new ArrayList<OrderEntry>(), 0.0D, "ABAB005"));
		logger.info("Exiting DefaultCartsDAO  -->> getAllCarts method");
		return carts;
	}

}
