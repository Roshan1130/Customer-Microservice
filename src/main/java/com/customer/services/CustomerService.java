package com.customer.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.customer.dtos.CustomerDto;
import com.customer.entities.CustomerEntity;
import com.customer.repositories.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public void createCustomer(CustomerDto dto) {
		CustomerEntity entity = new CustomerEntity();
		entity.setfName(dto.getFname());
		entity.setlName(dto.getLname());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setUuid(UUID.randomUUID().toString());
		customerRepository.save(entity);
		}
	
}