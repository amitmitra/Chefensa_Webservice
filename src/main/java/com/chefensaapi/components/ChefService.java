package com.chefensaapi.components;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.chefensaapi.components.interfaces.IChefService;
import com.chefensaapi.dao.ChefDao;
import com.chefensaapi.models.Chef;

@Component
public class ChefService implements IChefService {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	ChefDao chefDao = (ChefDao) context.getBean("chefDao");

	public Chef getChefDetail(long chefId) {
		Chef chef = chefDao.getChefInfo(chefId);
		return chef;
	}
	
	public List<Chef> getAllChefs(){ 
		List<Chef> chefs = chefDao.getChefsList();
		return chefs;
	}
	
	@Override
	public long addChefDetail(Chef chefDetail) {
		return chefDao.addChefInfo(chefDetail);
	}

	@Override
	public long updateChef(Chef chef) {
		return chefDao.updateChef(chef);
	}

}
