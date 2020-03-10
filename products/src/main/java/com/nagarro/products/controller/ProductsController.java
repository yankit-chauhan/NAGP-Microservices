package com.nagarro.products.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.products.model.Product;
import com.nagarro.products.service.ProductsService;

/**
 * This controller contains all the methods to provide relevant product details.
 * 
 * @author yankitchauhan
 *
 */
@RestController
@RequestMapping(value = "/products")
@EnableCircuitBreaker
public class ProductsController {

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private int port;

	@Autowired
	ProductsService productService;

	private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);

	@GetMapping(value = "/{code}")
	Product getProductDetails(@PathVariable(name = "code") String code) {
		logger.info("In Products Controller  -->>  getProductDetails Method");
		logger.info("Product Code is : " + code);
		logger.info("Working from port " + port + " of product service");
		return productService.getProductByCode(code);
	}

	@GetMapping(value = "/price/{productCode}")
	public double getPriceForProduct(@PathVariable(name = "productCode") String productCode) {
		logger.info("In Products Controller  -->>  getPriceForProduct Method");
		String url = "/prices?productCode=" + productCode;

		url = "http://prices" + url;
		ResponseEntity<Double> response = restTemplate.exchange(url, HttpMethod.GET, null, Double.class);
		double price = response.getBody();

		logger.info("Exiting Products Controller  -->>  getPriceForProduct Method");
		return price;
	}

	@GetMapping(value = "/stock/{productCode}")
	public long getStockForProduct(@PathVariable(name = "productCode") String productCode) {
		logger.info("In Products Controller  -->>  getStockForProduct Method");
		String url = "/stocks?productCode=" + productCode;

		url = "http://stocks" + url;
		ResponseEntity<Long> response = restTemplate.exchange(url, HttpMethod.GET, null, Long.class);
		long stock = response.getBody();
		logger.info("Exiting Products Controller  -->>  getStockForProduct Method");

		return stock;
	}

	/**
	 * Adds new Product to database and returns updated list of all products
	 * 
	 * @param code        the product code
	 * @param name        the name of product
	 * @param description the description of product
	 * @return updated product list
	 */
	@PostMapping("/addProduct")
	public List<Product> addProduct(@RequestParam(name = "code") String code, @RequestParam(name = "name") String name,
			@RequestParam(name = "description") String description) {
		logger.info("In Products Controller  -->>  addProduct Method");
		return productService.addProduct(code, name, description);
	}

	/**
	 * Removes a product from the database and returns the updated list of all
	 * products
	 * 
	 * @param code the product code
	 * @return updated product list
	 */
	@PostMapping("/removeProduct")
	public List<Product> removeProduct(@RequestParam(name = "code") String code) {
		logger.info("In Products Controller  -->>  removeProduct Method");
		return productService.removeProduct(code);
	}

	/**
	 * @return the restTemplate
	 */
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	/**
	 * @param restTemplate the restTemplate to set
	 */
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
