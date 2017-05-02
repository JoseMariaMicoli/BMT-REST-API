package com.micoli.backend.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.micoli.backend.entities.Interview;
import com.micoli.backend.services.InterviewService;

@RestController
@RequestMapping("api/interviews")
public class InterviewController {
	
	@Autowired
	private InterviewService service;
	
	//Get All Interviews - READ
			@RequestMapping(method = RequestMethod.GET)
			public ResponseEntity<Collection<Interview>> getAllInterviews() {
				return service.getAllInterviews();
			}
			
			//Get Interview by Id - Query
			@RequestMapping(method = RequestMethod.GET, value = "/{id}")
		    public ResponseEntity<Interview> getUserWithId(@PathVariable Long id) {
		        return service.getInterviewWithId(id);
		    }

		    //Create new Interview
		    @RequestMapping(method = RequestMethod.POST)
		    public ResponseEntity<?> addInterview(@RequestBody Interview input) {
		        return service.addInterview(input);
		    }
		    
		    //Update Existing Interview - UPDATE
		    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
		    public ResponseEntity<?> updateInterview(@PathVariable("id") long id, @RequestBody Interview interview) {
		    	return service.updateInterview(id, interview);
		    }
		    
		    //Delete Existing Interview - DELETE
		    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
		    public ResponseEntity<?> deleteInterview(@PathVariable("id") long id, @RequestBody Interview interview) {
		    	return service.deleteInterview(id, interview);
		    }

}
