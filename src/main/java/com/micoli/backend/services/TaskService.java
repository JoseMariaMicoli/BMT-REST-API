package com.micoli.backend.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.micoli.backend.entities.Task;
import com.micoli.backend.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	public ResponseEntity<Collection<Task>> getAllTasks() {
		return new ResponseEntity<>((Collection<Task>) repository.findAll(), HttpStatus.OK);
		
	}
	
	public ResponseEntity<Task> getTaskWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }
	
	public ResponseEntity<Collection<Task>> findTaskWithName(@RequestParam(value="name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }
	
	public ResponseEntity<?> addTask(@RequestBody Task input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }
	
	public ResponseEntity<?> updateTask(@PathVariable("id") long id, @RequestBody Task task) {
    	Task currentTask = repository.findOne(id);
    	
    	if(currentTask == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		currentTask.setName(task.getName());
    		currentTask.setDescription(task.getDescription());
    		currentTask.setStatus(task.isStatus());
    		currentTask.setDate(task.getDate());
    		currentTask.setUsers(task.getUsers());
    		repository.save(currentTask);
    		return new ResponseEntity<Task>(currentTask, HttpStatus.OK);
    	}
    }
	
	public ResponseEntity<?> deleteTask(@PathVariable("id") long id, @RequestBody Task task) {
    	Task currentTask = repository.findOne(id);
    	
    	if(currentTask == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		repository.delete(currentTask.getId());
    		return new ResponseEntity<Task>(currentTask, HttpStatus.OK);
    	}
    }

}
