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

import com.ideaincubator.sprinkler.domain.LastMotorRun;
import com.ideaincubator.sprinkler.repository.LastMotorRunRepository;

@Controller
@RequestMapping("/lastMotorRun")
public class LastMotorRunResource {

	private LastMotorRunRepository lastMotorRunRepository;
	
	 @Autowired
	    public LastMotorRunResource(LastMotorRunRepository lastMotorRunRepository) {
	        this.lastMotorRunRepository = lastMotorRunRepository;
	    }
	 
	 public LastMotorRunResource(){
		 
	 }
	 
	 @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public ResponseEntity<Void> submitLastMotorRunData(@RequestBody LastMotorRun module) {
	    	module.setTimeStamp(new Date());
	    	lastMotorRunRepository.save(module);
	        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
	        return responseEntity;
	    }
	 
	 @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public List<LastMotorRun> allMotorRunData() {
	        return lastMotorRunRepository.findAll();
	    }
	 
	 @RequestMapping(method=RequestMethod.GET, value = "/{motorId}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public LastMotorRun getSensor(@PathVariable("motorId") String motorId) {
		 LastMotorRun module = lastMotorRunRepository.findOne(motorId);
	        if (module == null) {
	          //  throw new RouteNotFoundException(routeId);
	        }
	        return module;
	    }
}
