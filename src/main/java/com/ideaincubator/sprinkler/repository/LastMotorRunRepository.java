package com.ideaincubator.sprinkler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideaincubator.sprinkler.domain.LastMotorRun;
import com.ideaincubator.sprinkler.domain.SprinklerHealth;

@Repository
public interface LastMotorRunRepository extends CrudRepository<LastMotorRun, String>{
	
	public List<LastMotorRun> findAll();
}
