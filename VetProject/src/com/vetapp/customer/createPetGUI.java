package com.vetapp.customer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.UIManager;

import com.vetapp.pet.Pet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Odhgia pros synaderfous : Dhmiourghsa to parakatw frame me font times new Roman 14
public class createPetGUI extends JFrame {

	private JPanel contentPane;
	private JTextField speciesField;   //Species
	private JTextField nameField; //Name
    private	JRadioButton rdbtnMale;  // Gender
    private	JRadioButton rdbtnFemale;// Gender
	private JTextField birthDateField;    // Birth Day
	private JTextField birthMonthField;   // Birth Month
	private JTextField birthYearField; // Birth Year
	private JTextField furField; // Fur Colour
	private JTextField specialField;  // Special Characteristics
	private JTextField chipField;  // Chip Number
	private JButton btnNewButton = new JButton("Create");
	private JButton btnCancel = new JButton("Cancel");
	private Customer aCustomer ;


	public createPetGUI(Customer aCustomer) {
	
		
		setBounds(100, 100, 408, 570);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("menu")); //Background colour
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create New Pet");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(132, 11, 226, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblSpecies = new JLabel("Species*:");
		lblSpecies.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSpecies.setBounds(10, 89, 67, 19);
		contentPane.add(lblSpecies);
		
		speciesField = new JTextField();
		speciesField.setBounds(202, 91, 156, 17);
		contentPane.add(speciesField);
		speciesField.setColumns(10);
		
		JLabel lblName = new JLabel("Name*:");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblName.setBounds(10, 150, 77, 14);
		contentPane.add(lblName);
		
		nameField = new JTextField();
		nameField.setBounds(202, 149, 156, 15);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender*:");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGender.setBounds(10, 220, 67, 14);
		contentPane.add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnMale.setBounds(190, 216, 109, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnFemale.setBounds(301, 216, 119, 23);
		contentPane.add(rdbtnFemale);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDateOfBirth.setBounds(10, 289, 114, 14);
		contentPane.add(lblDateOfBirth);
		
		birthDateField = new JTextField();
		birthDateField.setText("DD");
		birthDateField.setBounds(202, 288, 25, 20);
		contentPane.add(birthDateField);
		birthDateField.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setBounds(240, 291, 35, 14);
		contentPane.add(label);
		
		birthMonthField = new JTextField();
		birthMonthField.setText("MM");
		birthMonthField.setBounds(250, 288, 25, 20);
		contentPane.add(birthMonthField);
		birthMonthField.setColumns(10);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(285, 291, 46, 14);
		contentPane.add(label_1);
		
		birthYearField = new JTextField();
		birthYearField.setText("YYYY");
		birthYearField.setBounds(301, 287, 46, 20);
		contentPane.add(birthYearField);
		birthYearField.setColumns(10);
		
		JLabel lblFurColour = new JLabel("Fur Colour:");
		lblFurColour.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFurColour.setBounds(10, 342, 100, 14);
		contentPane.add(lblFurColour);
		
		furField = new JTextField();
		furField.setBounds(202, 341, 156, 20);
		contentPane.add(furField);
		furField.setColumns(10);
		
		JLabel lblSpecialCharacteristics = new JLabel("Special Characteristics:");
		lblSpecialCharacteristics.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSpecialCharacteristics.setBounds(10, 396, 176, 14);
		contentPane.add(lblSpecialCharacteristics);
		
		specialField = new JTextField();
		specialField.setBounds(202, 395, 156, 20);
		contentPane.add(specialField);
		specialField.setColumns(10);
		
		JLabel lblChipNumber = new JLabel("Chip Number:");
		lblChipNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblChipNumber.setBounds(10, 458, 114, 19);
		contentPane.add(lblChipNumber);
		
		chipField = new JTextField();
		chipField.setBounds(202, 457, 156, 20);
		contentPane.add(chipField);
		chipField.setColumns(10);
		
		
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(84, 513, 89, 23);
		contentPane.add(btnNewButton);
		
		
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCancel.setBounds(222, 513, 89, 23);
		contentPane.add(btnCancel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 53, 419, 2);
		contentPane.add(separator);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.aCustomer = aCustomer;
		  if(rdbtnMale.isSelected())
			   rdbtnFemale.setSelected(false);       // Kwdikas gia apofygh tautoxronhs epiloghs male + female
		 
		  if(rdbtnFemale.isSelected())
			  rdbtnMale.setSelected(false);
		
		btnCancel.addActionListener(new cancelButtonListener());
		btnCancel.addActionListener(new cancelButtonListener());
		
	}
	
	public class createButtonListener implements ActionListener {

		@Override    // Dhmiourgia Pet
		public void actionPerformed(ActionEvent arg0) {
			String species = speciesField.getText();
			String name = nameField.getText();
			String birthDay =  birthDateField.getText();
			String birthMonth = birthMonthField.getText();
			String birthYear =  birthYearField.getText();
			String furColour = furField.getText();
			String special = specialField.getText();
			String chip =  chipField.getText();
			String gender;
			  if(rdbtnMale.isSelected())
				  gender = "Male";
			  else
				gender ="Female";
			String birthDate =  birthDay+"/"+birthMonth+"/"+birthYear;
			aCustomer.addPet(new Pet(species,name,gender,birthDate,furColour,special,chip));
			JOptionPane information = new JOptionPane();
			information.showMessageDialog(null,"Pet Added !");   // Emfanish mhnymatos epityxias
			createPetGUI.this.dispose();    // Kleisimo tou frame
			
		   
		      
			
		}
		
	}
	
	public class cancelButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			speciesField.setText("");   
	        nameField.setText("");
		    rdbtnMale.setText("");  // Gender
		    rdbtnFemale.setText("");// Gender
			birthDateField.setText("");    // Birth Day
		    birthMonthField.setText("");   // Birth Month
		    birthYearField.setText(""); // Birth Year
		    furField.setText(""); // Fur Colour
		    specialField.setText("");  // Special Characteristics
		    chipField.setText("");  // Chip Number
			
		}
	}
	}
	

