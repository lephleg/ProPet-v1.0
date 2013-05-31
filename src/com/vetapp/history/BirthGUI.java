package com.vetapp.history;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class BirthGUI extends JFrame {
	private JTable BirthsList;
	private JButton back_button ;
	public BirthGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAutoRequestFocus(false);
		
		JPanel  panel = new JPanel();
		panel.setLayout(new BorderLayout());
		BirthsList = new JTable();
		BirthsList.setModel(new DefaultTableModel(
			new Object[][] {
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{null, null},
				{null, null},                    //Data
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Date", "Complications/Comments"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		BirthsList.getColumnModel().getColumn(0).setPreferredWidth(164);
		BirthsList.getColumnModel().getColumn(1).setPreferredWidth(161);
		BirthsList.setBounds(49, 85, 336, 201);
		JScrollPane scroller = new JScrollPane(BirthsList );   // Xwris JScrollPane den emfanizontai ta headers
		panel.add(scroller,BorderLayout.CENTER );
		JLabel BirthsLbl = new JLabel("                                                                   Births Given");
		BirthsLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(BirthsLbl ,BorderLayout.NORTH);
		back_button = new JButton("Back");   
		back_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BirthGUI.super.dispose();
			}
		});
		//panel.add(back_button, BorderLayout.SOUTH);
		JPanel ButtonsPanel =new JPanel();  // Voithitiko panel 
		ButtonsPanel.add(back_button);
		panel.add(ButtonsPanel , BorderLayout.SOUTH);
	    this.setContentPane(panel );
	    
		this.setVisible(true);
		this.pack();
		
	}

	}

