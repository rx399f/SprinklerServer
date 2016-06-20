package com.ideaincubator.sprinkler.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ideaincubator.sprinkler.domain.SprinklerHealth;
import com.ideaincubator.sprinkler.repository.SprinklerHealthRepository;

@Controller
@RequestMapping("/sprinklerHealth")
public class SprinklerHealthResource {

	private SprinklerHealthRepository sprinklerHealthRepository;
	
	 @Autowired
	    public SprinklerHealthResource(SprinklerHealthRepository sprinklerHealthRepository) {
	        this.sprinklerHealthRepository = sprinklerHealthRepository;
	    }
	 public SprinklerHealthResource(){
		 
	 }
	 @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public ResponseEntity<Void> submitSprinklerHealthData(@RequestBody SprinklerHealth module) {
	    	module.setTimeStamp(new Date());
	    	sprinklerHealthRepository.save(module);
	        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
	        return responseEntity;
	    }
	 
	 @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public List<SprinklerHealth> allSprinklerHealthData() {
	        return sprinklerHealthRepository.findAll();
	    }
	 
	 @RequestMapping(method=RequestMethod.GET, value = "/{sprinklerHealthId}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public SprinklerHealth getSensor(@PathVariable("sprinklerHealthId") String sprinklerHealthId) {
		 SprinklerHealth module = sprinklerHealthRepository.findOne(sprinklerHealthId);
	        if (module == null) {
	          //  throw new RouteNotFoundException(routeId);
	        }
	        return module;
	    }
}
