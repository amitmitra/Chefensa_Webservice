package com.chefensaapi.dao;

import javax.sql.DataSource;

import com.chefensaapi.models.Customer;

public interface CustomerDao {

	public void setDataSource(DataSource dataSource);
	public long create(Customer customer);
	public Customer getCustomerInfo(long customerId);
	public boolean customerExist(String deviceId);
	public long updateCustomer(String deviceId, Customer customer);
	public int increaseHitsCount(String deviceId);
}
