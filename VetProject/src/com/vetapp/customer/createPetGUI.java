package com.vetapp.customer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.Color;

// Odhgia pros synaderfous : Dhmiourghsa to parakatw frame me font times new Roman 14
public class createPetGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;   //Species
	private JTextField textField_1; //Name
	private JTextField txtDd;    // Birth Day
	private JTextField txtMm;   // Birth Month
	private JTextField txtYyyy; // Birth Year
	private JTextField textField_2; // Fur Colour
	private JTextField textField_3;  // Special Characteristics
	private JTextField textField_4;  // Chip Number
	private JButton btnNewButton = new JButton("Create");
	private JButton btnCancel = new JButton("Cancel");


	public createPetGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		textField = new JTextField();
		textField.setBounds(202, 91, 156, 17);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name*:");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblName.setBounds(10, 150, 77, 14);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(202, 149, 156, 15);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
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
		
		txtDd = new JTextField();
		txtDd.setText("DD");
		txtDd.setBounds(202, 288, 25, 20);
		contentPane.add(txtDd);
		txtDd.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setBounds(240, 291, 35, 14);
		contentPane.add(label);
		
		txtMm = new JTextField();
		txtMm.setText("MM");
		txtMm.setBounds(250, 288, 25, 20);
		contentPane.add(txtMm);
		txtMm.setColumns(10);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(285, 291, 46, 14);
		contentPane.add(label_1);
		
		txtYyyy = new JTextField();
		txtYyyy.setText("YYYY");
		txtYyyy.setBounds(301, 287, 46, 20);
		contentPane.add(txtYyyy);
		txtYyyy.setColumns(10);
		
		JLabel lblFurColour = new JLabel("Fur Colour:");
		lblFurColour.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFurColour.setBounds(10, 342, 100, 14);
		contentPane.add(lblFurColour);
		
		textField_2 = new JTextField();
		textField_2.setBounds(202, 341, 156, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSpecialCharacteristics = new JLabel("Special Characteristics:");
		lblSpecialCharacteristics.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSpecialCharacteristics.setBounds(10, 396, 176, 14);
		contentPane.add(lblSpecialCharacteristics);
		
		textField_3 = new JTextField();
		textField_3.setBounds(202, 395, 156, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblChipNumber = new JLabel("Chip Number:");
		lblChipNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblChipNumber.setBounds(10, 458, 114, 19);
		contentPane.add(lblChipNumber);
		
		textField_4 = new JTextField();
		textField_4.setBounds(202, 457, 156, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
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
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}