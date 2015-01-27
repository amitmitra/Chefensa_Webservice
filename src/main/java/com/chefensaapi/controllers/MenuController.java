package com.chefensaapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chefensaapi.components.interfaces.IMenuService;
import com.chefensaapi.models.Meal;


@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private IMenuService menuService;
	
	@RequestMapping("/menuList")
	public List<Meal> getMenu(){
		List<Meal> menu = menuService.getMenuForDay();
		return menu;
	}
	
	@RequestMapping("/allMealsList")
	public List<Meal> getAllMeals(){
		List<Meal> menu = menuService.getAllMeals();
		return menu;
	}
	
	@RequestMapping(value = "/mealInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public Meal getMeal(@RequestParam(value = "mealId", required = false, defaultValue = "-1") long mealId){
		return menuService.getMeal(mealId);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void createMeal(@RequestBody final Meal entity){
		menuService.addMeal(entity);
	}
	
	@RequestMapping("/menuList/mealCount")
	public String getMealAvailability(){
		String availability = menuService.getMealAvailability();
		return availability;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public long updateMeal(@RequestBody final Meal entity){
		return menuService.updateMeal(entity);
	}

}
