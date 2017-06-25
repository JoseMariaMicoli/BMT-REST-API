package com.micoli.backend.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micoli.backend.entities.Customer;
import com.micoli.backend.services.CustomerService;

@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
@RequestMapping("api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
		//Get All Customers - READ
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<Collection<Customer>> getAllUsers() {
			return service.getAllCustomers();
		}
		
		//Get Customer by Id - Query
		@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	    public ResponseEntity<Customer> getCustomerWithId(@PathVariable Long id) {
	        return service.getCustomerWithId(id);
	    }

		//Get Customer by Name - Query
	    @RequestMapping(method = RequestMethod.GET, params = {"name"})
	    public ResponseEntity<Collection<Customer>> findUserWithName(@RequestParam(value="name") String name) {
	        return service.findCustomerWithName(name);
	    }

	    //Create new Customer
	    @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<?> addUser(@RequestBody Customer input) {
	        return service.addCustomer(input);
	    }
	    
	    //Update Existing Customer - UPDATE
	    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody Customer customer) {
	    	return service.updateCustomer(id, customer);
	    }
	    
	    //Delete Existing Customer - DELETE
	    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
	    	return service.deleteCustomer(id, customer);
	    }
	
}
