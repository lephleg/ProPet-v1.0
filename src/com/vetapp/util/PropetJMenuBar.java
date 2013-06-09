package com.vetapp.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.vetapp.main.VetApp;
import com.vetapp.pet.Pet;

public class PropetJMenuBar extends JMenu implements ActionListener {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenu subMenu;
	private JMenuItem menuItm;
	private JCheckBoxMenuItem cbMenuItem;

	public JMenuBar drawJMenuBar() {

		menuBar = new JMenuBar();

		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menu.getAccessibleContext().setAccessibleDescription("ProPet file menu");
		menuBar.add(menu);

		menuItm = new JMenuItem("Exit",
				KeyEvent.VK_E);
		menuItm.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_E, ActionEvent.ALT_MASK));
		menuItm.getAccessibleContext().setAccessibleDescription(
				"Exit ProPet.");
		menuItm.addActionListener(this);
		menu.add(menuItm);

		menu = new JMenu("Options");
		menu.setMnemonic(KeyEvent.VK_O);
		menu.getAccessibleContext().setAccessibleDescription("ProPet options & preferences menu");
		menuBar.add(menu);

		subMenu = new JMenu("Language");
		subMenu.setMnemonic(KeyEvent.VK_L);

		ButtonGroup group = new ButtonGroup();
		cbMenuItem = new JCheckBoxMenuItem("English");
		cbMenuItem.setMnemonic(KeyEvent.VK_E);
		group.add(cbMenuItem);
		cbMenuItem.setSelected(true);
		subMenu.add(cbMenuItem);

		cbMenuItem = new JCheckBoxMenuItem("Greek");
		cbMenuItem.setMnemonic(KeyEvent.VK_G);
		group.add(cbMenuItem);
		cbMenuItem.setEnabled(false);
		subMenu.add(cbMenuItem);
		menu.add(subMenu);

		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		menu.getAccessibleContext().setAccessibleDescription("ProPet help menu");
		menuBar.add(menu);

		menuItm = new JMenuItem("About ProPet...",
				KeyEvent.VK_A);
		menuItm.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_A, ActionEvent.ALT_MASK));
		menuItm.getAccessibleContext().setAccessibleDescription(
				"ProPet about info.");
		menuItm.addActionListener(this);
		menu.add(menuItm);
		return menuBar;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		} else if (e.getActionCommand().equals("About ProPet...")) {
			new AboutGUI();
		}
	}
	public class AboutGUI extends JFrame {
		
		private JPanel mainPnl;
		private JLabel titleLbl, logoLbl, versionLbl, URLlbl, copyLbl;
		private JButton okBtn;
		private BoxLayout paneLayout;
		private Font titleFont, font, URLfont;
		private ImageIcon logo;	//ImageIcon object for logoLbl image

		public AboutGUI() {
			
			setResizable(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle(VetApp.MAIN_WINDOW_TITLE + " - " + this.getClass().getName());	//gets window title from constant in com.vetapp.main.VetApp

			mainPnl = new JPanel();
			paneLayout = new BoxLayout(mainPnl, BoxLayout.Y_AXIS);
			mainPnl.setLayout(paneLayout);

			getContentPane().add(Box.createRigidArea(new Dimension(15, 0)));
			getContentPane().add(mainPnl);
			getContentPane().add(Box.createRigidArea(new Dimension(15, 0)));

			titleFont = new Font("Arial", Font.BOLD, 20);
			titleLbl = new JLabel(VetApp.MAIN_WINDOW_TITLE);
			titleLbl.setFont(titleFont);
			
			logo = setIcon(com.vetapp.main.VetApp.RACCOON_LOGO_ICON_URL);
			logoLbl = new JLabel(logo);
			
			font = new Font("Arial", Font.PLAIN, 12);
			versionLbl = new JLabel("Veterinary Practice Management Software");
			
			URLfont = new Font("Arial", Font.PLAIN | Font.ITALIC, 10);
			URLlbl = new JLabel("www.facebook.com/RaccoonCoding");
			URLlbl.setForeground(Color.blue);
			URLlbl.setFont(URLfont);
			
			copyLbl = new JLabel("  (c) Copyright Raccoon Coding, 2013. All rights reserved.  ");
			copyLbl.setFont(font);
			
			okBtn = new JButton("          OK          ");
			okBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			okBtn.setFocusable(false);
			mainPnl.add(Box.createRigidArea(new Dimension(0, 5)));
			mainPnl.add(titleLbl);
			mainPnl.add(versionLbl);
			mainPnl.add(logoLbl);
			mainPnl.add(Box.createRigidArea(new Dimension(0, 5)));
			mainPnl.add(URLlbl);
			mainPnl.add(Box.createRigidArea(new Dimension(0, 5)));
			mainPnl.add(copyLbl);
			mainPnl.add(Box.createRigidArea(new Dimension(0, 10)));
			mainPnl.add(okBtn);
			mainPnl.add(Box.createRigidArea(new Dimension(0, 10)));

			titleLbl.setAlignmentX(Component.CENTER_ALIGNMENT);	//set title JLabel alignment to CENTER
			logoLbl.setAlignmentX(Component.CENTER_ALIGNMENT);	//set copyright JLabel alignment to CENTER
			URLlbl.setAlignmentX(Component.CENTER_ALIGNMENT);	//set copyright JLabel alignment to CENTER
			versionLbl.setAlignmentX(Component.CENTER_ALIGNMENT);	//set copyright JLabel alignment to CENTER
			copyLbl.setAlignmentX(Component.CENTER_ALIGNMENT);	//set copyright JLabel alignment to CENTER
			okBtn.setAlignmentX(Component.CENTER_ALIGNMENT);	//set copyright JLabel alignment to CENTER
			
			getContentPane().add(mainPnl);
			setVisible(true);
			pack();
			setLocationRelativeTo(null);
			getContentPane().setVisible(true);
			mainPnl.setVisible(true);
		}
		
		/*
		 * A method to retrieve the logo icon
		 * */
		public ImageIcon setIcon(String link) {
			try {
				URL url = new URL(link);
				return (new ImageIcon(url));
			} catch (MalformedURLException e) {
				return null;
			}
		}
	}
	
}