package com.vetapp.history;

public class MedHistory {
  
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
	}

	public MedHistory() {
		this.allergies="";
		this.diseases="";
		this.grafts="";
		this.medicalTreatment="";
		this.surgeries="";
	}

	//Getters 
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
	
//	//Other Methods
//	public void editMeHistory() {
//		//to be written
//	}

	//============================================================================================
	//----------------------------------- HistoryFemale SUBCLASS ---------------------------------
	//============================================================================================
	
	public class HistoryFemale extends MedHistory {
	  
	  private Birth births;

//	  //Other Methods
//		@Override
//		public void editMeHistory() {
//				//to be written
//		}
//		
		public void addBirth() {
			//to be written
		}

	}
	
	//============================================================================================
	//------------------------------------- Birth CLASS ------------------------------------------
	//============================================================================================

	public class Birth {

		private String date;
		private String complications;
		private int numberOfChildren;
		
		
		//Getters
		
		public String getdate() {
			return date;
		}
		public String getcomplications() {
			return complications;
		}
		public int getNumberOfChildren() {
			return numberOfChildren;
		}
		
		//Setters
		
		public void setdate(String date) {
			this.date = date;
		}
		public void setcomplications(String complications) {
			this.complications = complications;
		}
		public void setNumberOfChildren(int numberOfChildren) {
			this.numberOfChildren = numberOfChildren;
		}
		
	}
	



	
}
