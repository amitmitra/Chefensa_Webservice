package com.chefensaapi.components.interfaces;

import java.util.List;
import java.util.Map;

import com.chefensaapi.models.Meal;

public interface IMenuService {
	
	public void addMeal(Meal mealDetail);

	public List<Meal> getMenuForDay(String date);
	
	public Map<Long,Integer> getMealAvailability(String date);
}
