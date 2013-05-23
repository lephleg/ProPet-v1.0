package com.vetapp.customer;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.text.SimpleDateFormat;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CustomerGUI extends JFrame {
	//Simeiosi: xrisimopoio tin default grammatoseira, i opoia stin ektelesi fainetai ligo megaluteri ap' oti i8ela. 

	private JPanel contentPane;
	private JTable petTable;
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

	public CustomerGUI() {
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
		JLabel firstName = new JLabel("<firstName>");
		customerInfo_panel.add(firstName, "3, 4, 2, 1, left, center");
		
		JLabel lastName = new JLabel("<lastName>");
		customerInfo_panel.add(lastName, "5, 4, 2, 1, left, center");
		
		JLabel address = new JLabel("<address>");
		customerInfo_panel.add(address, "3, 6, 2, 1, left, center");
		
		JLabel homeNumber = new JLabel("<homeNumber>");
		customerInfo_panel.add(homeNumber, "3, 8, 2, 1, left, center");
		
		JLabel mobileNumber = new JLabel("<mobileNumber>");
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
		createcancelAppointmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		createcancelAppointmentButton.setBounds(71, 263, 194, 28);
		contentPane.add(createcancelAppointmentButton);
		
		JButton deleteCustomerButton = new JButton("Delete Customer (!)");			//Delete customer button (8elei auction listener)
		deleteCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteCustomerButton.setBounds(10, 304, 160, 28);
		contentPane.add(deleteCustomerButton);
		
		JButton editCustomerButton = new JButton("Edit Customer");					//Edit customer button (8elei auction listener)
		editCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		newPetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		newPetButton.setBounds(367, 192, 89, 28);
		contentPane.add(newPetButton);
		
		JButton backButton = new JButton("Back");			//Back button (8elei auction listener)
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		backButton.setBounds(367, 304, 89, 28);
		contentPane.add(backButton);
		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}
	
}
