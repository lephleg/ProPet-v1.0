package com.vetapp.main;

import javax.swing.JFrame;

import com.vetapp.customer.NextVisitGUI;
import com.vetapp.customer.createPetGUI;
import com.vetapp.history.BirthGUI;
import com.vetapp.shop.ShopGUI;

public class VetApp {
	
	private static String MAIN_WINDOW_TITLE =" VetApp v0.2";

	public static void main(String[] args) {
		
		ShopGUI main = new ShopGUI();
		
		main.setResizable(false);
		main.setSize(400, 300);
		main.setVisible(true);
		
	    main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    main.setTitle(MAIN_WINDOW_TITLE);
	    main.setShopStatusBar("This is the ShopGUI. Ready.");
       new createPetGUI();  // For test purposes only delete this line if you want
       new NextVisitGUI();   // For test purposes only delete this line if you want
       new BirthGUI();
	}

}
