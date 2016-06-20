package com.ideaincubator.sprinkler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideaincubator.sprinkler.domain.Motor;

@Repository
public interface MotorModuleRepository extends CrudRepository<Motor, String>{

	public List<Motor> findAll();
}
