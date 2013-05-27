package com.vetapp.main;


import com.vetapp.util.DB;


public class VetApp {
		
	public static String MAIN_WINDOW_TITLE =" ProPet v0.8";
	public static DB db = new DB();

	public static void main(String[] args) {

		new ShopGUI();					

//		Customer cus0 = new Customer("Giwrgos", "Iwannidis", "Maiandrou 32, Athina", "2102946365", "6986284859", 2, new GregorianCalendar(1991,02,25,21,58,10) );
//		Pet pet0 = new Pet("cat", "Fluffy", "male",  new GregorianCalendar(2011,9,12,00,00,00), "red", "fluffy tail", "CH2325424GR2");
//		cus0.addPet(pet0);
//		db.DBCreateCustomer(cus0);
//		db.DBCreatePet(cus0, pet0);
//		System.out.println("loading pet table #1: " + cus0.getMyPets().get(0).getName());
	}
	
}
