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
		/*customer.setCustomerName("harsh");
		customer.setDeviceId("12345");
		customer.setDateOfBirth("29/05/1991");
		customer.setCuisinePreference("Indian");
		customer.setGender("Male");
		customer.setMealType("Veg");
		customer.setPrimaryAddress("Flat 10");
		customer.setSecondaryAddress("Flat 11");
		customer.setPrimaryPhoneNo("12345");
		customer.setSecondaryPhoneNo("12345");
		customer.setPrimaryEmailId("asdf");
		customer.setSecondaryEmailId("gfdsa");
		customer.setProfileImageUrl("jkkllsdskd");
		customer.setSpicinessPreference("Very less");
		customer.setTotalHitsOnApp(20);
		customer.setTotalOrdersPlaced(30);*/
		return customer;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
    public int create(@RequestBody final Customer entity) {
		return customerService.createCustomerEntry(entity);
    }
}
