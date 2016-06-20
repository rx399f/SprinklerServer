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
import com.ideaincubator.sprinkler.domain.SensorUnitModule;
import com.ideaincubator.sprinkler.repository.SensorUnitModuleRepository;

@Controller
@RequestMapping("/sensorUnit")
public class SensorUnitResource {

	private SensorUnitModuleRepository sensorUnitRepository;
	
	@Autowired
    public SensorUnitResource(SensorUnitModuleRepository sensorUnitRepository) {
        this.sensorUnitRepository = sensorUnitRepository;
    }
	
public SensorUnitResource(){
	
}
    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> submitSensorUnitData(@RequestBody SensorUnitModule module) {
    	module.setTimeStamp(new Date());
    	sensorUnitRepository.save(module);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
        return responseEntity;
    }
    
    @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<SensorUnitModule> allSensorUnitData() {
        return sensorUnitRepository.findAll();
    }
    
    @RequestMapping(method=RequestMethod.GET, value = "/{sensorUnitId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SensorUnitModule getSensor(@PathVariable("sensorUnitId") String sensorUnitId) {
    	SensorUnitModule module = sensorUnitRepository.findOne(sensorUnitId);
        if (module == null) {
          //  throw new RouteNotFoundException(routeId);
        }
        return module;
    }
}
