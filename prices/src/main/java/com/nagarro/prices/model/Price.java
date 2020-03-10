package com.nagarro.prices.model;

/**
 * Price Model
 * 
 * @author yankitchauhan
 *
 */
public class Price {

	String productCode;
	Double price;
	Double tax;

	/**
	 * Price constructor to create price of a product.
	 * 
	 * @param productCode the product code
	 * @param price       the unit price of product
	 * @param tax         the unit tax for product
	 */
	public Price(String productCode, Double price, Double tax) {
		this.productCode = productCode;
		this.price = price;
		this.tax = tax;
	}

	/**
	 * Default Constructor
	 */
	public Price() {

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
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the tax
	 */
	public Double getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(Double tax) {
		this.tax = tax;
	}

}
