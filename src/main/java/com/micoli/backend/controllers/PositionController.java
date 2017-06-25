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

import com.micoli.backend.entities.Position;
import com.micoli.backend.services.PositionService;

@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
@RequestMapping("api/positions")
public class PositionController {
	
	@Autowired
	private PositionService service;
	
	//Get All Positions - READ
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Position>> getAllPositions() {
		return service.getAllPositions();
	}
	
	//Get Position by Id - Query
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Position> getPositionWithId(@PathVariable Long id) {
        return service.getPositionWithId(id);
    }

	//Get Position by Name - Query
    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public ResponseEntity<Collection<Position>> findPositionWithName(@RequestParam(value="name") String name) {
        return service.findPositionWithName(name);
    }

    //Create new Position
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPosition(@RequestBody Position input) {
        return service.addPosition(input);
    }
    
    //Update Existing Position - UPDATE
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> updatePosition(@PathVariable("id") long id, @RequestBody Position position) {
    	return service.updatePosition(id, position);
    }
    
    //Delete Existing Position - DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deletePosition(@PathVariable("id") long id, @RequestBody Position position) {
    	return service.deletePosition(id, position);
    }

}
