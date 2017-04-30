package com.micoli.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.micoli.backend.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	List<Customer> findByName(String name);

}
