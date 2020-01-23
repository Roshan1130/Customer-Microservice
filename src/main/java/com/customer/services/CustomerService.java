package com.customer.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.document.CustomerDocument;
import com.customer.dtos.CustomerDto;
import com.customer.entities.CustomerEntity;
import com.customer.repositories.CustomerRepository;
import com.customer.repositories.MongoCustomerRepository;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private MongoCustomerRepository mongoCustomerRepository;

	public void createCustomer(CustomerDto dto) {
		CustomerEntity entity = new CustomerEntity();
		entity.setfName(dto.getFname());
		entity.setlName(dto.getLname());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setUuid(UUID.randomUUID().toString());
		customerRepository.save(entity);
		mongoCustomerRepository.save(convertToDoc(dto));
	}

	public CustomerDocument convertToDoc(CustomerDto dto) {
		CustomerDocument custDoc = null;
		if (dto != null) {

			custDoc = new CustomerDocument();
			custDoc.setId(1);
			custDoc.setUuid("39jf9");
			custDoc.setfName(dto.getFname());
			custDoc.setlName(dto.getLname());
			custDoc.setEmail(dto.getEmail());
			custDoc.setPhone(dto.getPhone());
			custDoc.setDetails("This is new data only in mongo");

		}
		return custDoc;
	}

}