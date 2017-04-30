package com.micoli.backend.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.micoli.backend.entities.Product;
import com.micoli.backend.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public ResponseEntity<Collection<Product>> getAllProducts() {
		return new ResponseEntity<>((Collection<Product>) repository.findAll(), HttpStatus.OK);
		
	}
	
	public ResponseEntity<Product> getProductWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }
	
	public ResponseEntity<Collection<Product>> findProductWithName(@RequestParam(value="name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }
	
	public ResponseEntity<?> addProduct(@RequestBody Product input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }
	
	public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
    	Product currentProduct = repository.findOne(id);
    	
    	if(currentProduct == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		currentProduct.setName(product.getName());
    		currentProduct.setDescription(product.getDescription());
    		currentProduct.setQuantity(product.getQuantity());
    		currentProduct.setPrice(product.getPrice());
    		repository.save(currentProduct);
    		return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
    	}
    }
	
	public ResponseEntity<?> deleteProduct(@PathVariable("id") long id, @RequestBody Product product) {
    	Product currentProduct = repository.findOne(id);
    	
    	if(currentProduct == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		repository.delete(currentProduct.getId());
    		return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
    	}
    }

}
