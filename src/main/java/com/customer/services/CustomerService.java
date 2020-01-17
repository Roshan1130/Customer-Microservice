package com.customer.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.customer.dtos.CustomerDto;
import com.customer.entities.CustomerEntity;
import com.customer.repositories.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerDto getByName(String fName) {
		return convert(customerRepository.findByfName(fName));
	}

	public void createCustomer(CustomerDto dto) {
		CustomerEntity entity = new CustomerEntity();
		entity.setfName(dto.getFname());
		entity.setlName(dto.getLname());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		customerRepository.save(entity);
		}
	
	public CustomerDto findById(Integer id) {
		Optional<CustomerEntity> cEntity = customerRepository.findById(id);
		return convert(cEntity.get());
	}

	public CustomerDto convert(CustomerEntity ent) {
		CustomerDto dtos = null;
		if (ent != null) {
			dtos = new CustomerDto();
			dtos.setId(ent.getId());
			dtos.setFname(ent.getfName());
			dtos.setLname(ent.getlName()); 
			dtos.setEmail(ent.getEmail());
			dtos.setPhone(ent.getPhone());
			dtos.setCreatedAt(ent.getCreatedAt());
			dtos.setUpdatedAt(ent.getUpdatedAt());
		}

		return dtos;
	}

	

}