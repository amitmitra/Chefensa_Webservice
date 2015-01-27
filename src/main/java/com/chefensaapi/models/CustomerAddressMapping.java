package com.chefensaapi.models;

public class CustomerAddressMapping {

	private long phoneNumber;
	private long addressId;
	private int priority;
	
	public CustomerAddressMapping(long phoneNumber, long addressId, int priority) {
		super();
		this.phoneNumber = phoneNumber;
		this.addressId = addressId;
		this.priority = priority;
	}
	
	public long getCustomerId() {
		return phoneNumber;
	}
	public void setCustomerId(long phoneNumber) {
		this.phoneNumber = phoneNumber;
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
