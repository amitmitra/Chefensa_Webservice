package com.chefensaapi.components;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.chefensaapi.components.interfaces.IMenuService;
import com.chefensaapi.dao.ChefDao;
import com.chefensaapi.dao.MealDao;
import com.chefensaapi.details.MealDetail;
import com.chefensaapi.models.Chef;
import com.chefensaapi.models.Meal;
import com.chefensaapi.models.Menu;

@Component
public class MenuService implements IMenuService {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	MealDao mealDao = (MealDao)context.getBean("mealDao");
	ChefDao chefDao = (ChefDao)context.getBean("chefDao");
	
	public void addMeal(MealDetail mealDetail){
		
		Chef chef = chefDao.getChefInfo(mealDetail.getChefId());
		
		Meal meal = new Meal(mealDetail.getMealName(), mealDetail.getMealComponents(), mealDetail.getMealDescription(), 
				mealDetail.getMealType(), mealDetail.getMealCategory(), mealDetail.getMealNote(), mealDetail.getMealNutrients(), 
				mealDetail.getMealImageUrl(), chef.getChefName(), chef.getChefImageUrl(), mealDetail.getChefId(), mealDetail.getSpicyness(),
				mealDetail.getMealPrice());
		long mealId = mealDao.addMealInfo(meal);
		
		Menu menu = new Menu(mealId, mealDetail.getMenuDate(), mealDetail.getAvailability());
		mealDao.addMenuInfo(menu);
	}

	public List<Meal> getMenuForDay(String date) {
		return mealDao.getMealOnDate(date);
	}
}
