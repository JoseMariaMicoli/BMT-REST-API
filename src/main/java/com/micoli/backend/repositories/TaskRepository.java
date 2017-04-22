package com.micoli.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.micoli.backend.entities.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
	
	List<Task> findByName(String name);

}
