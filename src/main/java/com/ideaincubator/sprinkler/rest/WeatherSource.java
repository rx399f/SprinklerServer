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

import com.ideaincubator.sprinkler.domain.WeatherDataModule;
import com.ideaincubator.sprinkler.domain.WeatherPojo;
import com.ideaincubator.sprinkler.repository.WeatherModuleRepository;


@Controller
@RequestMapping("/weather")
public class WeatherSource {

	private WeatherModuleRepository weatherModuleRepository;
	public WeatherSource(){
		
	}
	@Autowired
    public WeatherSource(WeatherModuleRepository weatherModuleRepository) {
        this.weatherModuleRepository = weatherModuleRepository;
    }
	public void init() {
		// TODO Auto-generated method stub

	}
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> submitWeatherData(@RequestBody WeatherDataModule module) {
    	module.setTimeStamp(new Date());
    	weatherModuleRepository.save(module);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
        return responseEntity;
    }
	 @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public List<WeatherDataModule> allWeatherData() {
	        return weatherModuleRepository.findAll();
	    }
	  @RequestMapping(method=RequestMethod.GET, value = "/{weatherId}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public WeatherPojo getWeatherData(@PathVariable("weatherId") String weatherId) {
		  WeatherDataModule module = weatherModuleRepository.findOne(weatherId);
		 /* WeatherDataModule module = new WeatherDataModule();
		  module.setId("1");
		  module.setChancesOfRain("50");
		  module.setCity("Noida");
		  module.setCustomerId("3004");*/
		  
		  String module1 = "{'id':'10','customerId':'125','city':'Nagpur','chancesOfRain':'29'}";
		  WeatherPojo weatherPojo = new WeatherPojo();
		  weatherPojo.setId("1");
		  weatherPojo.setChancesOfRain("50");
		  weatherPojo.setCity("Noida");
		  weatherPojo.setCustomerId("3004");
		 
		  if (module == null) {
	          //  throw new RouteNotFoundException(routeId);
	        }
	        return weatherPojo;
	    }
}
