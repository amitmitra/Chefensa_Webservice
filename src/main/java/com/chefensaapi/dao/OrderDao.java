package com.chefensaapi.dao;

import javax.sql.DataSource;

import com.chefensaapi.models.Order;

public interface OrderDao {

	public void setDataSource(DataSource dataSource);
	public int createOrder(Order order);
}
