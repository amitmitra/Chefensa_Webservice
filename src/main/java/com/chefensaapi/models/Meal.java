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
	private float rating;
	private long totalMealsOrdered;
	
	public Meal(long mealId, String mealName, String mealContent,
			String mealDescription, String mealType, int mealCategory,
			String mealNote, String mealNutrients, String mealImageUrl,
			String chefName, String chefImageUrl, long chefId, int spicyness,
			int mealPrice, float rating, long totalMealsOrdered) {
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
		this.rating = rating;
		this.totalMealsOrdered = totalMealsOrdered;
	}
	public Meal(String mealName, String mealContent, String mealDescription,
			String mealType, int mealCategory, String mealNote,
			String mealNutrients, String mealImageUrl, String chefName,
			String chefImageUrl, long chefId, int spicyness, int mealPrice,
			float rating) {
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
		this.rating = rating;
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
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public long getTotalMealsOrdered() {
		return totalMealsOrdered;
	}
	public void setTotalMealsOrdered(long totalMealsOrdered) {
		this.totalMealsOrdered = totalMealsOrdered;
	}
}
