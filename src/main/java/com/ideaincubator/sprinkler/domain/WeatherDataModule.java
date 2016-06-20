package com.ideaincubator.sprinkler.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "WeatherModule")
public class WeatherDataModule {
	
	@Id
    private String id;
	private String customerId;
	private String city;
	private String chancesOfRain;
	private Date timeStamp;	
	
	
	
	
	public WeatherDataModule() {
		
	}


	public WeatherDataModule(String id, String customerId, String city,
			String chancesOfRain, Date timeStamp) {		
		this.id = id;
		this.customerId = customerId;
		this.city = city;
		this.chancesOfRain = chancesOfRain;
		this.timeStamp = timeStamp;
	}
	
	public WeatherDataModule(WeatherDataModule input) {		
		this.id = input.getId();
		this.customerId = input.getCustomerId();
		this.city = input.getCity();
		this.chancesOfRain = input.getChancesOfRain();
		this.timeStamp = input.getTimeStamp();
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getChancesOfRain() {
		return chancesOfRain;
	}
	public void setChancesOfRain(String chancesOfRain) {
		this.chancesOfRain = chancesOfRain;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
}
