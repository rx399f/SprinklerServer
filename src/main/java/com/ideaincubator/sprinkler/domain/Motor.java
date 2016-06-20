package com.ideaincubator.sprinkler.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Motor")
public class Motor {

	@Id
	private String id;
	private String motorFlag;
	private String customerId;
	private Date timeStamp;
	
	
	
	public Motor() {		
	}


	public Motor(String id, String motorFlag, String customerId, Date timeStamp) {		
		this.id = id;
		this.motorFlag = motorFlag;
		this.customerId = customerId;
		this.timeStamp = timeStamp;
	}
	
	public Motor(Motor input) {		
		this.id = input.getId();
		this.motorFlag = input.getMotorFlag();
		this.customerId = input.getCustomerId();
		this.timeStamp = input.getTimeStamp();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMotorFlag() {
		return motorFlag;
	}
	public void setMotorFlag(String motorFlag) {
		this.motorFlag = motorFlag;
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
