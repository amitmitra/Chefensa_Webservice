package com.chefensaapi.models;


public class Menu {
	
	private long menuId;
	private long mealId;	
	private String menuDate;
	private int availability;
	
	public Menu(long menuId, long mealId, String menuDate, int availability) {
		super();
		this.menuId = menuId;
		this.mealId = mealId;
		this.menuDate = menuDate;
		this.availability = availability;
	}
	
	public Menu(long mealId, String menuDate, int availability) {
		super();
		this.mealId = mealId;
		this.menuDate = menuDate;
		this.availability = availability;
	}


	public long getMenuId() {
		return menuId;
	}
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}
	public long getMealId() {
		return mealId;
	}
	public void setMealId(long mealId) {
		this.mealId = mealId;
	}
	public String getMenuDate() {
		return menuDate;
	}
	public void setMenuDate(String menuDate) {
		this.menuDate = menuDate;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
	
}
