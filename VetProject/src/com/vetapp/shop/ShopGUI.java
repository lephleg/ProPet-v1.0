package com.vetapp.shop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.vetapp.util.StatusBar;

public class ShopGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2676061954249119209L;
	private static String CUSTOMERS_BUTTON_LABEL = "Customers";
	private static String QUIT_BUTTON_LABEL = "Exit";
	

	private BorderLayout shopLayout;
	private JPanel shopPanel;
	private BoxLayout vbox;
	private JButton customersBtn;
	private JButton quitBtn;
	private StatusBar stBar;
	
	public ShopGUI() {
	    
	    this.shopLayout = new BorderLayout();
	    this.shopPanel = new JPanel();
	    this.stBar = new StatusBar();
	    this.vbox = new  BoxLayout(shopPanel, 3);
	    this.customersBtn = new JButton(CUSTOMERS_BUTTON_LABEL);
	    this.quitBtn = new JButton(QUIT_BUTTON_LABEL);

	    getContentPane().setLayout(shopLayout);
	    getContentPane().add(this.shopPanel, "Center");
	    getContentPane().add(this.stBar, "South");
	    this.shopPanel.setLayout(vbox);
	    
	    this.shopPanel.add(Box.createRigidArea(new Dimension(0, 170)));
	    this.shopPanel.add(customersBtn);
	    this.shopPanel.add(Box.createRigidArea(new Dimension(0, 10)));
	    this.shopPanel.add(quitBtn);
	    
	    this.customersBtn.setAlignmentX(0.5F);
	    this.quitBtn.setAlignmentX(0.5F);
	    
	    this.shopPanel.setVisible(true);
	    
	    this.customersBtn.addActionListener(this);
	    this.quitBtn.addActionListener(this);

	}
	
	//Setter for the StatusBar message
	
	public void setShopStatusBar(String s) {
		this.stBar.setStatusString(s);
	}

	//ActionListener actionPerformed Method
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(CUSTOMERS_BUTTON_LABEL)) {
			this.stBar.setStatusString("Don't be impatient. This isn't ready yet!");
		} else if (e.getActionCommand().equals(QUIT_BUTTON_LABEL)) {
			this.stBar.setStatusString("Bye!");
			System.exit(0);
		}
	}
		
}
	

