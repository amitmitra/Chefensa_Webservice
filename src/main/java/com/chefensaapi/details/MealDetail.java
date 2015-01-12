package com.chefensaapi.details;

public class MealDetail {

	private long mealId;
	private String mealName;
	private String mealComponents;
	private String mealDescription;
	private String mealType;
	private int mealCategory;
	private String mealNote;
	private String mealNutrients;
	private String mealImageUrl;
	private long chefId;
	private int spicyness;
	private int mealPrice;
	private long totalMealsOrdered;
	private long totalRating;
	private long numberOfUsers;
	private String menuDate;
	private int availability;
	
	public long getMealId() {
		return mealId;
	}
	public void setMealId(long mealId) {
		this.mealId = mealId;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public String getMealComponents() {
		return mealComponents;
	}
	public void setMealComponents(String mealComponents) {
		this.mealComponents = mealComponents;
	}
	public String getMealDescription() {
		return mealDescription;
	}
	public void setMealDescription(String mealDescription) {
		this.mealDescription = mealDescription;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public int getMealCategory() {
		return mealCategory;
	}
	public void setMealCategory(int mealCategory) {
		this.mealCategory = mealCategory;
	}
	public String getMealNote() {
		return mealNote;
	}
	public void setMealNote(String mealNote) {
		this.mealNote = mealNote;
	}
	public String getMealNutrients() {
		return mealNutrients;
	}
	public void setMealNutrients(String mealNutrients) {
		this.mealNutrients = mealNutrients;
	}
	public String getMealImageUrl() {
		return mealImageUrl;
	}
	public void setMealImageUrl(String mealImageUrl) {
		this.mealImageUrl = mealImageUrl;
	}
	public long getChefId() {
		return chefId;
	}
	public void setChefId(long chefId) {
		this.chefId = chefId;
	}
	public int getSpicyness() {
		return spicyness;
	}
	public void setSpicyness(int spicyness) {
		this.spicyness = spicyness;
	}
	public int getMealPrice() {
		return mealPrice;
	}
	public void setMealPrice(int mealPrice) {
		this.mealPrice = mealPrice;
	}
	public long getTotalMealsOrdered() {
		return totalMealsOrdered;
	}
	public void setTotalMealsOrdered(long totalMealsOrdered) {
		this.totalMealsOrdered = totalMealsOrdered;
	}
	public long getTotalRating() {
		return totalRating;
	}
	public void setTotalRating(long totalRating) {
		this.totalRating = totalRating;
	}
	public long getNumberOfUsers() {
		return numberOfUsers;
	}
	public void setNumberOfUsers(long numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
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
