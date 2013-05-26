package com.vetapp.util;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;

import com.vetapp.customer.Customer;
import com.vetapp.pet.Pet;

/**
 * This class demonstrates how to create a connection
 * to a SQLite database using JDBC with the DriverManager.
 */

public class DB
{
    //FIXME: This should be provided via external setup (config file), not hard coded!
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String URL = "jdbc:sqlite:propetdb.db";
    public static final String DB_NAME = "propetdb.db";
    public SimpleDateFormat dbDateFormat = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");


    	public DB() {
    	}

        public Connection DBConnect() {
        	//STEP 1: Setup the Driver
            try
            {
                //Load the JDBC driver class dynamically.
                Driver d = (Driver)Class.forName(DRIVER).newInstance();
                DriverManager.registerDriver(d);
                System.out.println("Driver loaded successfuly!");
            }
            catch(Exception e)
            {
                System.out.println("Error loading database driver: " + e.toString());
                return null;
            }
            
            //STEP 2: Create connection to database using database URL
            Connection con;
            try
            {
            	//FIXME: Load database filename via external config.
            	con = DriverManager.getConnection(URL);
            	System.out.println("Database connection successfull!");
            	if (!DBExists(con,DB_NAME)) {
            		JOptionPane.showMessageDialog(null,
            			    "Database file was not found!",
            			    "Database Fatal Error",
            			    JOptionPane.ERROR_MESSAGE);
        			System.exit(0);
            	}
            }
            catch(SQLException e)
            {
                System.out.println("Error creating connection: " + e.toString());
                return null;
            }
            return con;          
        }
            
    public void DBCreateCustomer(Customer cus) {
    	//open connection
    	Connection con = DBConnect();
    	
    	//SQL statement
    	Statement stmt;
    	ResultSet rs;
        System.out.println("Creating customer:");
        System.out.println(cus.getLastName());
        System.out.println(cus.getFirstName());
        System.out.println(cus.getAddress());
        System.out.println(cus.getHomeNumber());
        System.out.println(cus.getMobileNumber());

        try {
        	String sql = "INSERT INTO Customer (last_name, first_name, address, home_phone, mobile_phone) " +
        				"VALUES  ('" + cus.getLastName() + "', '" + cus.getFirstName() + "', '" + cus.getAddress() + "', '" 
        							+ cus.getHomeNumber() + "', '" + cus.getMobileNumber() + "');";
        	stmt = con.createStatement();
        	stmt.executeUpdate(sql);
        	rs = stmt.getGeneratedKeys();
            System.out.println("Statement Executed!");
            System.out.println("CID:" + rs.getInt("last_insert_rowid()"));
            cus.setCID(rs.getInt("last_insert_rowid()"));
        }
        catch(SQLException e0)
        {
            System.out.println("Error creating statement: " + e0.toString());
        }
        
        //close connection
        try {
            con.close();
            System.out.println("Connection Closed!");
        }
        catch (Exception e1) {
        	System.out.println("Error closing connection: " + e1.toString());
        }
    	
    }
    
    public List<Customer> DBGetCustomers(String lastName) {
    	//open connection
    	Connection con = DBConnect();
    	
    	//SQL statement
    	Statement stmt = null;
        ResultSet res = null;
        try
        {
            String sql = "SELECT * FROM Customer " 
            		+ "WHERE last_name='" + lastName + "';";
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
        }
        catch(SQLException e)
        {
            System.out.println("Error creating or running statement: " + e.toString());
           
        }
        
        //Analyzing result and parsing the records to ArrayList
        List<Customer> resList = new ArrayList<Customer>();    	
        try
        {
        	if (!res.next()) {
        		System.out.println("No records found");
        	} else {
        		do {
        			Customer tempCus = new Customer();
        			tempCus.setFirstName(res.getString("first_name"));
        			tempCus.setLastName(res.getString("last_name"));
        			tempCus.setAddress(res.getString("address"));
        			tempCus.setHomeNumber(res.getString("home_phone"));
        			tempCus.setMobileNumber(res.getString("mobile_phone"));
        			tempCus.setNumberOfVisits(res.getInt("num_of_visits"));
    				String temp = res.getString("next_visit");
    				//System.out.println("received: " + temp);
        			if (temp==null) {
        				//System.out.println("next_visit was not set");
        				tempCus.setNextVisit(null);
        			} else {
        				//System.out.println("Date object retrieved: " + res.getString("next_visit"));
        				//System.out.println("Date object retrieved: " + ft.format(ft.parse(res.getString("next_visit"))).toString());
        				Calendar tempCal = new GregorianCalendar();
        				tempCal.setTime(dbDateFormat.parse(res.getString("next_visit")));
        				tempCus.setNextVisit(tempCal);
        			}
        			resList.add(tempCus);
        		} while (res.next());
        	}
        	System.out.println("Data analysis successfull!");

        }
        catch(Exception e)
        {
        	System.out.println("Error processing results: " + e.toString());
        }

    	//Close connection
        try {
        	stmt.close();
            con.close();			
            System.out.println("Connection closed succesfully!");

        }
        catch (Exception e1) {
        	System.out.println("Error closing connection: " + e1.toString());
        }
        
        //Print results to console
        //printResList(resList);
        return resList;
    }
    
    
    public void DBUpdateCustomer(Customer oldCus, Customer newCus) {
    	
    	//open connection
    	Connection con = DBConnect();
  
        //SQL Statement
        //Update record
        Statement stmt = null;
        try
        {
            String sql1 = "UPDATE Customer " +
            			"SET last_name='" + newCus.getLastName() + "', first_name='" + newCus.getFirstName() + "', address='" + newCus.getAddress() + 
            			"', home_phone='" + newCus.getHomeNumber() + "', mobile_phone='" + newCus.getMobileNumber() + 
            			"', next_visit='" + dbDateFormat.format(newCus.getNextVisit().getTime()) + "', num_of_visits='" + newCus.getNumberOfVisits() + "' " +
            			"WHERE last_name='" + oldCus.getLastName() + "' AND first_name='" + oldCus.getFirstName() +"';";
            stmt = con.createStatement();
            int rows = stmt.executeUpdate(sql1);
    	    System.out.println("Customer record updated! rows: " + rows);
        }
        catch(SQLException e)
        {
            System.out.println("Error creating or running UPDATE statement: " + e.toString());
           
        }
	    
	    //Close statement & connection
        try {
        	stmt.close();
            con.close();
            System.out.println("Connection closed succesfully!");
        }
        catch (Exception e1) {
        	System.out.println("Error closing connection: " + e1.toString());
        }
    }
    
    public void DBDeleteCustomer(Customer cus) {
    	
    	//open connection
    	Connection con = DBConnect();
    	
    	//SQL Statement
        //Delete record
        Statement stmt = null;
        try
        {
            String sql1 = "DELETE FROM Customer " +
            			"WHERE last_name='" + cus.getLastName() + "' AND first_name='" + cus.getFirstName() +"';";
            stmt = con.createStatement();
            stmt.executeUpdate(sql1);
    	    System.out.println("Customer record deleted!");
        }
        catch(SQLException e)
        {
            System.out.println("Error creating or running UPDATE statement: " + e.toString());
        }
	    
	    //Close statement & connection
        try {
        	stmt.close();
            con.close();
            System.out.println("Connection closed succesfully!");
        }
        catch (Exception e1) {
        	System.out.println("Error closing connection: " + e1.toString());
        }
    }
    
    public List<Customer> DBGetAllCustomers() {
    	//open connection
    	Connection con = DBConnect();
    	
    	//SQL statement
    	Statement stmt = null;
        ResultSet res = null;
        try
        {
            String sql = "SELECT * FROM Customer;";
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
        }
        catch(SQLException e)
        {
            System.out.println("Error creating or running statement: " + e.toString());
        }
        //Analyzing result and parsing the records to ArrayList
        List<Customer> fullList = new ArrayList<Customer>();    	
        try
        {
        	if (!res.next()) {
        		System.out.println("No records found");
        	} else {
        		do {
        			Customer tempCus = new Customer();
        			tempCus.setFirstName(res.getString("first_name"));
        			tempCus.setLastName(res.getString("last_name"));
        			tempCus.setAddress(res.getString("address"));
        			tempCus.setHomeNumber(res.getString("home_phone"));
        			tempCus.setMobileNumber(res.getString("mobile_phone"));
        			tempCus.setNumberOfVisits(res.getInt("num_of_visits"));
    				String temp = res.getString("next_visit");
    				//System.out.println("received: " + temp);
        			if (temp==null) {
        				//System.out.println("next_visit was not set");
        				tempCus.setNextVisit(null);
        			} else {
        				//System.out.println("Date object retrieved: " + res.getString("next_visit"));
        				//System.out.println("Date object retrieved: " + ft.format(ft.parse(res.getString("next_visit"))).toString());
        				Calendar tempCal = new GregorianCalendar();
        				tempCal.setTime(dbDateFormat.parse(res.getString("next_visit")));
        				tempCus.setNextVisit(tempCal);
        			}
        			fullList.add(tempCus);
        		} while (res.next());
        	}
        	System.out.println("Data analysis successfull!");

        }
        catch(Exception e)
        {
        	System.out.println("Error processing results: " + e.toString());
        }

    	//Close connection
        try {
        	stmt.close();
            con.close();			
            System.out.println("Connection closed succesfully!");

        }
        catch (Exception e1) {
        	System.out.println("Error closing connection: " + e1.toString());
        }
        
        //Print results to console
        //printResList(resList);
        return fullList;
    }
    
    
/*    private void printResList(List<Customer> list) {
    	for (int i = 0; i < list.size(); i++) {
    		System.out.println(list.get(i).getLastName());
    		System.out.println(list.get(i).getFirstName());
    		System.out.println(list.get(i).getAddress());
    		System.out.println(list.get(i).getHomeNumber());
    		System.out.println(list.get(i).getMobileNumber());
    	}

    }*/
    public boolean DBExists(Connection con,String dbName) {
    	Statement stmt = null;
        ResultSet res = null;    	
        try
    	{
    		String sql = "SELECT name FROM sqlite_master WHERE TYPE='table';";
    		stmt = con.createStatement();
            res = stmt.executeQuery(sql);
    	}
    	catch(SQLException e)
    	{
    		System.out.println("Error creating or running SELECT statement: " + e.toString());
    	}
        try {
        	if (res.next()) {
        		System.out.println("Database checked!");
        		return true;
        	} else {
        		System.out.println("Database doesnt exist!");
        		return false;
        	}
        } catch (SQLException e) {
        	System.out.println("Error processing results: " + e.toString());
        }
        System.out.println("Problem while checking database availability.");
        return false;
    }
    
    //============================== PET DB CONNECTIVITY =============================

    
    public void DBCreatePet(Customer cus, Pet pet) {
    	//open connection
    	Connection con = DBConnect();
    	
    	//SQL statement
    	Statement stmt;
    	ResultSet rs;
        System.out.println("Creating pet:");
        System.out.println(pet.getSpecies());
        System.out.println(pet.getName());
        System.out.println(pet.getGender());
        System.out.println(dbDateFormat.format(pet.getBirthDay().getTime()));
        System.out.println(pet.getFurColour());
        System.out.println(pet.getSpecialChars());
        System.out.println(pet.getChipNumber());
        System.out.print("of Customer: ");
        System.out.println(cus.getFirstName() + " " + cus.getLastName());

        try {
        	String sql = "INSERT INTO Pet (cid, species, pet_name, gender, birthday, fur_colour, special_chars, chip_number) " +
    				"VALUES  ((SELECT cid FROM Customer WHERE last_name = '" + cus.getLastName() + "' AND  first_name='" + cus.getFirstName() + "'), " +
        				"'" + pet.getSpecies() + "', '" + pet.getName() + "', '" + pet.getGender() + "', '" + dbDateFormat.format(pet.getBirthDay().getTime()) + "', '" +
        				pet.getFurColour() + "', '" + pet.getSpecialChars() + "', '" + pet.getChipNumber() + "');";
        	stmt = con.createStatement();
        	stmt.executeUpdate(sql);
        	rs = stmt.getGeneratedKeys();
            System.out.println("Statement Executed!");
            System.out.println("PID:" + rs.getInt("last_insert_rowid()"));
            pet.setPID(rs.getInt("last_insert_rowid()"));
        }
        catch(SQLException e0)
        {
            System.out.println("Error creating statement: " + e0.toString());
        }
        
        //close connection
        try {
            con.close();
            System.out.println("Connection Closed!");
        }
        catch (Exception e1) {
        	System.out.println("Error closing connection: " + e1.toString());
        }
    	
    } 
}
