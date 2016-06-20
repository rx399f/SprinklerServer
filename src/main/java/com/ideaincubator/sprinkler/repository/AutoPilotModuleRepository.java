package com.ideaincubator.sprinkler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideaincubator.sprinkler.domain.AutoPilotModule;

@Repository
public interface AutoPilotModuleRepository extends CrudRepository<AutoPilotModule, String>{

	public List<AutoPilotModule> findAll();
}
