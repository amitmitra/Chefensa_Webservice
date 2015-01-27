package com.chefensaapi.models;

public class Order {
	
	private long id;
	private String deviceId;
	private String mealId;
	private long dateTime;
	private String mealCount;
	private int totalPrice;
	private int status;
	private String address;
	private String customerName;
	private long phoneNumber;
	private String customerEmail;
	private int orderPaymentType;
	private int panicButtonPressed;

	public Order() {

	}

	public Order(long id, String deviceId, String mealId, long dateTime,
			String mealCount, int totalPrice, int status, String address,
			String customerName, long phoneNumber, String customerEmail,
			int orderPaymentType, int panicButtonPressed) {
		super();
		this.id = id;
		this.deviceId = deviceId;
		this.mealId = mealId;
		this.dateTime = dateTime;
		this.mealCount = mealCount;
		this.totalPrice = totalPrice;
		this.status = status;
		this.address = address;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.customerEmail = customerEmail;
		this.orderPaymentType = orderPaymentType;
		this.panicButtonPressed = panicButtonPressed;
	}


	public Order(long id, String mealId, long dateTime, String mealCount,
			int totalPrice, int status, String address) {
		super();
		this.id = id;
		this.mealId = mealId;
		this.dateTime = dateTime;
		this.mealCount = mealCount;
		this.totalPrice = totalPrice;
		this.status = status;
		this.address = address;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public int getOrderType() {
		return orderPaymentType;
	}

	public void setOrderType(int orderType) {
		this.orderPaymentType = orderType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMealId() {
		return mealId;
	}

	public void setMealId(String mealId) {
		this.mealId = mealId;
	}

	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}

	public String getMealCount() {
		return mealCount;
	}

	public void setMealCount(String mealCount) {
		this.mealCount = mealCount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getOrderPaymentType() {
		return orderPaymentType;
	}

	public void setOrderPaymentType(int orderPaymentType) {
		this.orderPaymentType = orderPaymentType;
	}

	public int getPanicButtonPressed() {
		return panicButtonPressed;
	}

	public void setPanicButtonPressed(int panicButtonPressed) {
		this.panicButtonPressed = panicButtonPressed;
	}
}