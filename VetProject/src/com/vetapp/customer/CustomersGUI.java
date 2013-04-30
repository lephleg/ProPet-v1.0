package com.vetapp.customer;

/*
 * CustomersGUI.java
 * A GUI class that displays the main customer list.
 * End user can search for, create or display a customer record.
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultRowSorter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.vetapp.shop.ShopGUI;


public class CustomersGUI extends JFrame implements ActionListener {
	
	//JButton labels strings declared as constants
	private static String NEW_BUTTON_LABEL = "New Customer";
	private static String SELECT_BUTTON_LABEL = "Select Customer";
	private static String BACK_BUTTON_LABEL = "Back";
	
	private JTextField searchTxt;
	private JButton newBtn;
	private JButton selectBtn;	//***temporary solution***
	private JButton backBtn;
	private JTable customerTbl;
	
	private JPanel upperPnl;	//containing controPnl
	private JPanel tablePnl;	//containing customerTbl
	private JPanel lowerPnl;	//containing buttonPnl
	private JPanel buttonPnl;	//containing selectBtn & backBtn
	private JPanel controlPnl;	//containing searchTxt & newBtn
	
	private BorderLayout paneLayout;
	private BoxLayout upperLayout; 
	private BoxLayout lowerLayout;
	private BoxLayout buttonLayout;
	private BoxLayout tableLayout;
	private BoxLayout controlLayout;
	
	public CustomersGUI() {
		
		//Frame configuration

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle(com.vetapp.main.VetApp.MAIN_WINDOW_TITLE);	//gets window title from constant in com.vetapp.main.VetApp
		
		upperPnl = new JPanel();	
	    lowerPnl = new JPanel();	
	    tablePnl = new JPanel();	
	    
	    //contentPane layout (BorderLayout)
	    paneLayout = new BorderLayout();
	    getContentPane().setLayout(paneLayout);
	    
	    getContentPane().add(upperPnl, BorderLayout.NORTH);
	    getContentPane().add(tablePnl, BorderLayout.CENTER);
	    getContentPane().add(lowerPnl, BorderLayout.SOUTH);

	    //upperPnl layout (vertical BoxLayout)
	    controlPnl = new JPanel();
	    upperLayout = new BoxLayout(upperPnl, BoxLayout.Y_AXIS);
	    upperPnl.setLayout(upperLayout);
	    
	    upperPnl.add(Box.createRigidArea(new Dimension(0, 10)));
	    upperPnl.add(controlPnl);
	    upperPnl.add(Box.createRigidArea(new Dimension(0, 10)));
    
	    //controlPnl layout (horizontal BoxLayout) 
	    searchTxt = new JTextField("Search...",10);
	    newBtn = new JButton(NEW_BUTTON_LABEL);
	    controlLayout = new BoxLayout(controlPnl, BoxLayout.X_AXIS);
	    controlPnl.setLayout(controlLayout);
	    
	    controlPnl.add(Box.createRigidArea(new Dimension(10, 0)));
	    controlPnl.add(searchTxt);
	    controlPnl.add(Box.createRigidArea(new Dimension(60, 0)));
	    controlPnl.add(newBtn);
	    controlPnl.add(Box.createRigidArea(new Dimension(10, 0)));
	    
	    //JTable configuration

	    String[] columnNames = {"Last Name","First Name","Next Visit"};		//column header labels
	    SimpleDateFormat dateFormat = new SimpleDateFormat(("dd/MM/yyyy"));	//set format of date for Next Visit
	    Date date;															//parse date from formatted String
	    try {
	    	date = dateFormat.parse("01/01/2014");
	    } catch (ParseException e) {
	    	date = null;
	    	e.printStackTrace();
		}
	    
	    Object [][] data = {												//fill with dummy data
	    		{"<lName01>", "<fName01>", (dateFormat.format(date))},
	    		{"<lName02>", "<fName02>", (dateFormat.format(date))},
	    		{"<lName03>", "<fName03>", (dateFormat.format(date))},
	    		{"<lName04>", "<fName04>", (dateFormat.format(date))},
	    };

	    customerTbl = new JTable(data, columnNames);
	    customerTbl.setAutoCreateRowSorter(true);									//enable row sorters						
	    
	    DefaultRowSorter sorter = ((DefaultRowSorter)customerTbl.getRowSorter());	//default sort by Last Name
	    ArrayList list = new ArrayList();
	    list.add( new RowSorter.SortKey(0, SortOrder.ASCENDING) );
	    sorter.setSortKeys(list);
	    sorter.sort();
	    
	    customerTbl.getColumnModel().getColumn(0).setPreferredWidth(100);	//set Last Name column preferred width
	    customerTbl.getColumnModel().getColumn(1).setPreferredWidth(80);	//set First Name column preferred width
	    customerTbl.getColumnModel().getColumn(2).setPreferredWidth(80);	//set Last Visit column preferred width   
	    
	    //tablePnl layout (horizontal BoxLayout)
	    JScrollPane scrollPane = new JScrollPane(customerTbl);
	    customerTbl.setFillsViewportHeight(true);
	    scrollPane.setPreferredSize(new Dimension(270,250));
	    
	    tableLayout = new BoxLayout(tablePnl, BoxLayout.X_AXIS);
	    tablePnl.setLayout(tableLayout);
	    
	    tablePnl.add(Box.createRigidArea(new Dimension(30, 0)));
	    tablePnl.add(scrollPane);
	    tablePnl.add(Box.createRigidArea(new Dimension(30, 0)));

	    //buttonPnl layout (horizontal BoxLayout)					//
	    backBtn = new JButton(BACK_BUTTON_LABEL);					//
	    selectBtn = new JButton(SELECT_BUTTON_LABEL);				//	
	    buttonPnl = new JPanel();									//
	    buttonLayout = new BoxLayout(buttonPnl,BoxLayout.X_AXIS);	//	
	    															//Proswrini lysi mexri na 
	    buttonPnl.add(Box.createRigidArea(new Dimension(50, 0)));	//diorthwthei to thema me to 
	    buttonPnl.add(selectBtn);									//diplo click sto JTable.
	    buttonPnl.add(Box.createRigidArea(new Dimension(15, 0)));	//
	    buttonPnl.add(backBtn);										//
	    buttonPnl.add(Box.createRigidArea(new Dimension(50, 0)));	//
   
	    //lowerPnl layout (vertical BoxLayout)	    
	    lowerLayout = new BoxLayout(lowerPnl,BoxLayout.Y_AXIS);
	    lowerPnl.setLayout(lowerLayout);	    
	    
	    lowerPnl.add(Box.createRigidArea(new Dimension(0, 10)));
	    lowerPnl.add(buttonPnl);
	    lowerPnl.add(Box.createRigidArea(new Dimension(0, 10)));

	    //backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);	//set "Back" JButton alignment to CENTER
	    
	    //ActionListeners
	    newBtn.addActionListener(this);
	    selectBtn.addActionListener(this);
	    backBtn.addActionListener(this);

	    /*
	    //MouseAdapter
	    selectBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				System.out.println("Double click detected!");
				int customerRow = customerTbl.getSelectedRow();
				System.out.println("Customer on " + customerRow + " row selected!");

				// Code to pass the Customer name in this row
				//
				new CustomerGUI();
				dispose();
			}
		}
		});
		*/
	
	    //Pack, Center & Enable visibility for JFrame & all containers
	    pack();
		setLocationRelativeTo(null);
	    setVisible(true);
	    getContentPane().setVisible(true);
	    upperPnl.setVisible(true);
		tablePnl.setVisible(true);
		lowerPnl.setVisible(true);
		buttonPnl.setVisible(true);
		controlPnl.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(BACK_BUTTON_LABEL)) {
			new ShopGUI();
			this.dispose();
		} else if (e.getActionCommand().equals(NEW_BUTTON_LABEL)) {
			new CreateCustomerGUI();
		} else if (e.getActionCommand().equals(SELECT_BUTTON_LABEL)) {
			int row = customerTbl.getSelectedRow();
			new CustomerGUI();
			this.dispose();
		}
	}


	
	
}
