package com.chefensaapi.models;


public class Chef {
	
	private long chefId;
	private String chefName;
	private int gender; 			//
	private String phoneNumber;
	private String emailId;
	private long addressId;			//
	private String chefImageUrl;	//
	private String chefDescription;
	private String languages;
	private int maritalStatus;		//
	private String ethnicity;
	private int chefCategory;
	private int mealCategory;			//veg/non veg/egg
	private String workingDays;		//
	private int workingTime;		//
	private String mealTypes;
	private String chefSpeciality;
	private String chefRating;
	private int capacity;			//number of meals each time
	private int experience;			//experience with chefensa
	private long createTime;
	
	public Chef(long chefId, String chefName, int gender, String phoneNumber,
			String emailId, long addressId, String chefImageUrl,
			String chefDescription, String languages, int maritalStatus,
			String ethnicity, int chefCategory, int mealCategory,
			String workingDays, int workingTime, String mealTypes,
			String chefSpeciality, String chefRating, int capacity,
			int experience, long createTime) {
		super();
		this.chefId = chefId;
		this.chefName = chefName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.addressId = addressId;
		this.chefImageUrl = chefImageUrl;
		this.chefDescription = chefDescription;
		this.languages = languages;
		this.maritalStatus = maritalStatus;
		this.ethnicity = ethnicity;
		this.chefCategory = chefCategory;
		this.mealCategory = mealCategory;
		this.workingDays = workingDays;
		this.workingTime = workingTime;
		this.mealTypes = mealTypes;
		this.chefSpeciality = chefSpeciality;
		this.chefRating = chefRating;
		this.capacity = capacity;
		this.experience = experience;
		this.createTime = createTime;
	}
	
	public Chef(String chefName, int gender, String phoneNumber,
			String emailId, long addressId, String chefImageUrl,
			String chefDescription, String languages, int maritalStatus,
			String ethnicity, int chefCategory, int mealCategory,
			String workingDays, int workingTime, String mealTypes,
			String chefSpeciality, int capacity) {
		super();
		this.chefName = chefName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.addressId = addressId;
		this.chefImageUrl = chefImageUrl;
		this.chefDescription = chefDescription;
		this.languages = languages;
		this.maritalStatus = maritalStatus;
		this.ethnicity = ethnicity;
		this.chefCategory = chefCategory;
		this.mealCategory = mealCategory;
		this.workingDays = workingDays;
		this.workingTime = workingTime;
		this.mealTypes = mealTypes;
		this.chefSpeciality = chefSpeciality;
		this.capacity = capacity;
	}
	
	public long getChefId() {
		return chefId;
	}
	public void setChefId(long chefId) {
		this.chefId = chefId;
	}
	public String getChefName() {
		return chefName;
	}
	public void setChefName(String chefName) {
		this.chefName = chefName;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getChefImageUrl() {
		return chefImageUrl;
	}
	public void setChefImageUrl(String chefImageUrl) {
		this.chefImageUrl = chefImageUrl;
	}
	public String getChefDescription() {
		return chefDescription;
	}
	public void setChefDescription(String chefDescription) {
		this.chefDescription = chefDescription;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public int getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(int maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public int getChefCategory() {
		return chefCategory;
	}
	public void setChefCategory(int chefCategory) {
		this.chefCategory = chefCategory;
	}
	public int getMealCategory() {
		return mealCategory;
	}
	public void setMealCategory(int mealCategory) {
		this.mealCategory = mealCategory;
	}
	public String getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}
	public int getWorkingTime() {
		return workingTime;
	}
	public void setWorkingTime(int workingTime) {
		this.workingTime = workingTime;
	}
	public String getMealTypes() {
		return mealTypes;
	}
	public void setMealTypes(String mealTypes) {
		this.mealTypes = mealTypes;
	}
	public String getChefSpeciality() {
		return chefSpeciality;
	}
	public void setChefSpeciality(String chefSpeciality) {
		this.chefSpeciality = chefSpeciality;
	}
	public String getChefRating() {
		return chefRating;
	}
	public void setChefRating(String chefRating) {
		this.chefRating = chefRating;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
}
