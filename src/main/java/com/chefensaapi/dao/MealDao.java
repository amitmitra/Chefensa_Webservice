package com.chefensaapi.dao;

import java.util.List;

import javax.sql.DataSource;

import com.chefensaapi.models.Meal;
import com.chefensaapi.models.Menu;

public interface MealDao {
	
	public void setDataSource(DataSource dataSource);
	
	public List<Meal> getMealOnDate(String date);
	
	public Meal getMealWithId(long mealId);
	
	public List<Menu> getMealAvailability(String date);
	
	public long addMealInfo(Meal meal);
	
	public void addMenuInfo(Menu menu);
	
}
