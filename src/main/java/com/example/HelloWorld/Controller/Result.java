package com.example.HelloWorld.Controller;


public class Result {
	
	private String city;
	private Coordinate coordinates;
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Coordinate getCoordinate() {
		return coordinates;
	}
	public void setCoordinate(Coordinate coordinate) {
		this.coordinates = coordinate;
	}
	
	@Override
	public String toString() {
		return "Result{" +
                "city= " + city + " coodintates= " + coordinates + "}";
	}

}
