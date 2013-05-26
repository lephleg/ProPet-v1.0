package com.vetapp.main;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.vetapp.util.DB;
import com.vetapp.customer.Customer;

import com.vetapp.customer.CreateCustomerGUI;
import com.vetapp.customer.CustomerGUI;
import com.vetapp.customer.CustomersGUI;
import com.vetapp.customer.NextVisitGUI;
import com.vetapp.customer.createPetGUI;
import com.vetapp.pet.Pet;
import com.vetapp.pet.PetGUI;
import com.vetapp.shop.ShopGUI;


public class VetApp {
		
	public static String MAIN_WINDOW_TITLE =" ProPet v0.8";
	public static DB db = new DB();

	public static void main(String[] args) {
		
		//Just uncomment the line you want to test

		new ShopGUI();					//Margaritis
		//new CustomersGUI(db.DBGetAllCustomers());			//Margaritis
	    //new PetGUI();      			//Mavroudis
		//new CreateCustomerGUI();		//Margaritis
		//new CustomerGUI();			//Partalis
		//new editCustomerGUI();		//Partalis
		//new NextVisitGUI();			//Kakalelis
		
		//new createPetGUI(null);		//Kakalelis
		//new BirthGUI();				//Kakalelis

		
//		Customer cus0 = new Customer("Giwrgos", "Iwannidis", "Maiandrou 32, Athina", "2102946365", "6986284859", 2, new GregorianCalendar(1991,02,25,21,58,10) );
//		Pet pet0 = new Pet("cat", "Fluffy", "male",  new GregorianCalendar(2011,9,12,00,00,00), "red", "fluffy tail", "CH2325424GR2");
//		db.DBCreatePet(cus0,pet0);
		
	}
	

	
	
}
