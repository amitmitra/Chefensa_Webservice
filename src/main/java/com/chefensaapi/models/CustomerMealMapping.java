package com.chefensaapi.models;

public class CustomerMealMapping {

	private long customerId;
	private long mealId;
	private long hitsOnMeal;
	private long noOfTimesOrdered;
	private double rating;
	private String review;
	
	public CustomerMealMapping(long customerId, long mealId) {
		super();
		this.customerId = customerId;
		this.mealId = mealId;
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
