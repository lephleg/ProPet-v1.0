package com.vetapp.main;


import java.util.GregorianCalendar;

import com.vetapp.customer.Customer;
import com.vetapp.history.MedHistory;
import com.vetapp.pet.Pet;
import com.vetapp.util.DB;


public class VetApp {
		
	public static String MAIN_WINDOW_TITLE =" ProPet v0.8";
	public static DB db = new DB();

	public static void main(String[] args) {

		new ShopGUI();					

	}
	
}
