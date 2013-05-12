package com.vetapp.pet;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import com.vetapp.customer.CustomerGUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.InputStream;

import javax.swing.JTable;
import javax.swing.JScrollPane;



public class PetGUI extends JFrame {

	private JPanel contentPane;
	public static String MAIN_WINDOW_TITLE =" ProPet v0.5";

	public PetGUI() {
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED); //to default frame border gia ta panels me perigramma
		setBounds(100, 100, 400, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//-------------------- PET INFO PANEL ------------------------
		
		JPanel petInfo_panel = new JPanel(); 		
		petInfo_panel.setBounds(10, 11, 230, 180);
		petInfo_panel.setBorder(BorderFactory.createTitledBorder(loweredetched, "Pet Info"));
		contentPane.add(petInfo_panel);
		petInfo_panel.setLayout(new FormLayout(new ColumnSpec[] {
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
			FormFactory.UNRELATED_GAP_ROWSPEC,
			RowSpec.decode("14px"),
			FormFactory.UNRELATED_GAP_ROWSPEC,
			RowSpec.decode("14px"),
			FormFactory.UNRELATED_GAP_ROWSPEC,
			RowSpec.decode("14px"),}));
	
		//Dedomena tou xristi (8a antikatastountai me ali8ina dedomena kata tin dimiourgia tou frame)
		JLabel species = new JLabel("<species>");
		petInfo_panel.add(species, "3, 4, 2, 1, left, center");
		
		JLabel name = new JLabel("<name>");
		petInfo_panel.add(name, "3, 6, 2, 1, left, center");
		
		JLabel gender = new JLabel("<gender>");
		petInfo_panel.add(gender, "3, 8, 2, 1, left, center");
		
		JLabel birthDay = new JLabel("<birthDay>");
		petInfo_panel.add(birthDay, "3, 10, 2, 1, left, center");
		
		JLabel furColor = new JLabel("<furColor>");
		petInfo_panel.add(furColor, "3, 12, 2, 1, left, center");
		
		JLabel specialChars = new JLabel("<specialChars>");
		petInfo_panel.add(specialChars, "3, 14, 2, 1, left, center");
		
		
		//-------------------- ELECTRIC CHIP PANEL ------------------------
		
		JPanel electicchip_panel = new JPanel();				
		electicchip_panel.setBounds(10, 202, 230, 50);
		electicchip_panel.setBorder(BorderFactory.createTitledBorder(loweredetched, "Electric Chip"));
		contentPane.add(electicchip_panel);
		electicchip_panel.setLayout(null);
		
		JLabel chipNumberLabel = new JLabel("<chipNumber>");
		chipNumberLabel.setBounds(15, 10, 122, 39);
		electicchip_panel.add(chipNumberLabel);
		
		
		JButton deletePetButton = new JButton("Delete Pet (!)");			//Delete customer button (8elei auction listener)
		deletePetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deletePetButton.setBounds(10, 264, 120, 28);
		contentPane.add(deletePetButton);
		
		JButton editPetButton = new JButton("Edit Pet");					//Edit customer button (8elei auction listener)
		editPetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editPetButton.setBounds(147, 264, 90, 28);
		contentPane.add(editPetButton);
		
		//-------------------- IMAGE  --------------------
		
		ImageIcon icon = createImageIcon("Chalkboard.jpg","photo of the pet");
		JLabel imagePetLabel = new JLabel("",icon,JLabel.CENTER);
		imagePetLabel.setBounds(250, 10, 140, 140);
		contentPane.add(imagePetLabel);
		
		JButton medicalHistoryButton = new JButton("Medical Histoty");      //Medical History  button (8elei auction listener)
		medicalHistoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		medicalHistoryButton.setBounds(253, 152, 130, 28);
		contentPane.add(medicalHistoryButton);
		
		JButton backButton = new JButton("Back");			//Back button (8elei auction listener)
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		backButton.setBounds(300, 264, 89, 28);
		contentPane.add(backButton);
		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	protected static ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = CustomerGUI.class.getResource(path);
		if (imgURL != null) {
		return new ImageIcon(imgURL, description);
		} 
		else {
		System.err.println("Couldn't find file: " + path);
		return null;
		}
	}

}

