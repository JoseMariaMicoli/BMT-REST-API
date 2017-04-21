package com.micoli.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.micoli.backend.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	List<User> findByName(String name);
	
}
