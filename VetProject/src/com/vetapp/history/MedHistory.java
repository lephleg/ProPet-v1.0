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

	//============================================================================================
	//----------------------------------- HistoryFemale SUBCLASS ---------------------------------
	//============================================================================================
	
	public class HistoryFemale extends MedHistory {
	  
	  private Birth births;

	  //Other Methods
		@Override
		public void editMeHistory() {
				//to be written
		}
		
		public void addBirth() {
			//to be written
		}

	}
	
	//============================================================================================
	//------------------------------------- Birth CLASS ------------------------------------------
	//============================================================================================

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
	



	
}
