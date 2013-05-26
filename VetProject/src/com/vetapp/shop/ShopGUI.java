package com.vetapp.shop;

/*
 * ShopGUI.java
 * The initial GUI class of the application. It generates a frame
 * with the application logo on top and two buttons for the end user below
 * to either navigate to customer list or terminate the application.
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.vetapp.customer.Customer;
import com.vetapp.customer.CustomersGUI;
import com.vetapp.main.VetApp;

public class ShopGUI extends JFrame implements ActionListener {

	//Icon URL/directory link & JButton label strings declared as constants
	private static String LOGO_ICON_URL = "http://i.imgur.com/sn0luPx.jpg"; //(sti teliki ekdosi to URL
																			//tha antikatastathei me topiko directory)
	private static String CUSTOMERS_BUTTON_LABEL = "Customers";
	private static String QUIT_BUTTON_LABEL = "Exit";

	private JPanel shopPnl;	//containing logoLlb, customerBtn & quitBtn
	private BoxLayout paneLayout;	//contentPane layout
	private BoxLayout shopLayout;	//shopPnl layout
	private JLabel logoLbl;
	private JButton customersBtn;
	private JButton quitBtn;
	private ImageIcon logo;	//ImageIcon object for logoLbl image

	public ShopGUI() {

		//Frame configuration
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle(com.vetapp.main.VetApp.MAIN_WINDOW_TITLE);	//gets window title from constant in com.vetapp.main.VetApp

		//getContentPane() layout (horizontal BoxLayout)
		shopPnl = new JPanel();
		paneLayout = new BoxLayout(getContentPane(),BoxLayout.X_AXIS);
		getContentPane().setLayout(paneLayout);

		getContentPane().add(Box.createRigidArea(new Dimension(40, 0)));
		getContentPane().add(shopPnl);
		getContentPane().add(Box.createRigidArea(new Dimension(40, 0)));

		//shopPnl layout (vertical BoxLayout)
		logo = setIcon(LOGO_ICON_URL);
		logoLbl = new JLabel(logo);
		customersBtn = new JButton(CUSTOMERS_BUTTON_LABEL);
		quitBtn = new JButton(QUIT_BUTTON_LABEL);
		shopLayout = new BoxLayout(shopPnl, BoxLayout.Y_AXIS);
		shopPnl.setLayout(shopLayout);

		shopPnl.add(Box.createRigidArea(new Dimension(0, 15)));
		shopPnl.add(logoLbl);
		shopPnl.add(Box.createRigidArea(new Dimension(0, 20)));
		shopPnl.add(customersBtn);
		shopPnl.add(Box.createRigidArea(new Dimension(0, 10)));
		shopPnl.add(quitBtn);
		shopPnl.add(Box.createRigidArea(new Dimension(0, 15)));

		logoLbl.setAlignmentX(CENTER_ALIGNMENT);	//set logo JLabel alignment to CENTER
		customersBtn.setAlignmentX(CENTER_ALIGNMENT);	//set customers JButton alignment to CENTER
		quitBtn.setAlignmentX(CENTER_ALIGNMENT);	//set exit JButton alignment to CENTER


		//ActionListener
		customersBtn.addActionListener(this);
		quitBtn.addActionListener(this);

		//Pack, Center & Enable visibility for JFrame & all containers
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setVisible(true);
		shopPnl.setVisible(true);
	}

	/*
	 * A method to retrieve the logo icon
	 * */
	public ImageIcon setIcon(String link) {
		try {
			URL url = new URL(link);
			return (new ImageIcon(url));
		} catch (MalformedURLException e) {
			return null;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(CUSTOMERS_BUTTON_LABEL)) {
			List<Customer> resList = new ArrayList<Customer>();
			resList = VetApp.db.DBGetAllCustomers();				//Security issue maybe (?)
			new CustomersGUI(resList);
			this.dispose();
		} else if (e.getActionCommand().equals(QUIT_BUTTON_LABEL)) {
			System.exit(0);
		}
	}

}


