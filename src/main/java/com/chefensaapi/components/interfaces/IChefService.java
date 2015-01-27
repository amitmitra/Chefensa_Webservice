package com.chefensaapi.components.interfaces;

import java.util.List;

import com.chefensaapi.models.Chef;

public interface IChefService {

	public long addChefDetail(Chef chefDetail);
	
	public Chef getChefDetail(long id);
	
	public List<Chef> getAllChefs();
	
	public long updateChef(Chef chef);
}
