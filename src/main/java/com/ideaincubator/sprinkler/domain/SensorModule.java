package com.ideaincubator.sprinkler.domain;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SensorModule")
public class SensorModule {

    @Id
    private String id;

    private String description; 

    private String name;

    private String location;
    
  
	private String ipAddress;
	
	private Date updatedTime;
    
    public SensorModule() {
    }

    public SensorModule(String id, String name, String location, String description, String ipAddress,Date updatedTime) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.ipAddress = ipAddress;
        this.updatedTime = updatedTime;
       
    }

    public SensorModule(SensorModule input) {
        this.id = input.getId();
    	this.name = input.getName();
        this.location = input.getLocation();
        this.description = input.getDescription();
        this.ipAddress = input.getIpAddress();
        this.updatedTime = input.getUpdatedTime();
       
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	

	
}
