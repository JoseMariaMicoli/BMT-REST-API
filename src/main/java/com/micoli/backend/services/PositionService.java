package com.micoli.backend.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.micoli.backend.entities.Position;
import com.micoli.backend.repositories.PositionRepository;

@Service
public class PositionService {
	
	@Autowired
	private PositionRepository repository;
	
	public ResponseEntity<Collection<Position>> getAllPositions() {
		return new ResponseEntity<>((Collection<Position>) repository.findAll(), HttpStatus.OK);
		
	}
	
	public ResponseEntity<Position> getPositionWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }
	
	public ResponseEntity<Collection<Position>> findPositionWithName(@RequestParam(value="name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }
	
	public ResponseEntity<?> addPosition(@RequestBody Position input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }
	
	public ResponseEntity<?> updatePosition(@PathVariable("id") long id, @RequestBody Position position) {
    	Position currentPosition = repository.findOne(id);
    	
    	if(currentPosition == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		currentPosition.setName(position.getName());
    		currentPosition.setDescription(position.getDescription());
    		currentPosition.setDateStart(position.getDateStart());
    		currentPosition.setDateEnd(position.getDateEnd());
    		currentPosition.setStatus(position.getStatus());
    		currentPosition.setCandidates(position.getCandidates());
    		currentPosition.setUser(position.getUser());
    		currentPosition.setInterviews(position.getInterviews());
    		repository.save(currentPosition);
    		return new ResponseEntity<Position>(currentPosition, HttpStatus.OK);
    	}
    }
	
	public ResponseEntity<?> deletePosition(@PathVariable("id") long id, @RequestBody Position position) {
    	Position currentPosition = repository.findOne(id);
    	
    	if(currentPosition == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		repository.delete(currentPosition.getId());
    		return new ResponseEntity<Position>(currentPosition, HttpStatus.OK);
    	}
    }

}
