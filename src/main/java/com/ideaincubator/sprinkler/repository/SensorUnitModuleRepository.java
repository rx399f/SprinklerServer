package com.ideaincubator.sprinkler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ideaincubator.sprinkler.domain.SensorUnitModule;

public interface SensorUnitModuleRepository extends CrudRepository<SensorUnitModule, String>{
	
	public List<SensorUnitModule> findAll();
}
