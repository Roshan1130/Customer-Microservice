package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.dtos.CustomerDto;
import com.customer.services.CustomerService;



@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void saveCustomer(@RequestBody CustomerDto dto) {
		customerService.createCustomer(dto);
	}
		
}
