package com.chefensaapi.components.interfaces;

import java.util.List;

import com.chefensaapi.details.ChefDetail;
import com.chefensaapi.models.Chef;

public interface IChefService {

	public long addChefDetail(ChefDetail chef);
	
	public Chef getChefDetail(long id);
	
	public List<ChefDetail> getAllChefs();
}
