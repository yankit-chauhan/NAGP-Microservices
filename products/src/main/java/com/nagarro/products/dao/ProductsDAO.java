package com.nagarro.products.dao;

import java.util.List;

import com.nagarro.products.model.Product;

/**
 * Interface to provide access to Product Data
 * 
 * @author yankitchauhan
 *
 */
public interface ProductsDAO {

	/**
	 * Returns details of all products
	 * 
	 * @return list of products
	 */
	List<Product> getAllProducts();
}
