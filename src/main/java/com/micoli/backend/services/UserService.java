package com.micoli.backend.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.micoli.backend.entities.User;
import com.micoli.backend.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public ResponseEntity<Collection<User>> getAllUsers() {
		return new ResponseEntity<>((Collection<User>) repository.findAll(), HttpStatus.OK);
		
	}
	
	public ResponseEntity<User> getUserWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }
	
	public ResponseEntity<Collection<User>> findUserWithName(@RequestParam(value="name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }
	
	public ResponseEntity<?> addUser(@RequestBody User input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }
	
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
    	User currentUser = repository.findOne(id);
    	
    	if(currentUser == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		currentUser.setName(user.getName());
    		currentUser.setPhone1(user.getPhone1());
    		currentUser.setPhone2(user.getPhone2());
    		currentUser.setAddress(user.getAddress());
    		currentUser.setEmail(user.getEmail());
    		currentUser.setNick(user.getNick());
    		currentUser.setPassword(user.getPassword());
    		currentUser.setTasks(user.getTasks());
    		currentUser.setOrders(user.getOrders());
    		currentUser.setInterviews(currentUser.getInterviews());
    		currentUser.setPositions(user.getPositions());
    		repository.save(currentUser);
    		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    	}
    }
	
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
