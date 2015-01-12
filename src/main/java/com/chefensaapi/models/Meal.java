package com.chefensaapi.models;

public class Meal {

	private long mealId;
	private String mealName;
	private String mealContent;
	private String mealDescription;
	private String mealType;
	private int mealCategory;
	private String mealNote;
	private String mealNutrients;
	private String mealImageUrl;
	private String chefName;
	private String chefImageUrl;
	private long chefId;
	private int spicyness;
	private int mealPrice;
	private long totalMealsOrdered;
	private long totalRating;
	private long numberOfUsers;

	public Meal(long mealId, String mealName, String mealContent,
			String mealDescription, String mealType, int mealCategory,
			String mealNote, String mealNutrients, String mealImageUrl,
			String chefName, String chefImageUrl, long chefId, int spicyness,
			int mealPrice, long totalMealsOrdered, long totalRating,
			long numberOfUsers) {
		super();
		this.mealId = mealId;
		this.mealName = mealName;
		this.mealContent = mealContent;
		this.mealDescription = mealDescription;
		this.mealType = mealType;
		this.mealCategory = mealCategory;
		this.mealNote = mealNote;
		this.mealNutrients = mealNutrients;
		this.mealImageUrl = mealImageUrl;
		this.chefName = chefName;
		this.chefImageUrl = chefImageUrl;
		this.chefId = chefId;
		this.spicyness = spicyness;
		this.mealPrice = mealPrice;
		this.totalMealsOrdered = totalMealsOrdered;
		this.totalRating = totalRating;
		this.numberOfUsers = numberOfUsers;
	}
	
	public Meal(String mealName, String mealContent, String mealDescription,
			String mealType, int mealCategory, String mealNote,
			String mealNutrients, String mealImageUrl, String chefName,
			String chefImageUrl, long chefId, int spicyness, int mealPrice) {
		super();
		this.mealName = mealName;
		this.mealContent = mealContent;
		this.mealDescription = mealDescription;
		this.mealType = mealType;
		this.mealCategory = mealCategory;
		this.mealNote = mealNote;
		this.mealNutrients = mealNutrients;
		this.mealImageUrl = mealImageUrl;
		this.chefName = chefName;
		this.chefImageUrl = chefImageUrl;
		this.chefId = chefId;
		this.spicyness = spicyness;
		this.mealPrice = mealPrice;
	}

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
	public String getMealContent() {
		return mealContent;
	}

	public void setMealContent(String mealContent) {
		this.mealContent = mealContent;
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
	public String getChefName() {
		return chefName;
	}

	public void setChefName(String chefName) {
		this.chefName = chefName;
	}

	public String getChefImageUrl() {
		return chefImageUrl;
	}

	public void setChefImageUrl(String chefImageUrl) {
		this.chefImageUrl = chefImageUrl;
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
}
