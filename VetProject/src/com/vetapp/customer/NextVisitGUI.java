package com.vetapp.customer;

import java.awt.BorderLayout;    
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
 // Xrhsimopoihsa Grammatoseira Tahoma 11 Paraklw na apofasisoume apo edw kai sto ekshs ti tha xrhsimopoipume!

public class NextVisitGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtDd;  // Day textfield
	private JTextField txtMm;   // Month Textfield
	private JTextField txtYyyy; // Year Textfield
	private JTextField txtHh;   // Hours Textfield
	private JTextField txtHh_1; // Year Textfield
    private  JButton btnSet = new JButton("Set");
    private  JButton btnCancel = new JButton("Cancel");


	/**
	 * Create the frame.
	 */
	public NextVisitGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 404, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreatrNewAppointment = new JLabel("Create New Appointment");
		lblCreatrNewAppointment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreatrNewAppointment.setBounds(115, 0, 170, 20);
		contentPane.add(lblCreatrNewAppointment);
		
		JLabel lblNextVisit = new JLabel("Next Visit:");
		lblNextVisit.setBounds(21, 69, 58, 14);
		contentPane.add(lblNextVisit);
		
		txtDd = new JTextField();
		txtDd.setText("DD");
		txtDd.setBounds(78, 66, 27, 20);
		contentPane.add(txtDd);
		txtDd.setColumns(10);
		
		txtMm = new JTextField();
		txtMm.setText("MM");
		txtMm.setBounds(115, 66, 27, 20);
		contentPane.add(txtMm);
		txtMm.setColumns(10);
		
		txtYyyy = new JTextField();
		txtYyyy.setText("YYYY");
		txtYyyy.setBounds(155, 66, 32, 20);
		contentPane.add(txtYyyy);
		txtYyyy.setColumns(10);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(262, 70, 46, 14);
		contentPane.add(lblTime);
		
		txtHh = new JTextField();
		txtHh.setText("HH");
		txtHh.setBounds(294, 66, 27, 20);
		contentPane.add(txtHh);
		txtHh.setColumns(10);
		
		txtHh_1 = new JTextField();
		txtHh_1.setText("MM");
		txtHh_1.setBounds(327, 66, 27, 20);
		contentPane.add(txtHh_1);
		txtHh_1.setColumns(10);
		
		btnSet.setBounds(98, 107, 89, 23);
		contentPane.add(btnSet);
		
		btnCancel.setBounds(208, 107, 89, 23);
		contentPane.add(btnCancel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 57, 398, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 94, 398, 2);
		contentPane.add(separator_1);
		setLocationRelativeTo(null);
		this.setVisible(true);
		
		btnSet.addActionListener(this);
		btnCancel.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Set")) {
			
		} else if (e.getActionCommand().equals("Cancel")) {
			dispose();
		}


	}
}
