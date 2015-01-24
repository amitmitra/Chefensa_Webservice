package com.chefensaapi.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.chefensaapi.models.Meal;

public interface MealDao {
	
	public void setDataSource(DataSource dataSource);
	
	public List<Meal> getMealOnDate(String date);
	
	public Meal getMealWithId(long mealId);
	
	public Map<Long,Integer> getMealAvailability(String date);
	
	public long addMealInfo(Meal meal);
	
}
