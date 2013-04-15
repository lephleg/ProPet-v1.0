package com.vetapp.shop;

import java.util.ArrayList;
import java.util.List;

import com.vetapp.customer.Customer;


public class Shop {

	private List<Customer> customersList = new ArrayList<Customer>();
	
	//Getter-Setter
	//get the full customer list as a List object
	public List<Customer> getCustomerList() {
		return customersList;
	}

	//set the full customer list by giving a List object (e.g. backup)
	public void setCustomerList(List<Customer> customers) {
		this.customersList = customers;
	}
	
	//Other Methods
	//get a specific Customer object (by index)
	public Customer getCustomer(int index) {
		return customersList.get(index);
	}

	//remove a specific customer (by object)
	public void removeCustomer(Customer c) {
		customersList.remove(c);
	}
	
	//remove a specific customer (by index)
	public void removeCustomer(int index) {
		customersList.remove(index);
	}
	
	
}
