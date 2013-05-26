package com.vetapp.pet;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.vetapp.history.MedHistory;

public class Pet {

	private int pid = 0;
	private String species;
	private String name;
	private String gender;
	private Calendar birthDay;
	private String furColour;
	private String specialChars;
	private String chipNumber;
	private MedHistory history;
	public SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
	
	//Constructors (#2)
	
	public Pet(String species, String name, String gender, Calendar birthDay, String furColour, String specialChars,
			String chipNumber) {
		
		this.species = species;
		this.name = name;
		this.gender = gender;
		this.birthDay = birthDay;
		this.furColour = furColour;
		this.specialChars = specialChars;
		this.chipNumber = chipNumber;
		//this.history = history;    // Pisteuw pws to medical history den prepei na vrisketai sto constructor
		
	}
	
	public Pet(String species, String name, String gender) {
		
		this.species = species;
		this.name = name;
		this.gender = gender;
		
	}

	//Getters
	
	public int getPID() {
		return pid;
	}
	public String getSpecies() {
		return species;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public Calendar getBirthDay() {
		return birthDay;
	}

	public String getFurColour() {
		return furColour;
	}

	public String getSpecialChars() {
		return specialChars;
	}

	public String getChipNumber() {
		return chipNumber;
	}

	public MedHistory getHistory() {
		return history;
	}

	//Setters
	
	public void setPID(int pid) {
		this.pid = pid;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBirthDay(Calendar birthDay) {
		this.birthDay = birthDay;
	}

	public void setFurColour(String furColour) {
		this.furColour = furColour;
	}

	public void setSpecialChars(String specialChars) {
		this.specialChars = specialChars;
	}

	public void setChipNumber(String chipNumber) {
		this.chipNumber = chipNumber;
	}

	public void setHistory(MedHistory history) {
		this.history = history;
	}

	//Other Methods
	
	public void editPet() { //Edits any properties of class Pet.
		//to be written
	}
	




}
