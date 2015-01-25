package com.chefensaapi.components;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.chefensaapi.components.interfaces.IMenuService;
import com.chefensaapi.dao.ChefDao;
import com.chefensaapi.dao.MealDao;
import com.chefensaapi.models.Chef;
import com.chefensaapi.models.Meal;

@Component
public class MenuService implements IMenuService {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	MealDao mealDao = (MealDao)context.getBean("mealDao");
	ChefDao chefDao = (ChefDao)context.getBean("chefDao");
	
	public void addMeal(Meal mealDetail) {

		Chef chef = chefDao.getChefInfo(mealDetail.getChefId());

		Meal meal = new Meal(mealDetail.getMealName(),
				mealDetail.getMealContent(), mealDetail.getMealDescription(),
				mealDetail.getMealType(), mealDetail.getMealCategory(),
				mealDetail.getMealNote(), mealDetail.getMealNutrients(),
				mealDetail.getMealImageUrl(), chef.getName(),
				chef.getImageUrl(), mealDetail.getChefId(),
				mealDetail.getSpicyness(), mealDetail.getMealPrice(),
				mealDetail.getRating(), mealDetail.getMealDate(),
				mealDetail.getMealTime(), mealDetail.getMealQuantity(),
				mealDetail.getAvailability());
		mealDao.addMealInfo(meal);

	}

	public List<Meal> getMenuForDay() {
		Calendar cal = Calendar.getInstance();
		return mealDao.getMealOnDate(cal.get(Calendar.YEAR) + ":" +(cal.get(Calendar.MONTH )+1) + ":" + cal.get(Calendar.DATE));
	}

	public String getMealAvailability() {
		Calendar cal = Calendar.getInstance();
		return mealDao.getMealAvailability(cal.get(Calendar.YEAR) + ":" +(cal.get(Calendar.MONTH )+1) + ":" + cal.get(Calendar.DATE));
	}
	
}
