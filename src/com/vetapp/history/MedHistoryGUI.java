package com.vetapp.history;

import javax.swing.*;

//exo pros8esei kai forma gia na kineitai o xristis me tab kai oxi mono me click, gia na mpei xreiazetai import to parakato package kai uncomment to line 130
//import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class MedHistoryGUI extends JFrame {
	public MedHistoryGUI() {
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(200px;default):grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("65px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("46px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("25px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("16px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("88px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("46px"),},
			new RowSpec[] {
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
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
		
		JLabel VaccineLbl = new JLabel("   Vaccinated:");
		VaccineLbl.setVerticalAlignment(SwingConstants.TOP);
		getContentPane().add(VaccineLbl, "1, 1, fill, center");
		
		VaccinesTxtFld = new JTextField();
		VaccineLbl.setLabelFor(VaccinesTxtFld);
		getContentPane().add(VaccinesTxtFld, "1, 3, fill, fill");
		VaccinesTxtFld.setColumns(10);
		VaccinesTxtFld.setText(Grafts);
		
		JLabel AllergiesLbl = new JLabel("   Allergies:");
		AllergiesLbl.setLabelFor(AllergiesLbl);
		getContentPane().add(AllergiesLbl, "1, 5, left, center");
		
		AllergiesTxtFld = new JTextField();
		getContentPane().add(AllergiesTxtFld, "1, 7, fill, fill");
		AllergiesTxtFld.setColumns(10);
		AllergiesTxtFld.setText(Alergies);
		
		JLabel DiseasesLbl = new JLabel("   Diseases:");
		getContentPane().add(DiseasesLbl, "1, 9, left, center");
		
		DiseasesTxtFld = new JTextField();
		DiseasesLbl.setLabelFor(DiseasesTxtFld);
		getContentPane().add(DiseasesTxtFld, "1, 11, fill, fill");
		DiseasesTxtFld.setColumns(10);
		DiseasesTxtFld.setText(As8eneies);
		
		JLabel SurgeriesLbl = new JLabel("   Surgeries:");
		SurgeriesLbl.setLabelFor(SurgeriesLbl);
		getContentPane().add(SurgeriesLbl, "1, 13, left, center");
		
		SurgTxtFld = new JTextField();
		getContentPane().add(SurgTxtFld, "1, 15, fill, fill");
		SurgTxtFld.setColumns(10);
		SurgTxtFld.setText(Surgeries);
		
		
		JLabel MedTrLbl = new JLabel("   Medical Treatment:");
		getContentPane().add(MedTrLbl, "1, 17, left, center");
		
		MedTreatmentTxtFld = new JTextField();
		MedTrLbl.setLabelFor(MedTreatmentTxtFld);
		getContentPane().add(MedTreatmentTxtFld, "1, 19, fill, fill");
		MedTreatmentTxtFld.setColumns(10);
		MedTreatmentTxtFld.setText(MedicalTreatment);
		
		JLabel NeuteringLbl = new JLabel("   Neutering:");
		getContentPane().add(NeuteringLbl, "1, 21");
		
		JRadioButton NeutBtnNo = new JRadioButton("No");
		NeutBtnNo.setSelected(true);
		getContentPane().add(NeutBtnNo, "3, 21, right, top");
		getContentPane().add(NeutBtnYes, "7, 21, left, top");
		
		ButtonGroup BtnGroup = new ButtonGroup();
		BtnGroup.add(NeutBtnNo);
		BtnGroup.add(NeutBtnYes);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		getContentPane().add(btnSaveChanges, "2, 25, 4, 1");
		
		JButton btnNewButton = new JButton("Cancel");
		getContentPane().add(btnNewButton, "7, 25");
		//getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{VaccinesTxtFld, AllergiesTxtFld, DiseasesTxtFld, SurgTxtFld, MedTreatmentTxtFld, NeutBtnNo, NeutBtnYes, btnSaveChanges, btnNewButton, VaccineLbl, MedTrLbl, AllergiesLbl, DiseasesLbl, SurgeriesLbl, NeuteringLbl}));
		
	    
	}
	private String Grafts;
	private String Alergies;
	private String As8eneies;
	private String Surgeries;
	private String MedicalTreatment;
	private BirthGUI births;
	private JTextField VaccinesTxtFld;
	private JTextField AllergiesTxtFld;
	private JTextField DiseasesTxtFld;
	private JTextField SurgTxtFld;
	private final JRadioButton NeutBtnYes = new JRadioButton("Yes");
	private JTextField MedTreatmentTxtFld;
	private boolean Female;
	
	public String getGrafts() {
		return Grafts;
	}
	public void setGrafts(String grafts) {
		Grafts = grafts;
	}
	
	public String getAlergies() {
		return Alergies;
	}
	public void setAlergies(String alergies) {
		Alergies = alergies;
	}
	
	public String getAs8eneies() {
		return As8eneies;
	}
	public void setAs8eneies(String as8eneies) {
		As8eneies = as8eneies;
	}
	
	public String getSurgeries() {
		return Surgeries;
	}
	public void setSurgeries(String surgeries) {
		Surgeries = surgeries;
	}
	
	public String getMedicalTreatment() {
		return MedicalTreatment;
	}
	public void setMedicalTreatment(String medicalTreatment) {
		MedicalTreatment = medicalTreatment;
	}
	
	public void editMeHistory() {
		//to be written
	}
	
	public void CheckGender(){
		//if(metavliti apo pet){
				Female=true;
		//}
	}

	public boolean isFemale() {
		return Female;
	}
	
}
