package com.vetapp.history;

import java.util.ArrayList;
import java.util.List;

public class FemMedHistory extends MedHistory {

	private List<Birth> births = new ArrayList<Birth>();

	//Constructors (#2)

	public FemMedHistory(String allergies, String diseases, String grafts,String treatments, String surgeries, List<Birth> birthlist) {
		super(allergies,allergies,grafts,treatments,surgeries);
		this.births=birthlist;
	}

	public FemMedHistory() {
		super();
		this.births=null;
	}

	//Getter

	public List<Birth> getBirths() {
		return this.births;

	}

	//Setter

	public void setBirths(List<Birth> list) {
		this.births=list;
	}

}
