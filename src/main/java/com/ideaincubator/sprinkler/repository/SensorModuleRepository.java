package com.ideaincubator.sprinkler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideaincubator.sprinkler.domain.SensorModule;

@Repository
public interface SensorModuleRepository extends CrudRepository<SensorModule, String> {

    public List<SensorModule> findAll();
}
