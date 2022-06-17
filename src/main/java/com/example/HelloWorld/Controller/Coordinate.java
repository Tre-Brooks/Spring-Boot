package com.example.HelloWorld.Controller;

public class Coordinate {
	
	private double longitude;
	private double lattitude;
	
	
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLattitude() {
		return lattitude;
	}
	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}
	
	@Override
	public String toString() {
		return "Coordinate{" +
                "longitude= " + longitude + " lattitude= " + lattitude + "}";
	}
	
	
	

}
