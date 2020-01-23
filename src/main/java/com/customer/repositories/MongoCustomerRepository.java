package com.customer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.customer.document.CustomerDocument;


public interface MongoCustomerRepository extends MongoRepository<CustomerDocument, Integer> {
	
	

}
