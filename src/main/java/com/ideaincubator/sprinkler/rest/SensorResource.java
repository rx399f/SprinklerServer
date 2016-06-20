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

import com.ideaincubator.sprinkler.domain.SensorModule;
import com.ideaincubator.sprinkler.repository.SensorModuleRepository;

@Controller
@RequestMapping("/sensor")
public class SensorResource {

    private SensorModuleRepository sensorRepository;

    @Autowired
    public SensorResource(SensorModuleRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public SensorResource(){
    	
    }
    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> submitSensor(@RequestBody SensorModule module) {
    	module.setUpdatedTime(new Date());
    	sensorRepository.save(module);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<SensorModule> allSensor() {
        return sensorRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.GET, value = "/{sensorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SensorModule getSensor(@PathVariable("sensorId") String sensorId) {
    	SensorModule module = sensorRepository.findOne(sensorId);
        if (module == null) {
          //  throw new RouteNotFoundException(routeId);
        }
        return module;
    }
}
