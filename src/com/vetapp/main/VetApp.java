package com.vetapp.main;

import com.vetapp.history.MedHistory;
import com.vetapp.util.DB;

public class VetApp {
		
	public static String MAIN_WINDOW_TITLE =" ProPet v1.00";
	
	public static String LOGO_IMAGE_PATH = "../../../images/ProPetlogo_130px_v100.png";
	public static String RACCOON_LOGO_ICON_PATH = "../../../images/comp_logo.png"; 

	public static String IMAGES_PATH = "../../../images/";
	public static String DEFAULT_PET_IMAGE_PATH = "../../../images/default_125x125.png";

	public static DB db = new DB();
	MedHistory history0 = new MedHistory();

	public static void main(String[] args) {

	new ShopGUI();			

	}
	
}
