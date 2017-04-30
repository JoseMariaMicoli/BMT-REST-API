package com.micoli.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.micoli.backend.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findByName(String name);

}
