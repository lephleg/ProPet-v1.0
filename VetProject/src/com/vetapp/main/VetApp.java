package com.vetapp.main;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.vetapp.customer.Customer;
import com.vetapp.history.MedHistory;
import com.vetapp.pet.Pet;
import com.vetapp.util.DB;


public class VetApp {
		
	public static String MAIN_WINDOW_TITLE =" ProPet v0.8";
	public static DB db = new DB();

	public static void main(String[] args) {

		new ShopGUI();					

		Customer cus0 = new Customer("Giwrgos", "Iwannidis", "Maiandrou 32, Athina", "2102946365", "6986284859", 2, new GregorianCalendar(1991,02,25,21,58,10) );
		Customer cus1 = new Customer("Kwstas", "Papadopoulos", "Fragkoklissias 2, Kozani", "2231029465", "6988584896", 2, new GregorianCalendar(2012,11,25,10,00,10));

		Pet pet0 = new Pet("cat", "Fluffy", "male",  new GregorianCalendar(2011,9,12,00,00,00), "red", "fluffy tail", "CH2325424GR2");
		Pet pet1 = new Pet("dog", "Lucy", "female",  new GregorianCalendar(2012,5,12,00,00,00), "black", "long ears", "CH4326922GR9");
		MedHistory history0 = new MedHistory("allergia","astheneia","emvolia","farmekeutiki agwgi", "xeirourgeia");
		MedHistory history1 = new MedHistory("allergia2","astheneia2","emvolia2","farmekeutiki agwgi2", "xeirourgeia2");
		//		cus0.addPet(pet0);

		List<Pet> list = new ArrayList<Pet>();
		//MedHistory retrieved = db.DBGetMedHistory(cus0, pet1);

		list = db.DBGetAllPets(cus0);
		//		db.DBCreateCustomer(cus1);
		//		db.DBCreatePet(cus0, pet0);
		//		db.DBCreateMedHistory(cus0, pet1, history0);
		//		db.DBUpdateMedHistory(cus0, history1);
		//		db.DBDeletePet(cus0, pet1);
		//		db.DBDeleteMedHistory(cus0, pet1);
		System.out.println(list.size());
		System.out.println(list.get(0).getName());
		System.out.println(list.get(1).getName());
//		System.out.println(retrieved.getGrafts());
//		System.out.println(retrieved.getSurgeries());
//		System.out.println(retrieved.getMedicalTreatment());
//		System.out.println(retrieved.getDiseases());
	}

}
