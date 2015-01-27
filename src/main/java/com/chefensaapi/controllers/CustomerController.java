package com.chefensaapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.chefensaapi.components.interfaces.ICustomerService;
import com.chefensaapi.models.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping(value = "/customerInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerDetails(@RequestParam(value="id",required=false,defaultValue="-1") long customerId){
		Customer customer;//= new Customer();
		customer = customerService.getCustomerCompleteDetail(customerId);
		return customer;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
    public Customer create(@RequestBody final Customer entity) {
		customerService.createCustomerEntry(entity);
		return entity;
    }
	
	@RequestMapping(value = "/hit", method = RequestMethod.PUT)
	public int increaseHitOnApp(@RequestParam(value = "deviceId", required = true, defaultValue = "") String deviceId){
		return customerService.increaseHitsOnApp(deviceId);
	}
}
