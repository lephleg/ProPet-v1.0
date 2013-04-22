package com.vetapp.main;

import com.vetapp.customer.CreateCustomerGUI;
import com.vetapp.customer.CustomerGUI;
import com.vetapp.customer.NextVisitGUI;
import com.vetapp.customer.createPetGUI;
import com.vetapp.customer.editCustomerGUI;
import com.vetapp.history.BirthGUI;
import com.vetapp.shop.ShopGUI;


public class VetApp {
		
	public static String MAIN_WINDOW_TITLE =" ProPet v0.5";

	public static void main(String[] args) {
		
		//Just comment the line you want to bypass for testing
		new ShopGUI();
		new CreateCustomerGUI();
		new createPetGUI();  
		new NextVisitGUI();   
		new BirthGUI();
		new CustomerGUI();
		new editCustomerGUI();
       
	}

}
