package com.vetapp.main;


import com.vetapp.util.DB;


public class VetApp {
		
	public static String MAIN_WINDOW_TITLE =" ProPet v0.8";
	public static DB db = new DB();

	public static void main(String[] args) {

		new ShopGUI();					

		
	}

}
