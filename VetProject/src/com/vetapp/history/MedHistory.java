package com.vetapp.history;

public class MedHistory {
  
	private String Grafts;
	private String Allergies;
	private String Diseases;
	private String Surgeries;
	private String MedicalTreatment;
	
	
	
	//Getters 
	public String getGrafts() {
		return Grafts;
	}
	
	public String getAllergies() {
		return Allergies;
	}
	
	
	
	public String getDiseases() {
		return Diseases;
	}
	
	public String getSurgeries() {
		return Surgeries;
	}
	
	public String getMedicalTreatment() {
		return MedicalTreatment;
	}
	
	//Setters 
	
	public void setGrafts(String grafts) {
		Grafts = grafts;
	}
	
	public void setAllergies(String allergies) {
		Allergies = allergies;
	}
	
	public void setDiseases(String diseases) {
		Diseases = diseases;
	}
	
	public void setSurgeries(String surgeries) {
		Surgeries = surgeries;
	}
	
	public void setMedicalTreatment(String medicalTreatment) {
		MedicalTreatment = medicalTreatment;
	}
	
	//Other Methods
	public void editMeHistory() {
		//to be written
	}

}
