package com.nagarro.orders.dto;

/**
 * Order Entry DTO
 * 
 * @author yankitchauhan
 *
 */
public class OrderEntryDTO {
	private String code;
	private Long quantity;
	private String UserId;

	/**
	 * Constructor to create OrderEntryDTO object.
	 * 
	 * @param code     the product code
	 * @param quantity the product quantity
	 * @param userId   the user Id
	 */
	public OrderEntryDTO(String code, Long quantity, String userId) {
		this.code = code;
		this.quantity = quantity;
		UserId = userId;
	}

	/**
	 * Default Constructor
	 */
	public OrderEntryDTO() {

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
	 * @return the userId
	 */
	public String getUserId() {
		return UserId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		UserId = userId;
	}

}
