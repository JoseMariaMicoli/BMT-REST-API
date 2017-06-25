package com.micoli.backend.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.micoli.backend.entities.Order;
import com.micoli.backend.services.OrderService;

@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
@RequestMapping("api/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
		//Get All Orders - READ
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<Collection<Order>> getAllOrders() {
			return service.getAllOrders();
		}
		
		//Get Order by Id - Query
		@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	    public ResponseEntity<Order> getUserWithId(@PathVariable Long id) {
	        return service.getOrderWithId(id);
	    }

	    //Create new Order
	    @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<?> addOrder(@RequestBody Order input) {
	        return service.addOrder(input);
	    }
	    
	    //Update Existing Order - UPDATE
	    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	    public ResponseEntity<?> updateOrder(@PathVariable("id") long id, @RequestBody Order order) {
	    	return service.updateOrder(id, order);
	    }
	    
	    //Delete Existing Order - DELETE
	    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	    public ResponseEntity<?> deleteOrder(@PathVariable("id") long id, @RequestBody Order order) {
	    	return service.deleteOrder(id, order);
	    }

}
