package com.ideaincubator.sprinkler.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.ideaincubator.sprinkler.domain.Route;
import com.ideaincubator.sprinkler.repository.RouteRepository;

@Controller
@RequestMapping("/routes")
public class RouteResource {

    private RouteRepository routeRepository;

    @Autowired
    public RouteResource(RouteRepository storyRepository) {
        this.routeRepository = storyRepository;
    }
    
    public RouteResource(){
    	
    }

    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> submitStory(@RequestBody Route route) {
        //Story storyWithExtractedInformation = decorateWithInformation(story);
    	System.out.println("$$$$$$$$$$$$$$$$$$"+route.getName());
    	System.out.println("$$$$$$$$$$$$$$$$$$"+route.getLocation());
    	System.out.println("$$$$$$$$$$$$$$$$$$"+route.getDescription());
    	Route nwStory = new Route(route);
        routeRepository.save(route);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Route> allRoutes() {
        return routeRepository.findAll();
    }

    @RequestMapping(value = "/{routeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Route showStory(@PathVariable("routeId") String routeId) {
        Route route = routeRepository.findOne(routeId);
        if (route == null) {
            throw new RouteNotFoundException(routeId);
        }
        return route;
    }
}
