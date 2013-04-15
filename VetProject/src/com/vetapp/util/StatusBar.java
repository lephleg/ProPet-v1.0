package com.vetapp.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel statusLlb;

	public StatusBar() {
	  
		this.statusLlb = new JLabel();
		super.setBackground(new Color(198, 210, 210));
		super.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		BorderLayout stBarLayout = new BorderLayout();
		super.setLayout(stBarLayout);
		this.statusLlb.setFont(new Font("Arial", 0, 11));
		super.add(this.statusLlb, "West");
		super.setPreferredSize(new Dimension(getWidth(), 25));
		this.statusLlb.setText(" Ready.");
		
	}

	public void setStatusString(String message) {
		this.statusLlb.setText(" " + message);
	}
}
