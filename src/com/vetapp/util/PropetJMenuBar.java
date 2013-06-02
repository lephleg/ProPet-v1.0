package com.vetapp.util;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class PropetJMenuBar extends JMenu {

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
		menu.add(menuItm);
		return menuBar;

	}
}