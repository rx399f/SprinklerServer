package com.ideaincubator.sprinkler.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "routes")
public class Route {

    @Id
    private String id;

    private String description; 

    private String name;

    private String location;

    private String origin;
    
    private String destination;
    
    private String author;
    
    private String waypoints[][];
    
   // private String [] waypoints;

    public Route() {
    }

    public Route(String name, String location, String description, 
    		String origin, String destination, String author, String waypoints[][]) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.origin = origin;
        this.destination = destination;
        this.author = author;
        this.waypoints = waypoints;
    }

    public Route(Route input) {
        this.name = input.getName();
        this.location = input.getLocation();
        this.description = input.getDescription();
        this.origin = input.getOrigin();
        this.destination = input.getDestination();
        this.author = input.getAuthor();
        this.waypoints = input.getWaypoints();
    }

  

	public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public String getDescription() {
  		return description;
  	}
    public String getOrigin(){
    	return origin;
    }
    public String getDestination(){
    	return destination;
    }
    public String getAuthor() {
  		return author;
  	}
    public String[][] getWaypoints(){
    	return waypoints;
    }

}
