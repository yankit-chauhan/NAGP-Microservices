package com.nagarro.products.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nagarro.products.dao.ProductsDAO;
import com.nagarro.products.model.Product;

/**
 * This class implements the methods of ProductsDAO to provide details of
 * products.
 * 
 * @author yankitchauhan
 *
 */
@Repository("productsDAO")
public class DefaultProductsDAO implements ProductsDAO {

	private static final Logger logger = LoggerFactory.getLogger(DefaultProductsDAO.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Product> getAllProducts() {
		logger.info("In DefaultProductsDAO  -->>  getAllProducts Method");
		List<Product> products = new ArrayList<>();
		products.add(new Product("PROD001", "Apple iPhone 11", "qwertyuiopasdfghjkl"));
		products.add(new Product("PROD002", "Apple iPhone 11 Pro", "qwertyuiopasdfghjkl"));
		products.add(new Product("PROD003", "Apple iPhone 11 Pro Max", "qwertyuiopasdfghjkl"));
		products.add(new Product("PROD004", "Apple iPhone X", "qwertyuiopasdfghjkl"));
		products.add(new Product("PROD005", "Apple iPhone 12", "qwertyuiopasdfghjkl"));
		products.add(new Product("PROD006", "Apple iPhone 12 Pro", "qwertyuiopasdfghjkl"));
		products.add(new Product("PROD007", "Apple iPhone 12 Pro Max", "qwertyuiopasdfghjkl"));
		logger.info("Exiting DefaultProductsDAO  -->>  getAllProducts Method");
		return products;
	}

}
