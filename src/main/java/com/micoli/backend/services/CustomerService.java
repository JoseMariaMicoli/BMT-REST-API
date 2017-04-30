package com.micoli.backend.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.micoli.backend.entities.Customer;
import com.micoli.backend.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository repository;
	
	public ResponseEntity<Collection<Customer>> getAllCustomers() {
		return new ResponseEntity<>((Collection<Customer>) repository.findAll(), HttpStatus.OK);
		
	}
	
	public ResponseEntity<Customer> getCustomerWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }
	
	public ResponseEntity<Collection<Customer>> findCustomerWithName(@RequestParam(value="name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }
	
	public ResponseEntity<?> addCustomer(@RequestBody Customer input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }
	
	public ResponseEntity<?> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
    	Customer currentCustomer = repository.findOne(id);
    	
    	if(currentCustomer == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		currentCustomer.setName(customer.getName());
    		currentCustomer.setPhone1(customer.getPhone1());
    		currentCustomer.setPhone2(customer.getPhone2());
    		currentCustomer.setAddress1(customer.getAddress1());
    		currentCustomer.setAddress2(customer.getAddress2());
    		currentCustomer.setEmail(customer.getEmail());
    		repository.save(currentCustomer);
    		return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
    	}
    }
	
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") long id, @RequestBody Customer user) {
    	Customer currentCustomer = repository.findOne(id);
    	
    	if(currentCustomer == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		repository.delete(currentCustomer.getId());
    		return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
    	}
    }

}
