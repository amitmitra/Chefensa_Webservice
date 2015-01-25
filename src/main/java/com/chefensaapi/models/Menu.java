package com.chefensaapi.models;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	List<Meal> mealList = new ArrayList<Meal>();

	public List<Meal> getMealList() {
		return mealList;
	}

	public void setMealList(List<Meal> mealList) {
		this.mealList = mealList;
	}
	
}
