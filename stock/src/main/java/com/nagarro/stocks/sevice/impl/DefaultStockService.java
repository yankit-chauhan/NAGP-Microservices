package com.nagarro.stocks.sevice.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.stocks.dao.StockDAO;
import com.nagarro.stocks.enums.StockStatus;
import com.nagarro.stocks.model.Stock;
import com.nagarro.stocks.sevice.StockService;

/**
 * This class implements the methods of StockService to provide available stock
 * for products.
 * 
 * @author yankitchauhan
 *
 */
@Service("stockService")
public class DefaultStockService implements StockService {

	public static final Long defaultMaxQty = Long.valueOf(9999);

	@Autowired
	private StockDAO stockDAO;

	private static final Logger logger = LoggerFactory.getLogger(DefaultStockService.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Stock> getStocksofAllProducts() {
		return stockDAO.getStocksOfAllProducts();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getStockForProductCode(String productCode) {
		logger.info("In DefaultStockService  -->>  getStockForProductCode Method");
		Long availableQty = Long.valueOf(0);
		final List<StockStatus> availableStockStatus = Arrays.asList(StockStatus.FORCEINSTOCK, StockStatus.INSTOCK,
				StockStatus.SHIPPED);
		Predicate<Stock> matchingStock = s -> s.getProductCode().equalsIgnoreCase(productCode)
				&& availableStockStatus.contains(s.getStatus());
		Optional<Stock> result = getStocksofAllProducts().stream().filter(matchingStock).findFirst();
		if (result.isPresent()) {
			Stock stock = result.get();
			if (stock.getStatus().equals(StockStatus.FORCEINSTOCK)) {
				availableQty = defaultMaxQty;
			} else {
				availableQty = stock.getAvailableQuantity() - stock.getReservedQuantity();
			}
		} else {
			availableQty = Long.valueOf(0);
		}
		logger.info("Available stock quantity for product : " + productCode + " is " + availableQty);
		logger.info("Exiting DefaultStockService  -->>  getStockForProductCode Method");
		return availableQty;
	}

}
