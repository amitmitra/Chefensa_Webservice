package com.chefensaapi.components;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.chefensaapi.components.interfaces.ICustomerService;
import com.chefensaapi.dao.CustomerDao;
import com.chefensaapi.models.Customer;

@Component
public class CustomerService implements ICustomerService {

	public Customer getCustomerCompleteDetail(long customerId) {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
		CustomerDao customerDao= (CustomerDao) context.getBean("customerDao");
		return customerDao.getCustomerInfo(customerId);
	}

	public long createCustomerEntry(Customer entity) {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
		CustomerDao customerDao= (CustomerDao) context.getBean("customerDao");
		customerDao.create(entity);
		return 0;
	}

	public int updateRecentAddress(long customerId ,String address, long phoneNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
}
