package com.nagarro.prices.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.prices.dao.PricesDAO;
import com.nagarro.prices.dao.impl.DefaultPricesDAO;
import com.nagarro.prices.model.Price;
import com.nagarro.prices.service.PriceCalculationService;

/**
 * This class implements the methods of PriceCalculationService to provide
 * prices of products.
 * 
 * @author yankitchauhan
 *
 */
@Service
public class DefaultPriceCalculationService implements PriceCalculationService {

	@Autowired
	PricesDAO pricesDAO;

	private static final Logger logger = LoggerFactory.getLogger(DefaultPricesDAO.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Price> getAllPrices() {
		return pricesDAO.getAllPrices();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double getPriceforProductCode(String productCode) {
		logger.info("In DefaultPriceCalculationService  -->>  getPriceforProductCode Method");
		Double price = null;
		Optional<Price> result = getAllPrices().stream().filter(p -> p.getProductCode().equalsIgnoreCase(productCode))
				.findFirst();
		if (result.isPresent()) {
			price = result.get().getPrice() + result.get().getTax();
		}
		logger.info("Exiting DefaultPriceCalculationService  -->>  getPriceforProductCode Method");
		return price;
	}

}
