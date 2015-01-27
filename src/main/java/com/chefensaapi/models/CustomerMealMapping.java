package com.chefensaapi.models;

public class CustomerMealMapping {

	private long phoneNumber;
	private long mealId;
	private long hitsOnMeal;
	private long noOfTimesOrdered;
	private double rating;
	private String review;
	
	public CustomerMealMapping(long phoneNumber, long mealId) {
		super();
		this.phoneNumber = phoneNumber;
		this.mealId = mealId;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getMealId() {
		return mealId;
	}
	public void setMealId(long mealId) {
		this.mealId = mealId;
	}
	public long getHitsOnMeal() {
		return hitsOnMeal;
	}
	public void setHitsOnMeal(long hitsOnMeal) {
		this.hitsOnMeal = hitsOnMeal;
	}
	public long getNoOfTimesOrdered() {
		return noOfTimesOrdered;
	}
	public void setNoOfTimesOrdered(long noOfTimesOrdered) {
		this.noOfTimesOrdered = noOfTimesOrdered;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
}
