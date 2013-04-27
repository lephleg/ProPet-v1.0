package com.vetapp.customer;

/*
 * CreateCustomerGUI.java
 * A GUI class that generates a form for the end user
 * to input the details for a new customer entry.
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import com.vetapp.pet.Pet;


public class CreateCustomerGUI extends JFrame {

	//Title and JButton label strings declared as constants
	private static String CREATE_BUTTON_LABEL = "Create";
	private static String CANCEL_BUTTON_LABEL = "Cancel";
	private static String TITLE_LABEL = "Create New Customer";
	
	private JLabel titleLlb;
	private JLabel fNameLbl;
	private JLabel lNameLbl;
	private JLabel addrLbl;
	private JLabel hPhoneLbl;
	private JLabel mPhoneLbl;
	
	private JTextField fNameTxt;
	private JTextField lNameTxt;
	private JTextField addrTxt;
	private JTextField hPhoneTxt;
	private JTextField mPhoneTxt;
	
	private JPanel mainPnl;		//containing inputPnl & controlPnl
	private JPanel inputPnl;	//containing input JLabels & JTextFields		
	private JPanel controlPnl;	//containing control JButtons (createBtn & cancelBtn)
	private JButton createBtn;	
	private JButton cancelBtn;
	
	private BoxLayout paneLayout;		//contentPane layout
	private BoxLayout mainLayout; 		//mainPnl layout
	private BoxLayout controlLayout;	//controlPnl layout
	
	private Border loweredetched;	//border type of inputPnl
	
	private Customer aCustomer;
	private boolean flag = true;

	
	public CreateCustomerGUI() {
		
		//Frame configuration
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle(com.vetapp.main.VetApp.MAIN_WINDOW_TITLE);	//gets window title from constant in com.vetapp.main.VetApp
		
		//contentPane layout (horizontal BoxLayout)
	    mainPnl = new JPanel();
		paneLayout = new BoxLayout(getContentPane(), BoxLayout.X_AXIS);
	    getContentPane().setLayout(paneLayout);
	    
	    getContentPane().add(Box.createRigidArea(new Dimension(15, 0)));
	    getContentPane().add(mainPnl);
	    getContentPane().add(Box.createRigidArea(new Dimension(15, 0)));
	    
	    //mainPnl layout (vertical BoxLayout)
	    titleLlb = new JLabel(TITLE_LABEL);
	    inputPnl = new JPanel();
	    controlPnl = new JPanel();
	    mainLayout = new BoxLayout(mainPnl,BoxLayout.PAGE_AXIS);
	    mainPnl.setLayout(mainLayout);
	    
	    mainPnl.add(Box.createRigidArea(new Dimension(0, 10)));
	    mainPnl.add(titleLlb);
	    mainPnl.add(Box.createRigidArea(new Dimension(0, 10)));
	    mainPnl.add(inputPnl);
	    mainPnl.add(Box.createRigidArea(new Dimension(0, 10)));
	    mainPnl.add(controlPnl);
	    mainPnl.add(Box.createRigidArea(new Dimension(0, 10)));
	    
	    titleLlb.setAlignmentX(Component.CENTER_ALIGNMENT);	//set title JLabel alignment to CENTER

	    //inputPnl layout (GroupLayout [2x5])
	    fNameLbl = new JLabel("First Name*:");
	    lNameLbl = new JLabel("Last Name*:");
	    addrLbl = new JLabel("Address:");
	    hPhoneLbl = new JLabel("Home Phone:");
	    mPhoneLbl = new JLabel("Mobile Phone:");
	    fNameTxt = new JTextField(10);
	    lNameTxt = new JTextField(10);
	    addrTxt = new JTextField(10);
	    hPhoneTxt = new JTextField(10);
	    mPhoneTxt = new JTextField(10);
	    GroupLayout inputLayout = new GroupLayout(inputPnl);
	    inputPnl.setLayout(inputLayout);
	    
	    inputLayout.setAutoCreateGaps(true);			//enable gaps between JLabels & JTextFields
	    inputLayout.setAutoCreateContainerGaps(true);	//enable margin-gaps
	    
	    inputLayout.setHorizontalGroup(
	    		inputLayout.createSequentialGroup()
	    			.addGroup(inputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    				.addComponent(fNameLbl)
	    				.addComponent(lNameLbl)
	    				.addComponent(addrLbl)
	    				.addComponent(hPhoneLbl)
	    				.addComponent(mPhoneLbl))
	    			.addGroup(inputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    				.addComponent(fNameTxt)
	    				.addComponent(lNameTxt)
	    				.addComponent(addrTxt)
	    				.addComponent(hPhoneTxt)
	    				.addComponent(mPhoneTxt))
	    );

	    inputLayout.setVerticalGroup(
	    		inputLayout.createSequentialGroup()
	    			.addGroup(inputLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	    				.addComponent(fNameLbl)
	    				.addComponent(fNameTxt))
	    			.addGroup(inputLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	    				.addComponent(lNameLbl)
	    				.addComponent(lNameTxt))
	    			.addGroup(inputLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	    				.addComponent(addrLbl)
	    				.addComponent(addrTxt))
	    			.addGroup(inputLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	    				.addComponent(hPhoneLbl)
	    				.addComponent(hPhoneTxt))
	    			.addGroup(inputLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	    				.addComponent(mPhoneLbl)
	    				.addComponent(mPhoneTxt))
	    );
	    
	    loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);	
	    inputPnl.setBorder(loweredetched);		//set a visible "Lowered-Etched" border for inputPnl
	     
	    //controlPnl layout (horizontal BoxLayout)
	    createBtn = new JButton(CREATE_BUTTON_LABEL);
	    cancelBtn = new JButton(CANCEL_BUTTON_LABEL);
	    controlLayout = new BoxLayout(controlPnl, BoxLayout.X_AXIS);
	    controlPnl.setLayout(controlLayout);
	    
	    controlPnl.add(Box.createRigidArea(new Dimension(30,0)));
	    controlPnl.add(createBtn);
	    controlPnl.add(Box.createRigidArea(new Dimension(20,0)));
	    controlPnl.add(cancelBtn);
	    controlPnl.add(Box.createRigidArea(new Dimension(30,0)));
	    
	    //Enable visibility for JFrame & all containers
	    pack();
	    setVisible(true);
	    getContentPane().setVisible(true);
	    mainPnl.setVisible(true);
	    inputPnl.setVisible(true);
	    controlPnl.setVisible(true);
	    
	    createBtn.addActionListener(new createButtonListener());
	    cancelBtn.addActionListener(new cancelButtonListener());
	}
	
	public Customer getaCustomer ()
	{
		return aCustomer;         
		
	}
	
	public boolean getFlag()
	{
		return flag;
	}

	public class createButtonListener implements ActionListener {

		@Override    
		public void actionPerformed(ActionEvent arg0) {
			
			aCustomer = new Customer( fNameTxt.getText(),lNameTxt.getText(),addrTxt.getText(),hPhoneTxt.getText(),mPhoneTxt.getText());  //Dhmiourgia pelath
			flag = false;
			JOptionPane information = new JOptionPane();
			information.showMessageDialog(null,"Customer Added !");   // Emfanish mhnymatos epityxias
			CreateCustomerGUI.this.setVisible(false);   // Apenergopoihsh tou frame    
			
		}
		
	}
	
	public class cancelButtonListener implements ActionListener {

		@Override    
		public void actionPerformed(ActionEvent arg0) {
			
			
			fNameTxt.setText(""); 
		    lNameTxt.setText("");  
		    addrTxt.setText("");                       // Epanafora twn textfield
		    hPhoneTxt.setText(""); 
		    mPhoneTxt.setText("");  
		      
			
		}
		
	}
	
}
	