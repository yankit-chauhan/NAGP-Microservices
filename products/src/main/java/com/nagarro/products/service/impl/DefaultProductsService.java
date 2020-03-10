package com.nagarro.products.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.nagarro.products.dao.ProductsDAO;
import com.nagarro.products.model.Product;
import com.nagarro.products.service.ProductsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * This class implements the methods of ProductsService to provide details of
 * products.
 * 
 * @author yankitchauhan
 *
 */
@Service("productService")
public class DefaultProductsService implements ProductsService {

	@Value("${server.port}")
	private int port;

	@Autowired
	ProductsDAO productsDAO;

	@Autowired
	LoadBalancerClient loadBalancerClient;

	private static final Logger logger = LoggerFactory.getLogger(DefaultProductsService.class);

	@Resource
	private RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Product> getAllProducts() {
		return productsDAO.getAllProducts();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@HystrixCommand(fallbackMethod = "getProductInfoWithoutPrice")
	public Product getProductByCode(String code) {
		logger.info("In DefaultProductsService  -->>  getProductByCode Method");
		Product product = null;
		Optional<Product> result = getAllProducts().stream().filter(p -> p.getCode().equalsIgnoreCase(code))
				.findFirst();
		if (result.isPresent()) {
			String basePriceUrl = loadBalancerClient.choose("prices").getUri().toString() + "/prices";
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Double> priceResponse = null;

			try {
				UriComponentsBuilder priceBuilder = UriComponentsBuilder.fromUriString(basePriceUrl)
						.queryParam("productCode", result.get().getCode());
				priceResponse = restTemplate.exchange(priceBuilder.buildAndExpand().toUri(), HttpMethod.GET, null,
						Double.class);
			} catch (Exception ex) {
				System.out.println(ex);
			}

			String baseStockUrl = loadBalancerClient.choose("stocks").getUri().toString() + "/stocks";
			ResponseEntity<Long> stockResponse = null;

			try {
				UriComponentsBuilder stockBuilder = UriComponentsBuilder.fromUriString(baseStockUrl)
						.queryParam("productCode", result.get().getCode());
				stockResponse = restTemplate.exchange(stockBuilder.buildAndExpand().toUri(), HttpMethod.GET, null,
						Long.class);
			} catch (Exception ex) {
				System.out.println(ex);
			}

			result.get().setPrice(priceResponse.getBody());
			result.get().setAvailableQuantity(stockResponse.getBody());
			product = result.get();
		}
		logger.info("Exiting DefaultProductsService  -->>  getProductByCode Method");
		return product;
	}

	/**
	 * Fallback method to provide product details in case price is not found for a
	 * product.
	 * 
	 * @param code the product code
	 * @return product
	 */
	public Product getProductInfoWithoutPrice(String code) {
		logger.info("In DefaultProductsService  -->>  getProductInfoWithoutPrice Method");
		Product product = null;
		Optional<Product> result = getAllProducts().stream().filter(p -> p.getCode().equalsIgnoreCase(code))
				.findFirst();
		if (result.isPresent()) {
			product = result.get();
		}
		logger.info("Exiting DefaultProductsService  -->>  getProductInfoWithoutPrice Method");
		return product;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Product> addProduct(String code, String name, String description) {
		List<Product> productList = getAllProducts();
		productList.add(new Product(code, name, description));
		return productList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Product> removeProduct(String code) {
		List<Product> productList = getAllProducts();
		List<Product> updatedProductList = productList.stream()
				.filter(product -> !product.getCode().equalsIgnoreCase(code)).collect(Collectors.toList());
		return updatedProductList;
	}

}
