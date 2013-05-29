package com.vetapp.history;

import java.util.Calendar;

public class Birth {

		private Calendar date;
		private String complications;
		private int numberOfChildren;

		//Constructors (#2)

		public Birth(Calendar cal, String compilations, int numberOfChildren) {

			this.date=cal;
			this.complications=compilations;
			this.numberOfChildren=numberOfChildren;
		}

		public Birth() {

			this.date=null;
			this.complications= "";
			this.numberOfChildren=0;
		}

		//Getters

		public Calendar getDate() {
			return date;
		}
		public String getComplications() {
			return complications;
		}
		public int getNumberOfChildren() {
			return numberOfChildren;
		}
		
		//Setters
		
		public void setDate(Calendar date) {
			this.date = date;
		}
		public void setComplications(String complications) {
			this.complications = complications;
		}
		public void setNumberOfChildren(int numberOfChildren) {
			this.numberOfChildren = numberOfChildren;
		}
		
	}
