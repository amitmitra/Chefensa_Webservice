package com.chefensaapi.models;

public class CustomerAddressMapping {

	private long customerId;
	private long addressId;
	private int priority;
	
	public CustomerAddressMapping(long customerId, long addressId, int priority) {
		super();
		this.customerId = customerId;
		this.addressId = addressId;
		this.priority = priority;
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
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
}
