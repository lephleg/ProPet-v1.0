package com.vetapp.customer;

import java.util.ArrayList;
import java.util.List;

import com.vetapp.pet.Pet;

public class Customer {
	
	private String firstName;
	private String lastName;
	private String address;
	private String homeNumber;
	private String mobileNumber;
	private int numberOfVisits;
	private String nextVisit;
	private List<Pet> myPets = new ArrayList<Pet>();
	

	//Constructors (#2)
	
	public Customer(String firstName, String lastName, String address, String homeNumber, String mobileNumber,
			int numberOfVisits, String nextVisit, ArrayList<Pet> myPets) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homeNumber = homeNumber;
		this.mobileNumber = mobileNumber;
		this.numberOfVisits = numberOfVisits;
		this.nextVisit = nextVisit;
		this.myPets = myPets; 
		
	}
	
	public Customer(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//Getters 
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public int getNumberOfVisits() {
		return numberOfVisits;
	}

	public String getNextVisit() {
		return nextVisit;
	}

	public List<Pet> getMyPets() {
		return myPets;
	}

	//Setters 
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setNumberOfVisits(int numberOfVisits) {
		this.numberOfVisits = numberOfVisits;
	}

	public void setNextVisit(String nextVisit) {
		this.nextVisit = nextVisit;
	}

	public void setMyPets(List<Pet> myPets) {
		this.myPets = myPets;
	}
	
	//Other Methods

	public void addPet(Pet p) {
		myPets.add(p);
	}
	
	public void removePet(Pet p) {
		myPets.remove(p);
	}
	
	public void removePet(int index) {
		myPets.remove(index);
	}
		
	public void editCostumerDetails() {
		//to be written
	}

	private CustomerGUI customerGUI;

	public CustomerGUI getCustomerGUI() {
		return customerGUI;
	}

	public void setCustomerGUI(CustomerGUI customerGUI) {
		this.customerGUI = customerGUI;
	}
}

