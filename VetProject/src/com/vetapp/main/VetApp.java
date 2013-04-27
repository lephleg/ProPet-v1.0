package com.vetapp.main;

import com.vetapp.customer.CreateCustomerGUI;
import com.vetapp.customer.CustomerGUI;
import com.vetapp.customer.CustomersGUI;
import com.vetapp.customer.NextVisitGUI;
import com.vetapp.customer.createPetGUI;
import com.vetapp.customer.editCustomerGUI;
import com.vetapp.history.BirthGUI;
import com.vetapp.shop.ShopGUI;


public class VetApp {
		
	public static String MAIN_WINDOW_TITLE =" ProPet v0.5";

	public static void main(String[] args) {
		
		//Just uncomment the line you want to test
		
		//new ShopGUI();				//Margaritis
		new CustomersGUI();			//Margaritis
		
		//new CreateCustomerGUI();		//Margaritis
		//new CustomerGUI();			//Partalis
		//new editCustomerGUI();		//Partalis
		//new NextVisitGUI();			//Kakalelis
		
		//new createPetGUI();			//Kakalelis
		//new BirthGUI();				//Kakalelis
	}

}
