package com.ideaincubator.sprinkler.domain;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AutoPilotModule")
public class AutoPilotModule {

	@Id
	private String id;
	
	private String autoPilotFlag;
	private String customerId;
	private Date   timeStamp;	
	
	public AutoPilotModule() {
	    }

	public AutoPilotModule(String id, String autoPilotFlag,String customerId,Date   timeStamp) {
        this.id = id;
        this.autoPilotFlag = autoPilotFlag; 
        this.customerId = customerId; 
        this.timeStamp = timeStamp; 
    }
	
	  public AutoPilotModule(AutoPilotModule input) {
	        this.id = input.getId();	    	
	        this.autoPilotFlag = input.getAutoPilotFlag();
	        this.customerId = input.getCustomerId();
	        this.timeStamp = input.getTimeStamp();
	    }
	  
	  

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAutoPilotFlag() {
		return autoPilotFlag;
	}

	public void setAutoPilotFlag(String autoPilotFlag) {
		this.autoPilotFlag = autoPilotFlag;
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
