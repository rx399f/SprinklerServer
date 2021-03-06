package com.ideaincubator.sprinkler.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SprinklerHealth")
public class SprinklerHealth {

	@Id
	private String id;
	private String customerId;
	private Date timeStamp;
	
	
	
	
	
	
	public SprinklerHealth(String id, String customerId, Date timeStamp) {		
		this.id = id;
		this.customerId = customerId;
		this.timeStamp = timeStamp;
	}
	
	
	
	public SprinklerHealth() {
		
	}
	
	public SprinklerHealth(SprinklerHealth input) {		
		this.id = input.getId();
		this.customerId = input.getCustomerId();
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
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
	
}
