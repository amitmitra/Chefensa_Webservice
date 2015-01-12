package com.chefensaapi.dao;

import java.util.List;

import javax.sql.DataSource;

import com.chefensaapi.models.Chef;

public interface ChefDao {

	public void setDataSource(DataSource dataSource);
	
	public Chef getChefInfo(long chef_id);
	
	public long addChefInfo(Chef chef);
	
	public List<Chef> getChefsList();

}
