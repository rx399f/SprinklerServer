package com.ideaincubator.sprinkler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ideaincubator.sprinkler.domain.WeatherDataModule;

@Repository
public interface WeatherModuleRepository extends CrudRepository<WeatherDataModule, String>{
	
	public List<WeatherDataModule> findAll();
}
