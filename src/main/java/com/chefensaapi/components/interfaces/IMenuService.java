package com.chefensaapi.components.interfaces;

import java.util.List;

import com.chefensaapi.details.MealDetail;
import com.chefensaapi.models.Meal;

public interface IMenuService {
	
	public void addMeal(MealDetail mealDetail);

	public List<Meal> getMenuForDay(String date);
}
