package com.vetapp.history;

public class MedHistory {

	private int mid;
	private String grafts;
	private String allergies;
	private String diseases;
	private String surgeries;
	private String medicalTreatment;

	//Constructors (#2)

	public MedHistory(String allergies, String diseases, String grafts,
			String treatments, String surgeries) {
		this.allergies=allergies;
		this.diseases=diseases;
		this.grafts=grafts;
		this.medicalTreatment=treatments;
		this.surgeries=surgeries;
		this.mid = 0;
	}

	public MedHistory() {
		this.allergies="";
		this.diseases="";
		this.grafts="";
		this.medicalTreatment="";
		this.surgeries="";
		this.mid = 0;
		
	}

	//Getters 
	public int getMID() {
		return this.mid;
	}
	
	public String getGrafts() {
		return grafts;
	}

	public String getAllergies() {
		return allergies;
	}

	public String getDiseases() {
		return diseases;
	}

	public String getSurgeries() {
		return surgeries;
	}

	public String getMedicalTreatment() {
		return medicalTreatment;
	}

	//Setters 

	public void setMID(int mid) {
		this.mid=mid;
	}

	public void setGrafts(String grafts) {
		this.grafts = grafts;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}

	public void setSurgeries(String surgeries) {
		this.surgeries = surgeries;
	}

	public void setMedicalTreatment(String medicalTreatment) {
		this.medicalTreatment = medicalTreatment;
	}

}
