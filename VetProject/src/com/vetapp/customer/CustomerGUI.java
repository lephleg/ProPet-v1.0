package com.vetapp.customer;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import com.vetapp.customer.createPetGUI.cancelButtonListener;
import com.vetapp.main.VetApp;
import com.vetapp.pet.Pet;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CustomerGUI extends JFrame implements ActionListener {
	//Simeiosi: xrisimopoio tin default grammatoseira, i opoia stin ektelesi fainetai ligo megaluteri ap' oti i8ela. 

	private JPanel contentPane;
	private JTable petTable;
	private Customer customer;
	public SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm");

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerGUI frame = new CustomerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public CustomerGUI(Customer cus) {
		customer = new Customer();
		customer = cus;
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED); //to default frame border gia ta panels me perigramma
		setBounds(100, 100, 530, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//-------------------- CUSTOMER INFO PANEL ------------------------

		JPanel customerInfo_panel = new JPanel(); 		
		customerInfo_panel.setBounds(10, 11, 300, 130);
		customerInfo_panel.setBorder(BorderFactory.createTitledBorder(loweredetched, "Customer Info"));
		contentPane.add(customerInfo_panel);
		customerInfo_panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("83px"),
				ColumnSpec.decode("65px"),
				ColumnSpec.decode("60px"),
				ColumnSpec.decode("50dlu"),},
				new RowSpec[] {
				RowSpec.decode("1px"),
				RowSpec.decode("max(1dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("14px"),}));

		//Dedomena tou xristi (8a antikatastountai me ali8ina dedomena kata tin dimiourgia tou frame)
		JLabel firstName = new JLabel(customer.getFirstName());
		customerInfo_panel.add(firstName, "3, 4, 2, 1, left, center");

		JLabel lastName = new JLabel(customer.getLastName());
		customerInfo_panel.add(lastName, "5, 4, 2, 1, left, center");

		JLabel address = new JLabel(customer.getAddress());
		customerInfo_panel.add(address, "3, 6, 2, 1, left, center");

		JLabel homeNumber = new JLabel(customer.getHomeNumber());
		customerInfo_panel.add(homeNumber, "3, 8, 2, 1, left, center");

		JLabel mobileNumber = new JLabel(customer.getMobileNumber());
		customerInfo_panel.add(mobileNumber, "3, 10, 2, 1, left, center");


		//-------------------- VISITS PANEL ------------------------

		JPanel visits_panel = new JPanel();				
		visits_panel.setBounds(10, 152, 300, 100);
		visits_panel.setBorder(BorderFactory.createTitledBorder(loweredetched, "Visits"));
		contentPane.add(visits_panel);
		visits_panel.setLayout(null);

		JLabel visitNumberLabel = new JLabel("Number of visits:");
		visitNumberLabel.setBounds(15, 11, 122, 39);
		visits_panel.add(visitNumberLabel);

		JLabel numberOfVisits = new JLabel(Integer.toString(customer.getNumberOfVisits()));
		numberOfVisits.setBounds(118, 11, 114, 39);
		visits_panel.add(numberOfVisits);

		JFormattedTextField nextVisit = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		nextVisit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nextVisit.setText("_ _ - _ _ - _ _ _ _      _ _ : _ _");	//antikathistatai apo tin klasi nextVisitGUI
		nextVisit.setBounds(78, 55, 198, 26);
		visits_panel.add(nextVisit);

		JLabel nextVisitLabel = new JLabel("Next visit:");
		nextVisitLabel.setBounds(15, 55, 74, 27);
		visits_panel.add(nextVisitLabel);


		JButton createcancelAppointmentButton = new JButton("Create/Cancel Appointment");	//Create/Cancel app. button (8elei auction listener)
		createcancelAppointmentButton.addActionListener(this);
		createcancelAppointmentButton.setBounds(71, 263, 194, 28);
		contentPane.add(createcancelAppointmentButton);

		JButton deleteCustomerButton = new JButton("Delete Customer (!)");			//Delete customer button (8elei auction listener)
		deleteCustomerButton.addActionListener(this);
		deleteCustomerButton.setBounds(10, 304, 160, 28);
		contentPane.add(deleteCustomerButton);

		JButton editCustomerButton = new JButton("Edit Customer");					//Edit customer button (8elei auction listener)
		editCustomerButton.addActionListener(this);
		editCustomerButton.setBounds(180, 304, 130, 28);
		contentPane.add(editCustomerButton);

		//-------------------- PET TABLE --------------------

		String[] columnNames = {"Photo","Name"};
		Object[][] petData = { {"<pic0>", "Rex"}, {"<pic1>", "Epameinwndas"} };	 //Ta dedomena ton pet lamvanontai apo alli klasi kata tin dimiourgia tou frame

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 11, 184, 170);
		contentPane.add(scrollPane);
		petTable = new JTable(petData, columnNames);
		scrollPane.setViewportView(petTable);

		JButton newPetButton = new JButton("New Pet");      //New Pet button (8elei auction listener)
		newPetButton.addActionListener(this);
		newPetButton.setBounds(367, 192, 89, 28);
		contentPane.add(newPetButton);

		JButton backButton = new JButton("Back");			//Back button (8elei auction listener)
		backButton.addActionListener(this);
		backButton.setBounds(367, 304, 89, 28);
		contentPane.add(backButton);

		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("Create/Cancel Appointment")) {
			new NextVisitGUI();
		} else if (e.getActionCommand().equals("Delete Customer (!)")) {
			Object[] options = {"Yes, delete this customer.",
			"No way!"};
			int n = JOptionPane.showOptionDialog(this,
					"Are you sure you want to delete this customer record?\n"
							+ "Warning: this action cannot be undone!",
							"Confirm Customer Deletion",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,     //no custom icon
							options,  //the titles of buttons
							options[0]); //default button title
			if (n == JOptionPane.YES_OPTION) {
				//
				//	Code to delete Customer from Database
				//
				VetApp.db.DBDeleteCustomer(customer);
				this.dispose();
			}
		} else if (e.getActionCommand().equals("Edit Customer")) {
			new editCustomerGUI();
			CustomerGUI.this.dispose();
		} else if (e.getActionCommand().equals("New Pet")) {
			new createPetGUI_Beta(customer);
		} else if (e.getActionCommand().equals("Back")) {
			this.dispose();
		}
	}



	//Odhgia pros synaderfous : Dhmiourghsa to parakatw frame me font times new Roman 14
	public class createPetGUI_Beta extends JFrame implements ActionListener {

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
		private Customer cust ; //  Deikths pelath ston opoio tha anhkei to pet



		public createPetGUI_Beta(Customer aCustomer) {

			cust = new Customer();
			cust = aCustomer;
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


			//Group the radio buttons.
			ButtonGroup group = new ButtonGroup();
			group.add(rdbtnFemale);
			group.add(rdbtnMale);

			//		  if(rdbtnMale.isSelected())
			//			   rdbtnFemale.setSelected(false);       // Kwdikas gia apofygh tautoxronhs epiloghs male + female
			//		 
			//		  if(rdbtnFemale.isSelected())
			//			  rdbtnMale.setSelected(false);

			btnNewButton.addActionListener(this);
			btnCancel.addActionListener(this);

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			// Dhmiourgia Pet
			if (e.getActionCommand().equals("Create")) {
				String species = speciesField.getText();
				String name = nameField.getText();
				String birthDay =  birthDateField.getText();
				String birthMonth = birthMonthField.getText();
				String birthYear =  birthYearField.getText();
				String furColour = furField.getText();
				String special = specialField.getText();
				String chip =  chipField.getText();
				String gender;
				//if(rdbtnMale.isSelected()) {
				gender = "Male";
				//} else {
				//	gender ="Female";
				//}
				String birthDate = birthYear + "-" + birthMonth + "-" + birthDay + " 00:00:00"; //("yyyy-MM-dd hh:mm:ss")
				Date date = null;
				try {
					date = ft.parse(birthDate);
				} catch (ParseException e1) {
					System.out.println("Error parsing pet birth date: " + e1.getMessage());
				}
				Calendar cal = new GregorianCalendar();
				cal.setTime(date);

				Pet pet = new Pet(species,name,gender,cal,furColour,special,chip);
				cust.addPet(pet);

				VetApp.db.DBCreatePet(cust, pet);						// Eisagwgh tou pet sth vasi

				JOptionPane information = new JOptionPane();
				information.showMessageDialog(null,"Pet Added!");   	// Emfanish mhnymatos epityxias
				createPetGUI_Beta.this.dispose();    					// Kleisimo tou frame

			} else if (e.getActionCommand().equals("Cancel")) {
				this.dispose();

			}
		}
	}
	
	public class editCustomerGUI extends JFrame implements ActionListener {

		private JPanel contentPane;
		private JTable petTable;
		private JTextField firstNameTxt;
		private JTextField lastNameTxt;
		private JTextField addressTxt;
		private JTextField homePhoneTxt;
		private JTextField mobilePhoneTxt;

		
		public editCustomerGUI() {
			Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED); //to default frame border gia ta panels me perigramma
			setBounds(100, 100, 530, 410);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			
			//-------------------- CUSTOMER INFO PANEL ------------------------
			
			JPanel customerInfo_panel = new JPanel(); 		
			customerInfo_panel.setBounds(10, 11, 300, 170);
			customerInfo_panel.setBorder(BorderFactory.createTitledBorder(loweredetched, "Customer Info"));
			contentPane.add(customerInfo_panel);
			customerInfo_panel.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(8dlu;default)"),
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(69dlu;default):grow"),
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,}));
			
			//ta textfields pairnoun ta dedomena tou customer kata tin dimiourgia tou para8urou, eno apo8ukeuontai oi allages me to "save changes"
			JLabel firstNameLabel = new JLabel("First Name*:");
			customerInfo_panel.add(firstNameLabel, "2, 2, 3, 1");
			
			firstNameTxt = new JTextField();

			firstNameTxt.setText(customer.getFirstName());
			customerInfo_panel.add(firstNameTxt, "8, 2, 3, 1, fill, default");
			firstNameTxt.setColumns(10);
			
			JLabel lastNameLabel = new JLabel("Last Name*:");
			customerInfo_panel.add(lastNameLabel, "2, 4, 3, 1");
			
			lastNameTxt = new JTextField();
			lastNameTxt.setText(customer.getLastName());
			customerInfo_panel.add(lastNameTxt, "8, 4, 3, 1, fill, default");
			lastNameTxt.setColumns(10);
			
			JLabel addressLabel = new JLabel("Address:");
			customerInfo_panel.add(addressLabel, "2, 6");
			
			addressTxt = new JTextField();
			addressTxt.setText(customer.getAddress());
			customerInfo_panel.add(addressTxt, "8, 6, 3, 1, fill, default");
			addressTxt.setColumns(10);
			
			JLabel homePhoneLabel = new JLabel("Home Phone:");
			customerInfo_panel.add(homePhoneLabel, "2, 8, 3, 1");
			
			homePhoneTxt = new JTextField();
			homePhoneTxt.setText(customer.getHomeNumber());
			customerInfo_panel.add(homePhoneTxt, "8, 8, 3, 1, fill, default");
			homePhoneTxt.setColumns(10);
			
			JLabel mobilePhoneLabel = new JLabel("Mobile Phone:");
			customerInfo_panel.add(mobilePhoneLabel, "2, 10");
			
			mobilePhoneTxt = new JTextField();
			mobilePhoneTxt.setText(customer.getMobileNumber());
			customerInfo_panel.add(mobilePhoneTxt, "8, 10, 3, 1, fill, default");
			mobilePhoneTxt.setColumns(10);
			
			
			//-------------------- VISITS PANEL ------------------------
			
			JPanel visits_panel = new JPanel();				
			visits_panel.setBounds(10, 192, 300, 100);
			visits_panel.setBorder(BorderFactory.createTitledBorder(loweredetched, "Visits"));
			contentPane.add(visits_panel);
			visits_panel.setLayout(null);
			
			JLabel visitNumberLabel = new JLabel("Number of visits:");
			visitNumberLabel.setBounds(15, 11, 122, 39);
			visits_panel.add(visitNumberLabel);
			
			JTextField numberOfVisits = new JTextField(Integer.toString(customer.getNumberOfVisits())); 	//antikatathistatai me metriti
			numberOfVisits.setBounds(118, 11, 114, 39);
			visits_panel.add(numberOfVisits);
			
			JFormattedTextField nextVisit = new JFormattedTextField(ft);
			nextVisit.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			if (customer.getNextVisit()==null) {
				nextVisit.setText("dd-MM-yyyy hh:mm");
			} else {
				nextVisit.setText(ft.format(customer.getNextVisit().getTime()));	//antikathistatai apo tin klasi nextVisitGUI
			}
			nextVisit.setBounds(78, 55, 198, 26);
			visits_panel.add(nextVisit);
			
			JLabel nextVisitLabel = new JLabel("Next visit:");
			nextVisitLabel.setBounds(15, 55, 74, 27);
			visits_panel.add(nextVisitLabel);
			
			
			JButton createcancelAppointmentButton = new JButton("Create/Cancel Appointment");	//Create/Cancel app. button (8elei auction listener)
			createcancelAppointmentButton.setEnabled(false);
			createcancelAppointmentButton.setBounds(70, 300, 194, 28);
			contentPane.add(createcancelAppointmentButton);
			
			JButton saveChangesButton = new JButton("Save Changes");					//Edit customer button (8elei auction listener)
			saveChangesButton.addActionListener(this);
			saveChangesButton.setBounds(180, 333, 130, 28);
			contentPane.add(saveChangesButton);
			
			//-------------------- PET TABLE --------------------
			
			String[] columnNames = {"Photo","Name"};
			Object[][] petData = { {"<pic0>", "Rex"}, {"<pic1>", "Epameinwndas"} };	 //Ta dedomena ton pet lamvanontai apo alli klasi kata tin dimiourgia tou frame
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(320, 11, 184, 170);
			contentPane.add(scrollPane);
			petTable = new JTable(petData, columnNames);
			scrollPane.setViewportView(petTable);
			
			JButton newPetButton = new JButton("New Pet");      //New Pet button (8elei auction listener)
			newPetButton.setEnabled(false);
			newPetButton.setBounds(367, 192, 89, 28);
			contentPane.add(newPetButton);
			
			JButton cancelButton = new JButton("Cancel");			//Back button (8elei auction listener)
			cancelButton.addActionListener(this);
			cancelButton.setBounds(320, 332, 89, 28);
			contentPane.add(cancelButton);
			
			this.setResizable(false);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Save Changes")) {
				
			} else if (e.getActionCommand().equals("Cancel")) {
				new CustomerGUI(customer);
				this.dispose();
			}
		}
	}

}
