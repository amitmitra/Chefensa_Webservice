package com.chefensaapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chefensaapi.components.interfaces.IOrderService;
import com.chefensaapi.models.Customer;
import com.chefensaapi.models.Order;

@RestController
@RequestMapping("order")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping(value = "placeOrder", method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
    public int create(@RequestBody final Order entity) {
		return orderService.createOrder(entity);
    }
}
