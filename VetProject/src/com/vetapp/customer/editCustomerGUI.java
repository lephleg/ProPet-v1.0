package com.vetapp.customer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;

public class editCustomerGUI extends JFrame {

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
		firstNameTxt.setText("<firstName>");	
		customerInfo_panel.add(firstNameTxt, "8, 2, 3, 1, fill, default");
		firstNameTxt.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last Name*:");
		customerInfo_panel.add(lastNameLabel, "2, 4, 3, 1");
		
		lastNameTxt = new JTextField();
		lastNameTxt.setText("<lastName>");
		customerInfo_panel.add(lastNameTxt, "8, 4, 3, 1, fill, default");
		lastNameTxt.setColumns(10);
		
		JLabel addressLabel = new JLabel("Address:");
		customerInfo_panel.add(addressLabel, "2, 6");
		
		addressTxt = new JTextField();
		addressTxt.setText("<address>");
		customerInfo_panel.add(addressTxt, "8, 6, 3, 1, fill, default");
		addressTxt.setColumns(10);
		
		JLabel homePhoneLabel = new JLabel("Home Phone:");
		customerInfo_panel.add(homePhoneLabel, "2, 8, 3, 1");
		
		homePhoneTxt = new JTextField();
		homePhoneTxt.setText("<homeNumber>");
		customerInfo_panel.add(homePhoneTxt, "8, 8, 3, 1, fill, default");
		homePhoneTxt.setColumns(10);
		
		JLabel mobilePhoneLabel = new JLabel("Mobile Phone:");
		customerInfo_panel.add(mobilePhoneLabel, "2, 10");
		
		mobilePhoneTxt = new JTextField();
		mobilePhoneTxt.setText("<mobileNumber>");
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
		
		JLabel numberOfVisits = new JLabel("<numberOfVisits>"); 	//antikatathistatai me metriti
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
		createcancelAppointmentButton.setEnabled(false);
		createcancelAppointmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		createcancelAppointmentButton.setBounds(70, 300, 194, 28);
		contentPane.add(createcancelAppointmentButton);
		
		JButton saveChangesButton = new JButton("Save Changes");					//Edit customer button (8elei auction listener)
		saveChangesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		newPetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		newPetButton.setBounds(367, 192, 89, 28);
		contentPane.add(newPetButton);
		
		JButton cancelButton = new JButton("Cancel");			//Back button (8elei auction listener)
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancelButton.setBounds(320, 332, 89, 28);
		contentPane.add(cancelButton);
		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
