package com.nagarro.stocks.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nagarro.stocks.dao.StockDAO;
import com.nagarro.stocks.enums.StockStatus;
import com.nagarro.stocks.model.Stock;

/**
 * This class implements the methods of StockDAO to provide available stock for
 * products.
 * 
 * @author yankitchauhan
 *
 */
@Repository("stockDAO")
public class DefaultStockDAO implements StockDAO {

	private static final Logger logger = LoggerFactory.getLogger(DefaultStockDAO.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Stock> getStocksOfAllProducts() {
		logger.info("In DefaultStockDAO  -->>  getStocksOfAllProducts Method");
		List<Stock> stocks = new ArrayList<>();
		stocks.add(new Stock("PROD001", Long.valueOf(100), Long.valueOf(3), StockStatus.SHIPPED, "WH01"));
		stocks.add(new Stock("PROD002", Long.valueOf(200), Long.valueOf(3), StockStatus.SHIPPED, "WH01"));
		stocks.add(new Stock("PROD003", Long.valueOf(0), Long.valueOf(0), StockStatus.FORCEINSTOCK, "WH01"));
		stocks.add(new Stock("PROD004", Long.valueOf(0), Long.valueOf(0), StockStatus.OUTOFSTOCK, "WH01"));
		stocks.add(new Stock("PROD005", Long.valueOf(3), Long.valueOf(3), StockStatus.TEMPORARYNOTAVAILABLE, "WH01"));
		stocks.add(new Stock("PROD006", Long.valueOf(3), Long.valueOf(3), StockStatus.OUTOFSTOCK, "WH01"));
		stocks.add(new Stock("PROD007", Long.valueOf(0), Long.valueOf(0), StockStatus.NOLONGERAVAILABLE, "WH01"));
		logger.info("Exiting DefaultStockDAO  -->>  getStocksOfAllProducts Method");
		return stocks;
	}

}
