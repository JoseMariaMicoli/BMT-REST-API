package com.micoli.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.micoli.backend.entities.Position;

public interface PositionRepository extends CrudRepository<Position, Long> {
	
	List<Position> findByName(String name);
	
}
