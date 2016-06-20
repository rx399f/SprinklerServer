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

import com.ideaincubator.sprinkler.domain.Motor;
import com.ideaincubator.sprinkler.repository.MotorModuleRepository;

@Controller
@RequestMapping("/motor")
public class MotorResource {

	private MotorModuleRepository motorModuleRepository;
	
	public MotorResource(){
		
	}
	 @Autowired
	 public MotorResource(MotorModuleRepository motorModuleRepository) {
	        this.motorModuleRepository = motorModuleRepository;
	 }
	 
	 @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public ResponseEntity<Void> submitMotor(@RequestBody Motor module) {
	    	module.setTimeStamp(new Date());
	    	motorModuleRepository.save(module);
	        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
	        return responseEntity;
	    }
	 
	 @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public List<Motor> allMotor() {
	        return motorModuleRepository.findAll();
	    }
	 
	 
	 @RequestMapping(method=RequestMethod.GET, value = "/{motorId}", produces = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public Motor getSensor(@PathVariable("motorId") String motorId) {
	    	Motor module = motorModuleRepository.findOne(motorId);
	        if (module == null) {
	          //  throw new RouteNotFoundException(routeId);
	        }
	        return module;
	    }

}
