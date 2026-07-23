package com.FinalProject.MaintenanceTracker.model;

public class Vehicle {
	    private Integer userId;
	    private Integer year;
	    private String make;
	    private String model;
	    private Integer mileage;
	    private String vin;
		
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public Integer getYear() {
			return year;
		}
		public void setYear(Integer year) {
			this.year = year;
		}
		public String getMake() {
			return make;
		}
		public void setMake(String make) {
			this.make = make;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public Integer getMileage() {
			return mileage;
		}
		public void setMileage(Integer mileage) {
			this.mileage = mileage;
		}
		public String getVin() {
			return vin;
		}
		public void setVin(String vin) {
			this.vin = vin;
		}

public Vehicle () {}
public Vehicle(String vin, Integer userId, Integer year,
        String make, String model,
        Integer mileage, String vehName) {

this.userId = userId;
this.year = year;
this.make = make;
this.model = model;
this.mileage = mileage;
this.vin = vehName;
}
}	
