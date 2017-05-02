package com.micoli.backend.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.micoli.backend.entities.Candidate;
import com.micoli.backend.repositories.CandidateRepository;

@Service
public class CandidateService {
	
	@Autowired
	private CandidateRepository repository;
	
	public ResponseEntity<Collection<Candidate>> getAllCandidates() {
		return new ResponseEntity<>((Collection<Candidate>) repository.findAll(), HttpStatus.OK);
		
	}
	
	public ResponseEntity<Candidate> getCandidateWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }
	
	public ResponseEntity<Collection<Candidate>> findCandidateWithName(@RequestParam(value="name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }
	
	public ResponseEntity<?> addCandidate(@RequestBody Candidate input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }
	
	public ResponseEntity<?> updateCandidate(@PathVariable("id") Long id, @RequestBody Candidate candidate) {
    	Candidate currentCandidate = repository.findOne(id);
    	
    	if(currentCandidate == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		currentCandidate.setName(candidate.getName());
    		currentCandidate.setPhone1(candidate.getPhone1());
    		currentCandidate.setPhone2(candidate.getPhone2());
    		currentCandidate.setEmail(candidate.getEmail());
    		currentCandidate.setSeniority(candidate.getSeniority());
    		currentCandidate.setRole(candidate.getSeniority());
    		currentCandidate.setDni(candidate.getDni());
    		currentCandidate.setInterviews(candidate.getInterviews());
    		currentCandidate.setPositions(candidate.getPositions());
    		repository.save(currentCandidate);
    		return new ResponseEntity<Candidate>(currentCandidate, HttpStatus.OK);
    	}
    }
	
	public ResponseEntity<?> deleteCandidate(@PathVariable("id") Long id, @RequestBody Candidate candidate) {
    	Candidate currentCandidate = repository.findOne(id);
    	
    	if(currentCandidate == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		repository.delete(currentCandidate.getId());
    		return new ResponseEntity<Candidate>(currentCandidate, HttpStatus.OK);
    	}
    }

}
