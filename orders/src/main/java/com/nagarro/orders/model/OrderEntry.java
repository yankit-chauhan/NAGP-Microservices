package com.nagarro.orders.model;

/**
 * Order Entry Model
 * 
 * @author yankitchauhan
 *
 */
public class OrderEntry {

	private Integer entryNumber;
	private Product product;
	private Long quantity;
	private Double price;
	private Double basePrice;
	private String orderCode;

	/**
	 * Constructor to create new object of Order Entry
	 * 
	 * @param entryNumber the entry number
	 * @param product     the product
	 * @param quantity    the quantity of product
	 * @param price       the total price of entry
	 * @param basePrice   the base price of product
	 * @param orderCode   the code of order to which entry belongs
	 */
	public OrderEntry(Integer entryNumber, Product product, Long quantity, Double price, Double basePrice,
			String orderCode) {
		this.entryNumber = entryNumber;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.basePrice = basePrice;
		this.orderCode = orderCode;
	}

	/**
	 * Default Constructor
	 */
	public OrderEntry() {

	}

	/**
	 * @return the entryNumber
	 */
	public Integer getEntryNumber() {
		return entryNumber;
	}

	/**
	 * @param entryNumber the entryNumber to set
	 */
	public void setEntryNumber(Integer entryNumber) {
		this.entryNumber = entryNumber;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
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
	 * @return the basePrice
	 */
	public Double getBasePrice() {
		return basePrice;
	}

	/**
	 * @param basePrice the basePrice to set
	 */
	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * @return the orderCode
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * @param orderCode the orderCode to set
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
}
