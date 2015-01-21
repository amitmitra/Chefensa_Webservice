package com.chefensaapi.dao;

import java.util.List;

import javax.sql.DataSource;

import com.chefensaapi.models.Meal;

public interface MealDao {
	
	public void setDataSource(DataSource dataSource);
	
	public List<Meal> getMealOnDate(String date);
	
	public Meal getMealWithId(long mealId);
	
	public long addMealInfo(Meal meal);
	
}
