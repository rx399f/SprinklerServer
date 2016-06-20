package com.ideaincubator.sprinkler.domain;

import java.util.Date;

public class WeatherPojo {

	  private String id;
		private String customerId;
		private String city;
		private String chancesOfRain;
		private Date timeStamp;
		
		
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
