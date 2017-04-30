package com.micoli.backend.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.micoli.backend.entities.Order;
import com.micoli.backend.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public ResponseEntity<Collection<Order>> getAllOrders() {
		return new ResponseEntity<>((Collection<Order>) repository.findAll(), HttpStatus.OK);
		
	}
	
	public ResponseEntity<Order> getOrderWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }
	
	public ResponseEntity<?> addOrder(@RequestBody Order input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }
	
	public ResponseEntity<?> updateOrder(@PathVariable("id") long id, @RequestBody Order order) {
    	Order currentOrder = repository.findOne(id);
    	
    	if(currentOrder == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		currentOrder.setStatus(order.getStatus());;
    		currentOrder.setDate(order.getDate());
    		currentOrder.setTotal(order.getTotal());
    		currentOrder.setUser(order.getUser());
    		currentOrder.setCustomer(order.getCustomer());
    		currentOrder.setProducts(order.getProducts());
    		currentOrder.setDeliveryDate(order.getDeliveryDate());
    		repository.save(currentOrder);
    		return new ResponseEntity<Order>(currentOrder, HttpStatus.OK);
    	}
    }
	
	public ResponseEntity<?> deleteOrder(@PathVariable("id") long id, @RequestBody Order order) {
    	Order currentOrder = repository.findOne(id);
    	
    	if(currentOrder == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		repository.delete(currentOrder.getId());
    		return new ResponseEntity<Order>(currentOrder, HttpStatus.OK);
    	}
    }

}
