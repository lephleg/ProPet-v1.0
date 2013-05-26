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
	private Customer aCustomer ; //  Deikths pelath ston opoio tha anhkei to pet


	public createPetGUI(Customer aCustomer) {
	
		
		setBounds(100, 100, 300, 495);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("menu")); //Background colour
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create New Pet");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(92, 11, 226, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblSpecies = new JLabel("Species*:");
		lblSpecies.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSpecies.setBounds(10, 89, 67, 19);
		contentPane.add(lblSpecies);
		
		speciesField = new JTextField();
		speciesField.setBounds(132, 89, 118, 17);
		contentPane.add(speciesField);
		speciesField.setColumns(10);
		
		JLabel lblName = new JLabel("Name*:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblName.setBounds(10, 150, 77, 14);
		contentPane.add(lblName);
		
		nameField = new JTextField();
		nameField.setBounds(132, 149, 118, 15);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender*:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGender.setBounds(10, 198, 67, 14);
		contentPane.add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnMale.setBounds(130, 194, 67, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnFemale.setBounds(199, 194, 119, 23);
		contentPane.add(rdbtnFemale);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDateOfBirth.setBounds(10, 240, 67, 14);
		contentPane.add(lblDateOfBirth);
		
		birthDateField = new JTextField();
		birthDateField.setText("DD");
		birthDateField.setBounds(118, 237, 25, 20);
		contentPane.add(birthDateField);
		birthDateField.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setBounds(144, 240, 10, 14);
		contentPane.add(label);
		
		birthMonthField = new JTextField();
		birthMonthField.setText("MM");
		birthMonthField.setBounds(153, 237, 25, 20);
		contentPane.add(birthMonthField);
		birthMonthField.setColumns(10);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(188, 240, 46, 14);
		contentPane.add(label_1);
		
		birthYearField = new JTextField();
		birthYearField.setText("YYYY");
		birthYearField.setBounds(204, 237, 46, 20);
		contentPane.add(birthYearField);
		birthYearField.setColumns(10);
		
		JLabel lblFurColour = new JLabel("Fur Colour:");
		lblFurColour.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFurColour.setBounds(10, 284, 100, 14);
		contentPane.add(lblFurColour);
		
		furField = new JTextField();
		furField.setBounds(131, 284, 119, 14);
		contentPane.add(furField);
		furField.setColumns(10);
		
		JLabel lblSpecialCharacteristics = new JLabel("Special Characteristics:");
		lblSpecialCharacteristics.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSpecialCharacteristics.setBounds(10, 330, 176, 14);
		contentPane.add(lblSpecialCharacteristics);
		
		specialField = new JTextField();
		specialField.setBounds(131, 330, 118, 14);
		contentPane.add(specialField);
		specialField.setColumns(10);
		
		JLabel lblChipNumber = new JLabel("Chip Number:");
		lblChipNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChipNumber.setBounds(10, 381, 114, 19);
		contentPane.add(lblChipNumber);
		
		chipField = new JTextField();
		chipField.setBounds(132, 380, 118, 17);
		contentPane.add(chipField);
		chipField.setColumns(10);
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(10, 435, 89, 23);
		contentPane.add(btnNewButton);
		
		
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancel.setBounds(199, 435, 89, 23);
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
			//aCustomer.addPet(new Pet(species,name,gender,birthDate,furColour,special,chip));
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
	

