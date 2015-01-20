package com.chefensaapi.details;

public class CustomerDetail {

	private long id;
	private String deviceId;
	private String customerName;
	private String primaryPhone;
	private String secondaryPhone;
	private String primaryEmail;
	private String secondaryEmail;
	private long totalHitsOnApp;
	private long noOfTImesOrdered;
	private long timesStayingMoreThan2Mins;
	private String country;
	private String state;
	private String city;
	private String locality;
	private String pin;
	private String streetName;
	private String buildingName;
	private String flatNumber;
	private String landmark;
	private String coordinates;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPrimaryPhone() {
		return primaryPhone;
	}
	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}
	public String getSecondaryPhone() {
		return secondaryPhone;
	}
	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}
	public String getPrimaryEmail() {
		return primaryEmail;
	}
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}
	public String getSecondaryEmail() {
		return secondaryEmail;
	}
	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}
	public long getTotalHitsOnApp() {
		return totalHitsOnApp;
	}
	public void setTotalHitsOnApp(long totalHitsOnApp) {
		this.totalHitsOnApp = totalHitsOnApp;
	}
	public long getNoOfTImesOrdered() {
		return noOfTImesOrdered;
	}
	public void setNoOfTImesOrdered(long noOfTImesOrdered) {
		this.noOfTImesOrdered = noOfTImesOrdered;
	}
	public long getTimesStayingMoreThan2Mins() {
		return timesStayingMoreThan2Mins;
	}
	public void setTimesStayingMoreThan2Mins(long timesStayingMoreThan2Mins) {
		this.timesStayingMoreThan2Mins = timesStayingMoreThan2Mins;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
}
