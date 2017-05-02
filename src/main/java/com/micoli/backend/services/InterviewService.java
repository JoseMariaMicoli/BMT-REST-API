package com.micoli.backend.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.micoli.backend.entities.Interview;
import com.micoli.backend.repositories.InterviewRepository;

@Service
public class InterviewService {
	
	@Autowired
	private InterviewRepository repository;
	
	public ResponseEntity<Collection<Interview>> getAllInterviews() {
		return new ResponseEntity<>((Collection<Interview>) repository.findAll(), HttpStatus.OK);
		
	}
	
	public ResponseEntity<Interview> getInterviewWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }
	
	public ResponseEntity<?> addInterview(@RequestBody Interview input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }
	
	public ResponseEntity<?> updateInterview(@PathVariable("id") long id, @RequestBody Interview interview) {
    	Interview currentInterview = repository.findOne(id);
    	
    	if(currentInterview == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		currentInterview.setPosition(interview.getPosition());
    		currentInterview.setDate(interview.getDate());
    		currentInterview.setCandidate(interview.getCandidate());
    		currentInterview.setCustomer(interview.getCustomer());
    		currentInterview.setUser(interview.getUser());
    		currentInterview.setComments(interview.getComments());
    		repository.save(currentInterview);
    		return new ResponseEntity<Interview>(currentInterview, HttpStatus.OK);
    	}
    }
	
	public ResponseEntity<?> deleteInterview(@PathVariable("id") long id, @RequestBody Interview interview) {
    	Interview currentInterview = repository.findOne(id);
    	
    	if(currentInterview == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		repository.delete(currentInterview.getId());
    		return new ResponseEntity<Interview>(currentInterview, HttpStatus.OK);
    	}
    }

}
