package com.chefensaapi.models;

public class Customer {

	private long customerId;
	
	private String customerName;
	
	private String deviceId;
	
	private String primaryPhoneNo;
	
	private String secondaryPhoneNo;
	
	private String primaryEmailId;
	
	private String secondaryEmailId;
	
	private String primaryAddress;
	
	private String secondaryAddress;
	
	private String gender;
	
	private String mealType;
	
	private String cuisinePreference;
	
	private String spicinessPreference;
	
	private long totalHitsOnApp;
	
	private long totalOrdersPlaced;
	
	private String profileImageUrl;
	
	private String dateOfBirth;

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getPrimaryPhoneNo() {
		return primaryPhoneNo;
	}

	public void setPrimaryPhoneNo(String primaryPhoneNo) {
		this.primaryPhoneNo = primaryPhoneNo;
	}

	public String getSecondaryPhoneNo() {
		return secondaryPhoneNo;
	}

	public void setSecondaryPhoneNo(String secondaryPhoneNo) {
		this.secondaryPhoneNo = secondaryPhoneNo;
	}

	public String getPrimaryEmailId() {
		return primaryEmailId;
	}

	public void setPrimaryEmailId(String primaryEmailId) {
		this.primaryEmailId = primaryEmailId;
	}

	public String getSecondaryEmailId() {
		return secondaryEmailId;
	}

	public void setSecondaryEmailId(String secondaryEmailId) {
		this.secondaryEmailId = secondaryEmailId;
	}

	public String getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(String primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	public String getSecondaryAddress() {
		return secondaryAddress;
	}

	public void setSecondaryAddress(String secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getCuisinePreference() {
		return cuisinePreference;
	}

	public void setCuisinePreference(String cuisinePreference) {
		this.cuisinePreference = cuisinePreference;
	}

	public String getSpicinessPreference() {
		return spicinessPreference;
	}

	public void setSpicinessPreference(String spicinessPreference) {
		this.spicinessPreference = spicinessPreference;
	}

	public long getTotalHitsOnApp() {
		return totalHitsOnApp;
	}

	public void setTotalHitsOnApp(long totalHitsOnApp) {
		this.totalHitsOnApp = totalHitsOnApp;
	}

	public long getTotalOrdersPlaced() {
		return totalOrdersPlaced;
	}

	public void setTotalOrdersPlaced(long totalOrdersPlaced) {
		this.totalOrdersPlaced = totalOrdersPlaced;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	
}
