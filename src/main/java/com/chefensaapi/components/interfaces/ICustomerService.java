package com.chefensaapi.components.interfaces;

import com.chefensaapi.models.Customer;

public interface ICustomerService {

	public Customer getCustomerCompleteDetail(long customerId);

	public int createCustomerEntry(Customer entity);
	
	public int updateRecentAddress(long customerId ,String address, long phoneNumber);
}
