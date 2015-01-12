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

import com.chefensaapi.components.interfaces.IChefService;
import com.chefensaapi.details.ChefDetail;
import com.chefensaapi.models.Chef;

@RestController
@RequestMapping("/chef")
public class ChefController {

	@Autowired
	private IChefService chefService;

	@RequestMapping(value = "/chefInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public Chef getChefDetails(
			@RequestParam(value = "id", required = false, defaultValue = "-1") long chefId) {
		Chef chef;
		chef = chefService.getChefDetail(chefId);
		return null;
	}
	
	@RequestMapping(value = "/allchefs", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ChefDetail> getChefsList(){
		return chefService.getAllChefs();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public long createChef(@RequestBody final ChefDetail entity) {
		return chefService.addChefDetail(entity);
	}
}