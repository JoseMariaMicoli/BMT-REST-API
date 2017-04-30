package com.micoli.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.micoli.backend.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
	
}
