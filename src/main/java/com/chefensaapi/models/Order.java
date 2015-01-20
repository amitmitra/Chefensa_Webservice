package com.chefensaapi.models;

public class Order {

	private long orderId;
	private long customerId;
	private long addressId;
	private String orderDate;
	private String orderTime;
	private String mealId;
	private String mealQuantity;
	private int status;
	
	public Order(long orderId, long customerId, long addressId,
			String orderDate, String orderTime, String mealId, String mealQuantity, int status) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.addressId = addressId;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.mealId = mealId;
		this.mealQuantity = mealQuantity;
		this.status = status;
	}

	public Order(long customerId, long addressId,
			String orderDate, String orderTime, String mealId, String mealQuantity, int status) {
		this.customerId = customerId;
		this.addressId = addressId;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.mealId = mealId;
		this.mealQuantity = mealQuantity;
		this.status = status;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
	public String getMealId() {
		return mealId;
	}

	public void setMealId(String mealId) {
		this.mealId = mealId;
	}

	public String getMealQuantity() {
		return mealQuantity;
	}

	public void setMealQuantity(String mealQuantity) {
		this.mealQuantity = mealQuantity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
