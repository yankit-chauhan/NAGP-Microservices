package com.nagarro.products.service;

import java.util.List;

import com.nagarro.products.model.Product;

/**
 * Interface that exposes various product related methods
 * 
 * @author yankitchauhan
 *
 */
public interface ProductsService {

	/**
	 * Returns details of all products
	 * 
	 * @return list of products
	 */
	List<Product> getAllProducts();

	/**
	 * Return product for specific product code
	 * 
	 * @param code the product code
	 * @return product
	 */
	Product getProductByCode(String code);

	/**
	 * Adds new Product to database and returns updated list of all products
	 * 
	 * @param code        the product code
	 * @param name        the name of product
	 * @param description the description of product
	 * @return updated product list
	 */
	List<Product> addProduct(String code, String name, String description);

	/**
	 * Removes a product from the database and returns the updated list of all
	 * products
	 * 
	 * @param code the product code
	 * @return updated product list
	 */
	List<Product> removeProduct(String code);

}
