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

import com.ideaincubator.sprinkler.domain.AutoPilotModule;
import com.ideaincubator.sprinkler.repository.AutoPilotModuleRepository;

@Controller
@RequestMapping("/autoPilot")
public class AutoPilotSource {

	private AutoPilotModuleRepository autoPilotFlagRepository;
	public void init() {
		// TODO Auto-generated method stub

	}
	@Autowired
    public AutoPilotSource(AutoPilotModuleRepository autoPilotFlagRepository) {
        this.autoPilotFlagRepository = autoPilotFlagRepository;
    }
	
	public AutoPilotSource(){
		
	}
	
	 @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public ResponseEntity<Void> submitAutoPilotFlag(@RequestBody AutoPilotModule module) {	    	
		 	module.setTimeStamp(new Date());
		 	autoPilotFlagRepository.save(module);
	        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
	        return responseEntity;
	    }

	    @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public List<AutoPilotModule> allAutoFlag() {
	        return autoPilotFlagRepository.findAll();
	    }

	    @RequestMapping(method=RequestMethod.GET, value = "/{flag}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public AutoPilotModule getAutoFlag(@PathVariable("flag") String autoPilotFlag) {
	    	AutoPilotModule module = autoPilotFlagRepository.findOne(autoPilotFlag);
	        if (module == null) {
	          //  throw new RouteNotFoundException(routeId);
	        }
	        return module;
	    }
}
