package com.micoli.backend.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micoli.backend.entities.User;
import com.micoli.backend.repositories.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	@Autowired
	private UserRepository repository;
	
	//Get All Users - READ
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<User>> getAllUsers() {
		return new ResponseEntity<>((Collection<User>) repository.findAll(), HttpStatus.OK);
		
	}
	
	//Get User by Id - Query
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<User> getUserWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }

	//Get User by Name - Query
    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public ResponseEntity<Collection<User>> findUserWithName(@RequestParam(value="name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }

    //Create new User
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }
    
    //Update Existing User - UPDATE
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
    	User currentUser = repository.findOne(id);
    	
    	if(currentUser == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		currentUser.setName(user.getName());
    		repository.save(currentUser);
    		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    	}
    }
    
    //Delete Existing User - DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id, @RequestBody User user) {
    	User currentUser = repository.findOne(id);
    	
    	if(currentUser == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		repository.delete(currentUser.getId());
    		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    	}
    }

}
