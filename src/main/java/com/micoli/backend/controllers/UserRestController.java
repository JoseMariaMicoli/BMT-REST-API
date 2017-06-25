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

import com.micoli.backend.entities.User;
import com.micoli.backend.services.UserService;

@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	@Autowired
	private UserService service;
	
	//Get All Users - READ
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<User>> getAllUsers() {
		return service.getAllUsers();
	}
	
	//Get User by Id - Query
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<User> getUserWithId(@PathVariable Long id) {
        return service.getUserWithId(id);
    }

	//Get User by Name - Query
    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public ResponseEntity<Collection<User>> findUserWithName(@RequestParam(value="name") String name) {
        return service.findUserWithName(name);
    }

    //Create new User
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User input) {
        return service.addUser(input);
    }
    
    //Update Existing User - UPDATE
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
    	return service.updateUser(id, user);
    }
    
    //Delete Existing User - DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id, @RequestBody User user) {
    	return service.deleteUser(id, user);
    }

}
