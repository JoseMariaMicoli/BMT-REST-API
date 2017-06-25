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

import com.micoli.backend.entities.Task;
import com.micoli.backend.services.TaskService;

@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {
	
	@Autowired
	private TaskService service;
	
		//Get All Tasks - READ
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<Collection<Task>> getAllUsers() {
			return service.getAllTasks();
		}
		
		//Get Task by Id - Query
		@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	    public ResponseEntity<Task> getUserWithId(@PathVariable Long id) {
	        return service.getTaskWithId(id);
	    }

		//Get Task by Name - Query
	    @RequestMapping(method = RequestMethod.GET, params = {"name"})
	    public ResponseEntity<Collection<Task>> findUserWithName(@RequestParam(value="name") String name) {
	        return service.findTaskWithName(name);
	    }

	    //Create new Task
	    @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<?> addUser(@RequestBody Task input) {
	        return service.addTask(input);
	    }
	    
	    //Update Existing Task - UPDATE
	    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	    public ResponseEntity<?> updateTask(@PathVariable("id") long id, @RequestBody Task task) {
	    	return service.updateTask(id, task);
	    }
	    
	    //Delete Existing Task - DELETE
	    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	    public ResponseEntity<?> deleteTask(@PathVariable("id") long id, @RequestBody Task task) {
	    	return service.deleteTask(id, task);
	    }

}
