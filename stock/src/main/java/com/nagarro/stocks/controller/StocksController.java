package com.nagarro.stocks.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.stocks.sevice.StockService;

/**
 * This controller contains all the methods to provide relevant stock details.
 * 
 * @author yankitchauhan
 *
 */
@RestController
@RequestMapping(value = "/stocks")
public class StocksController {

	@Value("${server.port}")
	private int port;

	@Resource
	StockService stockService;

	private static final Logger logger = LoggerFactory.getLogger(StocksController.class);

	/**
	 * This method returns the specific product stock.
	 * 
	 * @param productCode
	 * @return available product stock
	 */
	@GetMapping
	Long getProductStock(@RequestParam(name = "productCode") String productCode) {
		logger.info("In StocksController  --  >>  getProductStock Method");
		logger.info("Working from port " + port + " of stock service");
		return stockService.getStockForProductCode(productCode);
	}

	/**
	 * @return the stockService
	 */
	public StockService getStockService() {
		return stockService;
	}

	/**
	 * @param stockService the stockService to set
	 */
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

}
