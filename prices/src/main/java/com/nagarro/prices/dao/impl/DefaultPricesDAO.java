package com.nagarro.prices.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nagarro.prices.dao.PricesDAO;
import com.nagarro.prices.model.Price;

/**
 * This class implements the methods of PricesDAO to provide prices of various
 * products.
 * 
 * @author yankitchauhan
 *
 */
@Repository("pricesDAO")
public class DefaultPricesDAO implements PricesDAO {

	private static final Logger logger = LoggerFactory.getLogger(DefaultPricesDAO.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Price> getAllPrices() {
		logger.info("In DefaultPricesDAO  -->>  getAllPrices Method");
		List<Price> prices = new ArrayList<>();
		prices.add(new Price("PROD001", 66433.50, 3566.50));
		prices.add(new Price("PROD002", 76433.50, 4066.50));
		prices.add(new Price("PROD003", 86433.50, 4566.50));
		prices.add(new Price("PROD004", 96433.50, 5066.50));
		prices.add(new Price("PROD005", 106433.50, 5566.50));
		prices.add(new Price("PROD006", 116433.50, 6066.50));
		prices.add(new Price("PROD007", 126433.50, 6566.50));
		logger.info("Exiting DefaultPricesDAO  -->>  getAllPrices Method");
		return prices;
	}

}
