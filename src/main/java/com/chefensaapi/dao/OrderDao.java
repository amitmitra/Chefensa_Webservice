package com.chefensaapi.dao;

import java.util.List;

import javax.sql.DataSource;

import com.chefensaapi.models.Order;

public interface OrderDao {

	public void setDataSource(DataSource dataSource);
	public int createOrder(Order order);
	public List<Order> getOrder(long customerId, String date);
	public Order getOrder(long customerId, String date, String time);
}
