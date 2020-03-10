package com.nagarro.orders.model;

/**
 * Product Model to handle products from Products Microservice
 * 
 * @author yankitchauhan
 *
 */
public class Product {

	private String code;
	private String name;
	private String description;
	private Double price;
	private Long availableQuantity;

	/**
	 * Constructor to create new object of Product.
	 * 
	 * @param code              the product code
	 * @param name              the product name
	 * @param description       the product description
	 * @param price             the base price of product
	 * @param availableQuantity the available quantity of product
	 */
	public Product(String code, String name, String description, Double price, Long availableQuantity) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}

	/**
	 * Default Constructor
	 */
	public Product() {

	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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

}
