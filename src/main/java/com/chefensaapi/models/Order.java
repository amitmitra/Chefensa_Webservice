package com.chefensaapi.models;

public class Order {

	private long orderId;
	
	private long customerId;
	
	private long mealId;
	
	private long chefId;
	
	private String customerName;
	
	private int orderCost;
	
	private String orderAddress;
	
	private String orderPhone;
	
	private String orderTime;

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
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

	public long getMealId() {
		return mealId;
	}

	public void setMealId(long mealId) {
		this.mealId = mealId;
	}

	public long getChefId() {
		return chefId;
	}

	public void setChefId(long chefId) {
		this.chefId = chefId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
}
