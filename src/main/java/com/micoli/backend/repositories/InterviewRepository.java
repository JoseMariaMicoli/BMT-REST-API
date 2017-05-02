package com.micoli.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.micoli.backend.entities.Interview;

public interface InterviewRepository extends CrudRepository<Interview, Long> {

}
