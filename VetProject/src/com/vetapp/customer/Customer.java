package com.vetapp.customer;

 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.vetapp.pet.Pet;

//import com.vetapp.pet.Pet;

public class Customer {
	
	private int cid = 0;
	private String firstName;
	private String lastName;
	private String address;
	private String homeNumber;
	private String mobileNumber;
	private int numberOfVisits;
	private Calendar nextVisit;
	public SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
	private List<Pet> myPets = new ArrayList<Pet>();
	

	//Constructors (#4)
	public Customer(String firstName, String lastName, String address, String homeNumber, String mobileNumber, int numberOfVisits, Calendar nextVisit )
	{

		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homeNumber = homeNumber;
		this.mobileNumber = mobileNumber;
		this.numberOfVisits = numberOfVisits;
		this.nextVisit = nextVisit;
		//this.setMyPets(new ArrayList<Pet>());

	}
	
	public Customer(String firstName, String lastName, String address, String homeNumber, String mobileNumber)
			 {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homeNumber = homeNumber;
		this.mobileNumber = mobileNumber;
		this.numberOfVisits = 0;
		this.nextVisit = null;
		//this.setMyPets(new ArrayList<Pet>());
		
	}
	
	public Customer(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = "";
		this.homeNumber = "";
		this.mobileNumber = "";
		this.numberOfVisits = 0;	
		this.nextVisit = null;
		//this.setMyPets(new ArrayList<Pet>());

		}
	
	public Customer() {
		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.homeNumber = "";
		this.mobileNumber = "";
		this.numberOfVisits = 0;	
		this.nextVisit = null;
	}
	
	//Getters 
	
	public int getCID() {
		return cid;
	}
	
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

	public Calendar getNextVisit() {
		return nextVisit;
	}

	public List<Pet> getMyPets() {
		return myPets;
	}


	//Setters 

	public void setCID(int cid) {
		this.cid = cid;
	}
	
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

	public void setNextVisit(Calendar nextVisit) {
		this.nextVisit = nextVisit;
	}
	
	public void setMyPets(ArrayList<Pet> myPets) {
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
	
	
	public void print() {
	    System.out.println("Last Name: " + this.lastName);
	    System.out.println("First Name: " + this.firstName);
	    System.out.println("Address: " + this.address);
	    System.out.println("Home Phone: " + this.homeNumber);
	    System.out.println("Mobile Phone: " + this.mobileNumber);
	    System.out.println("Number of Visits: " + this.numberOfVisits);
	    System.out.print("Next Visit (yyyy-mm-dd hh:mm): ");
	    if (this.nextVisit==null) {
	    	System.out.println("NOT SET");
	    } else {
	    	System.out.println(ft.format(this.nextVisit.getTime()));
	    }
	}
	
	//A method that compares the main properties of two Customer records
	//returns true if the two records are identical
	public boolean compareCustomers(Customer cus) {
		boolean flag = true;
		if (this.getLastName()!=cus.getLastName()) {
			flag = false;
    	    System.out.println(this.getLastName() + " - " + cus.getLastName());
    	    System.out.println("Dismatch on Last Name!");
		}
		if (this.getFirstName()!=cus.getFirstName()) {
			flag = false;
    	    System.out.println(this.getFirstName() + " - " + cus.getFirstName());
    	    System.out.println("Dismatch on First Name!");
		}
		if (this.getAddress()!=cus.getAddress()) {
			flag = false;
    	    System.out.println(this.getAddress() + " - " + cus.getAddress());
    	    System.out.println("Dismatch on Address!");
		}
		if (this.getHomeNumber()!=cus.getHomeNumber()) {
			flag = false;
    	    System.out.println(this.getHomeNumber() + " - " + cus.getHomeNumber());
    	    System.out.println("Dismatch on Home Number!");
		}
		if (this.getMobileNumber()!=cus.getMobileNumber()) {
			flag = false;
    	    System.out.println(this.getMobileNumber() + " - " + cus.getMobileNumber());
    	    System.out.println("Dismatch on Mobile Number!");
		}
	    //System.out.println("The two records are identical.");
		return flag;	
	}
}

