package com.chefensaapi.dao;

import java.util.List;

import javax.sql.DataSource;

import com.chefensaapi.models.Meal;

public interface MealDao {
	
	public void setDataSource(DataSource dataSource);
	
	public List<Meal> getMealOnDate(String date);
	
	public List<Meal> getAllMeals();
	
	public String getMealAvailability(String date);
	
	public long addMealInfo(Meal meal);
	
	public Meal getMeal(long mealId);
	
	public long updateMeal(Meal meal);
	
}
