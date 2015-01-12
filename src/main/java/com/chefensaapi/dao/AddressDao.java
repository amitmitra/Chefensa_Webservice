package com.chefensaapi.dao;

import java.util.List;

import javax.sql.DataSource;

import com.chefensaapi.models.Address;

public interface AddressDao {

	public void setDataSource(DataSource dataSource);
	
	public long saveAddress(Address address);
	
	public Address getAddress(long addressId);
	
	public List<Address> getAllAddress();
}
