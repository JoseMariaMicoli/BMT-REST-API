package com.micoli.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.micoli.backend.entities.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {
	
	List<Candidate> findByName(String name);

}
