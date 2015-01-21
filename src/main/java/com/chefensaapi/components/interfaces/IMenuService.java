package com.chefensaapi.components.interfaces;

import java.util.List;

import com.chefensaapi.models.Meal;

public interface IMenuService {
	
	public void addMeal(Meal mealDetail);

	public List<Meal> getMenuForDay(String date);
}
