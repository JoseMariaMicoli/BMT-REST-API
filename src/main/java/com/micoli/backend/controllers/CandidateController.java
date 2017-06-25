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

import com.micoli.backend.entities.Candidate;
import com.micoli.backend.services.CandidateService;

@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
@RequestMapping("api/candidates")
public class CandidateController {
	
	@Autowired
	private CandidateService service;
	
	//Get All Candidates - READ
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<Collection<Candidate>> getAllCandidates() {
			return service.getAllCandidates();
		}
		
		//Get Candidate by Id - Query
		@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	    public ResponseEntity<Candidate> getCandidateWithId(@PathVariable Long id) {
	        return service.getCandidateWithId(id);
	    }

		//Get Candidate by Name - Query
	    @RequestMapping(method = RequestMethod.GET, params = {"name"})
	    public ResponseEntity<Collection<Candidate>> findCandidateWithName(@RequestParam(value="name") String name) {
	        return service.findCandidateWithName(name);
	    }

	    //Create new Candidate
	    @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<?> addCandidate(@RequestBody Candidate input) {
	        return service.addCandidate(input);
	    }
	    
	    //Update Existing Candidate - UPDATE
	    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	    public ResponseEntity<?> updateCandidate(@PathVariable("id") long id, @RequestBody Candidate candidate) {
	    	return service.updateCandidate(id, candidate);
	    }
	    
	    //Delete Existing Candidate - DELETE
	    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	    public ResponseEntity<?> deleteCandidate(@PathVariable("id") long id, @RequestBody Candidate candidate) {
	    	return service.deleteCandidate(id, candidate);
	    }

}
