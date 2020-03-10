package com.nagarro.stocks.model;

import com.nagarro.stocks.enums.StockStatus;

/**
 * Stock Model
 * 
 * @author yankitchauhan
 *
 */
public class Stock {

	private String productCode;
	private Long availableQuantity;
	private Long reservedQuantity;
	private StockStatus status;
	private String wareHouse;

	/**
	 * Stock constructor to create stock with various parameters.
	 * 
	 * @param productCode       the product code
	 * @param availableQuantity the available quantity
	 * @param reservedQuantity  the reserved quantity
	 * @param status            the stock status
	 * @param wareHouse         the warehouse
	 */
	public Stock(String productCode, Long availableQuantity, Long reservedQuantity, StockStatus status,
			String wareHouse) {
		this.productCode = productCode;
		this.availableQuantity = availableQuantity;
		this.reservedQuantity = reservedQuantity;
		this.status = status;
		this.wareHouse = wareHouse;
	}

	/**
	 * Default Constructor
	 */
	public Stock() {

	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the availableQuantity
	 */
	public Long getAvailableQuantity() {
		return availableQuantity;
	}

	/**
	 * @param availableQuantity the availableQuantity to set
	 */
	public void setAvailableQuantity(Long availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	/**
	 * @return the reservedQuantity
	 */
	public Long getReservedQuantity() {
		return reservedQuantity;
	}

	/**
	 * @param reservedQuantity the reservedQuantity to set
	 */
	public void setReservedQuantity(Long reservedQuantity) {
		this.reservedQuantity = reservedQuantity;
	}

	/**
	 * @return the status
	 */
	public StockStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StockStatus status) {
		this.status = status;
	}

	/**
	 * @return the wareHouse
	 */
	public String getWareHouse() {
		return wareHouse;
	}

	/**
	 * @param wareHouse the wareHouse to set
	 */
	public void setWareHouse(String wareHouse) {
		this.wareHouse = wareHouse;
	}

}
