package com.chefensaapi.models;

public class Address {
	
	private long id;
	private String country;
	private String state;
	private String city;
	private String locality;
	private String pin;
	private String initialAddress;
	private String landmark;
	private String coordinates;
	
	public Address(long id, String country, String state, String city,
			String locality, String pin, String initialAddress,
			String landmark, String coordinates) {
		super();
		this.id = id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.locality = locality;
		this.pin = pin;
		this.initialAddress = initialAddress;
		this.landmark = landmark;
		this.coordinates = coordinates;
	}
	
	public Address(String country, String state, String city,
			String locality, String pin, String initialAddress,
			String landmark) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
		this.locality = locality;
		this.pin = pin;
		this.initialAddress = initialAddress;
		this.landmark = landmark;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getInitialAddress() {
		return initialAddress;
	}
	public void setInitialAddress(String initialAddress) {
		this.initialAddress = initialAddress;
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
