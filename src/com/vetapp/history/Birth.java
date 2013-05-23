package com.vetapp.history;

public class Birth {

	private String Date;
	private String Complications;
	private int NumberOfChildren;
	
	
	//Getters
	
	public String getDate() {
		return Date;
	}
	public String getComplications() {
		return Complications;
	}
	public int getNumberOfChildren() {
		return NumberOfChildren;
	}
	
	//Setters
	
	public void setDate(String date) {
		Date = date;
	}
	public void setComplications(String complications) {
		Complications = complications;
	}
	public void setNumberOfChildren(int numberOfChildren) {
		NumberOfChildren = numberOfChildren;
	}
	
}