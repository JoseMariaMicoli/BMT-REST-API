package com.micoli.backend.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micoli.backend.entities.Product;
import com.micoli.backend.services.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	//Get All Products - READ
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<Collection<Product>> getAllProducts() {
			return service.getAllProducts();
		}
		
		//Get Product by Id - Query
		@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	    public ResponseEntity<Product> getProductWithId(@PathVariable Long id) {
	        return service.getProductWithId(id);
	    }

		//Get Product by Name - Query
	    @RequestMapping(method = RequestMethod.GET, params = {"name"})
	    public ResponseEntity<Collection<Product>> findProductWithName(@RequestParam(value="name") String name) {
	        return service.findProductWithName(name);
	    }

	    //Create new Product
	    @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<?> addProduct(@RequestBody Product input) {
	        return service.addProduct(input);
	    }
	    
	    //Update Existing Product - UPDATE
	    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	    public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
	    	return service.updateProduct(id, product);
	    }
	    
	    //Delete Existing Product - DELETE
	    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	    public ResponseEntity<?> deleteProduct(@PathVariable("id") long id, @RequestBody Product product) {
	    	return service.deleteProduct(id, product);
	    }

}
