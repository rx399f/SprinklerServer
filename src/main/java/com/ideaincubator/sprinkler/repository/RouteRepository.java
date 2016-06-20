package com.ideaincubator.sprinkler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideaincubator.sprinkler.domain.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, String> {

    public List<Route> findAll();
}
