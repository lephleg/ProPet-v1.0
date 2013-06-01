package com.vetapp.main;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.vetapp.customer.Customer;
import com.vetapp.history.Birth;
import com.vetapp.history.FemMedHistory;
import com.vetapp.history.MedHistory;
import com.vetapp.pet.Pet;
import com.vetapp.util.DB;

public class VetApp {
		
	public static String MAIN_WINDOW_TITLE =" ProPet v0.8";
	public static DB db = new DB();

	public static void main(String[] args) {

	new ShopGUI();					

//		Customer cus0 = new Customer("Giwrgos", "Iwannidis", "Maiandrou 32, Athina", "2102946365", "6986284859", 2, new GregorianCalendar(1991,02,25,21,58,10) );
//		Customer cus1 = new Customer("Kwstas", "Papadopoulos", "Fragkoklissias 2, Kozani", "2231029465", "6988584896", 2, new GregorianCalendar(2012,11,25,10,00,10));

//		Pet pet0 = new Pet("cat", "Fluffy", "male",  new GregorianCalendar(2011,9,12,00,00,00), "red", "fluffy tail", "CH2325424GR2");
//		Pet pet1 = new Pet("dog", "Lucy", "female",  new GregorianCalendar(2012,5,12,00,00,00), "black", "long ears", "CH4326922GR9");
//		MedHistory history0 = new MedHistory("allergia","astheneia","emvolia","farmekeutiki agwgi", "xeirourgeia");
//		MedHistory history1 = new MedHistory("allergia2","astheneia2","emvolia2","farmekeutiki agwgi2", "xeirourgeia2");
//		cus0.addPet(pet0);
//		Birth birth1 = new Birth();
//		List<Birth> list = new ArrayList<Birth>();
//		Birth birth2 = new Birth(new GregorianCalendar(1821,4,25,00,00,00),"epanastasi", 8000);
//		list.add(new Birth(new GregorianCalendar(2011,4,10),"kaisariki",4));
//		FemMedHistory female = new FemMedHistory("allergia3","astheneia3","emvolia3","farmekeutiki agwgi3", "xeirourgeia3", list);
	
//		cus0 = db.DBGetCustomer("Papadopoulos","Kwstas");
//		System.out.println(cus0.getCID());
//		history0.setMID(16);

//		list = db.DBGetAllBirths(history0);
//		System.out.println(list.size());
		
//		pet0 = db.DBGetPet(cus1, "Lucy");
//		System.out.println(pet0.getPID());
		
//		db.DBUpdatePet(cus1, pet1, pet0);
		
//		list = db.DBGetAllPets(cus0);
//		cus0 = db.DBCreateCustomer(cus1);
//		System.out.println(cus0.getCID());
//		db.DBDeleteCustomer(cus0);
//		db.DBUpdateCustomer(cus0, cus1);
//		db.DBCreatePet(cus1, pet0);
//		pet1.setPID(48);
//		db.DBCreateMedHistory(pet1, history0);
//		history0.setMID(16);
//		db.DBUpdateMedHistory(history0, history1);
//		db.DBDeletePet(cus1,pet0);
//		birth1 = db.DBGetBirth(history0,  new GregorianCalendar(2011,9,12,00,00,00));
//		System.out.println(birth1.getBID());
//		birth1.setBID(3);
//		db.DBUpdateBirth(birth1, birth2);
	
//		db.DBCreateBirth(history0, birth2);
//		birth1.setBID(2);
//		db.DBDeleteBirth(birth1);
//		db.DBDeleteMedHistory(pet1);
//		System.out.println(list.size());
//		System.out.println(list.get(0).getName());
//		System.out.println(list.get(1).getName());

//		System.out.println(female.getClass().);
//
//		System.out.println(history0.getClass().getSimpleName());

//		if (female instanceof MedHistory) {
//			System.out.println("MedHistory");
//		}
//		if (female instanceof FemMedHistory) {
//			System.out.println("FemMedHistory");
//		}

//		System.out.println(female.getSurgeries());
//		System.out.println(female.getMedicalTreatment());
//		System.out.println(female.getDiseases());
//		System.out.println(female.getMedicalTreatment());
//		List<Birth> births = female.getBirths();
//		System.out.println(births.get(0).getComplications());
		
	}

}
