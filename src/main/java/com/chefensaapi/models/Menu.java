package com.chefensaapi.models;


public class Menu {
	
	private long mealId;
	private String mealDate;
	private String mealTime;
	private int mealQuantity;
	private int availability;
	
	public Menu(long mealId, String mealDate, String mealTime,
			int mealQuantity, int availability) {
		this.mealId = mealId;
		this.mealDate = mealDate;
		this.mealTime = mealTime;
		this.mealQuantity = mealQuantity;
		this.availability = availability;
	}

	public long getMealId() {
		return mealId;
	}

	public void setMealId(long mealId) {
		this.mealId = mealId;
	}

	public String getMealDate() {
		return mealDate;
	}

	public void setMealDate(String mealDate) {
		this.mealDate = mealDate;
	}

	public String getMealTime() {
		return mealTime;
	}

	public void setMealTime(String mealTime) {
		this.mealTime = mealTime;
	}

	public int getMealQuantity() {
		return mealQuantity;
	}

	public void setMealQuantity(int mealQuantity) {
		this.mealQuantity = mealQuantity;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
}
