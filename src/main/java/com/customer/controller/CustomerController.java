package com.customer.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.document.CustomerDocument;
import com.customer.dtos.CustomerDto;
import com.customer.repositories.MongoCustomerRepository;
import com.customer.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	private MongoCustomerRepository mongoCustomerRepository;
	
	public CustomerController(MongoCustomerRepository mongoCustomerRepository) {
		this.mongoCustomerRepository = mongoCustomerRepository;
	}

	private static final Logger logger = LogManager.getLogger(CustomerController.class);

	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void saveCustomer(@RequestBody CustomerDto dto) {
		customerService.createCustomer(dto);
		logger.trace("me method accessed");

	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public void saveCustomerDemo(@RequestParam Integer id) {
		logger.trace("me method accessed");
		logger.debug("debug loggin has occured");

	}
	
	@GetMapping("/all")
	public List<CustomerDocument> getAll(){
		return mongoCustomerRepository.findAll(); 

	}
	
	
	

}
