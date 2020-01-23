package com.customer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customer.entities.CustomerEntity;

@Repository
public interface CustomerRepository extends CrudRepository <CustomerEntity, Integer> {
	

}
