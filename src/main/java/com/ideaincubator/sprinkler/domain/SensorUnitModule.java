package com.ideaincubator.sprinkler.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SensorUnit")
public class SensorUnitModule {

	 @Id	    
	 private String id;
	 private Date timeStamp;
	 private String analogValue;
	 private String digitalValue;
	 private String sensorType;
	 private String customerId;
	 
	 
	 
	public SensorUnitModule() {
		
	}
	
	public SensorUnitModule(String id, Date timeStamp,
			String analogValue, String digitalValue,String sensorType,String customerId) {		
		this.id = id;
		this.timeStamp = timeStamp;
		this.analogValue = analogValue;
		this.digitalValue = digitalValue;
		this.sensorType = sensorType;
		this.customerId = customerId;
	}
	
	public SensorUnitModule(SensorUnitModule input)
	{
		this.id = input.getId();		
		this.timeStamp = input.getTimeStamp();
		this.analogValue = input.getAnalogValue();
		this.digitalValue = input.getDigitalValue();
		this.sensorType = input.getSensorType();
		this.customerId = input.getCustomerId();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getAnalogValue() {
		return analogValue;
	}
	public void setAnalogValue(String analogValue) {
		this.analogValue = analogValue;
	}
	public String getDigitalValue() {
		return digitalValue;
	}
	public void setDigitalValue(String digitalValue) {
		this.digitalValue = digitalValue;
	}

	public String getSensorType() {
		return sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	 
	 
	
	 
	 
	 
	 
}
