package com.chefensaapi.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.chefensaapi.components.interfaces.IChefService;
import com.chefensaapi.dao.AddressDao;
import com.chefensaapi.dao.ChefDao;
import com.chefensaapi.details.ChefDetail;
import com.chefensaapi.models.Address;
import com.chefensaapi.models.Chef;

@Component
public class ChefService implements IChefService {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	ChefDao chefDao = (ChefDao) context.getBean("chefDao");
	AddressDao addressDao = (AddressDao)context.getBean("addressDao");

	public Chef getChefDetail(long chefId) {
		Chef chef = chefDao.getChefInfo(chefId);
		return chef;
	}
	
	public List<ChefDetail> getAllChefs(){
		List<ChefDetail> chefDetails = new ArrayList<ChefDetail>(); 
		List<Chef> chefs = chefDao.getChefsList();
		for (Iterator<Chef> iterator = chefs.iterator(); iterator.hasNext();) {
			Chef chef = iterator.next();
			ChefDetail chefDetail = new ChefDetail();
			chefDetail.setChefId(chef.getId());
			chefDetail.setChefName(chef.getName());
			chefDetails.add(chefDetail);
		}
		return chefDetails;
	}
	
	@Override
	public long addChefDetail(ChefDetail chefDetail) {
		
		Address address = new Address("India", "Karnataka", "Bengaluru", chefDetail.getLocality(), 
				chefDetail.getPin(), chefDetail.getStreetName(), chefDetail.getBuildingName(), chefDetail.getFlatNumber(), chefDetail.getLandmark());
		
		long addressId = addressDao.saveAddress(address);
		
		Chef chef = new Chef(chefDetail.getChefName(), chefDetail.getGender(), chefDetail.getPhoneNumber(), chefDetail.getEmailId(), addressId, 
				chefDetail.getChefImageUrl(), chefDetail.getChefDescription(), chefDetail.getLanguages(), chefDetail.getMaritalStatus(), 
				chefDetail.getEthnicity(), chefDetail.getChefCategory(), chefDetail.getMealCategory(), chefDetail.getWorkingDays(), 
				chefDetail.getWorkingTime(), chefDetail.getMealTypes(), chefDetail.getChefSpeciality(), chefDetail.getCapacity());
		
		return chefDao.addChefInfo(chef);
	}

}
