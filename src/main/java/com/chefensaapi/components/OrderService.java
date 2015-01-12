package com.chefensaapi.components;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.chefensaapi.components.interfaces.IOrderService;
import com.chefensaapi.dao.CustomerDao;
import com.chefensaapi.dao.OrderDao;
import com.chefensaapi.dao.implementations.JdbcOrderDao;
import com.chefensaapi.models.Order;

@Component
public class OrderService implements IOrderService {
	//hello
	public int createOrder(Order order) {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
		OrderDao orderDao= (OrderDao) context.getBean("orderDao");
		int response = orderDao.createOrder(order);
		return response;
	}
}
