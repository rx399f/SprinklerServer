package com.ideaincubator.sprinkler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideaincubator.sprinkler.domain.SprinklerHealth;

@Repository
public interface SprinklerHealthRepository extends CrudRepository<SprinklerHealth, String>{
	
	public List<SprinklerHealth> findAll();
}
