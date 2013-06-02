package com.vetapp.util;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;

import com.vetapp.customer.Customer;
import com.vetapp.history.Birth;
import com.vetapp.history.FemMedHistory;
import com.vetapp.history.MedHistory;
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
	public SimpleDateFormat dbPetDateFormat = new SimpleDateFormat ("yyyy-MM-dd");

	public DB() {
	}

	//============================== GENERAL DB CONNECTIVITY =============================

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

	//=============================== CUSTOMER DB CONNECTIVITY =============================

	public Customer DBCreateCustomer(Customer cus) {
		Customer temp = new Customer();
		temp = cus;

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
			temp.setCID(rs.getInt("last_insert_rowid()"));
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
		return temp;
	}

	public Customer DBGetCustomer(String lastName, String firstName) { 		

		//open connection
		Connection con = DBConnect();

		//SQL statement
		Statement stmt = null;
		ResultSet res = null;
		try
		{
			String sql = "SELECT * FROM Customer " 
					+ "WHERE last_name='" + lastName + "' AND first_name='" + firstName + "';";
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running SELECT CUSTOMER statement: " + e.toString());

		}

		//Analyzing result and parsing the records to ArrayList
		Customer cus = new Customer();;
		try
		{
			if (!res.next()) {
				System.out.println("No records found");
			} else {
				cus.setCID(res.getInt("cid"));
				cus.setFirstName(res.getString("first_name"));
				cus.setLastName(res.getString("last_name"));
				cus.setAddress(res.getString("address"));
				cus.setHomeNumber(res.getString("home_phone"));
				cus.setMobileNumber(res.getString("mobile_phone"));
				cus.setNumberOfVisits(res.getInt("num_of_visits"));
				String temp = res.getString("next_visit");
				//System.out.println("received: " + temp);
				if (temp==null) {
					//System.out.println("next_visit was not set");
					cus.setNextVisit(null);
				} else {
					//System.out.println("Date object retrieved: " + res.getString("next_visit"));
					//System.out.println("Date object retrieved: " + ft.format(ft.parse(res.getString("next_visit"))).toString());
					Calendar tempCal = new GregorianCalendar();
					tempCal.setTime(dbDateFormat.parse(res.getString("next_visit")));
					cus.setNextVisit(tempCal);
				}
				System.out.println("Data analysis successfull!");
			}
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
		return cus;
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


		//		//SQL Statement
		//		//Delete Pets related to this customer
		Statement stmt0 = null;
		try
		{ String sql2 = "DELETE FROM Pet " +
				"WHERE cid=(SELECT cid FROM Customer WHERE last_name='" + cus.getLastName() + "' AND first_name='" + cus.getFirstName() +"');";
		stmt0 = con.createStatement();
		stmt0.executeUpdate(sql2);
		System.out.println("Pet records deleted!");
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running PET DELETE statement: " + e.toString());
		}

		//SQL Statement
		//Delete Customer Record
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
			System.out.println("Error creating or running CUSTOMER DELETE statement: " + e.toString());
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

		List<Customer> fullList = new ArrayList<Customer>();    	

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
					//					//SQL statement for getting Customers Pets by matching cid
					//					Statement stmt0 = null;
					//					ResultSet res0 = null;
					//					try
					//					{
					//						String sql0 = "SELECT * FROM Pet " +
					//								"WHERE cid='" + res.getInt("cid") + "';";
					//						stmt0 = con.createStatement();
					//						res0 = stmt0.executeQuery(sql0);
					//					}
					//					catch(SQLException e)
					//					{
					//						System.out.println("Error creating or running PET LIST statement: " + e.toString());
					//					}
					//
					//					//Analyzing result and parsing the records to ArrayList
					//					List<Pet> petList = new ArrayList<Pet>();  
					//					petList.clear();  	
					//					try
					//					{
					//						if (!res0.next()) {
					//							System.out.println("No pets found");
					//						} else {
					//							do {
					//								Pet tempPet = new Pet();
					//								tempPet.setSpecies(res0.getString("species"));
					//								tempPet.setName(res0.getString("pet_name"));
					//								tempPet.setGender(res0.getString("gender"));
					//								String tmp = res0.getString("birthday");
					//								if (tmp==null) {
					//									//System.out.println("next_visit was not set");
					//									tempPet.setBirthDay(null);
					//								} else {
					//									//System.out.println("Date object retrieved: " + res.getString("next_visit"));
					//									//System.out.println("Date object retrieved: " + ft.format(ft.parse(res.getString("next_visit"))).toString());
					//									Calendar tmpCal = new GregorianCalendar();
					//									tmpCal.setTime(dbPetDateFormat.parse(tmp));
					//									tempPet.setBirthDay(tmpCal);
					//								}
					//								tempPet.setFurColour(res0.getString("fur_colour"));
					//								tempPet.setSpecialChars(res0.getString("special_chars"));
					//								tempPet.setChipNumber(res0.getString("chip_number"));
					//								tempPet.setPhotoPath(res0.getString("photo_path"));
					//								tempCus.addPet(tempPet);
					//							} while (res0.next());
					//						}
					//					}
					//					catch(SQLException e)
					//					{
					//						System.out.println("Error analyzing PET LIST statement: " + e.toString());
					//					}
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
		return fullList;
	}

	//============================== PET DB CONNECTIVITY =============================

	public Pet DBCreatePet(Customer cus, Pet pet) {
		Pet temp = new Pet();
		temp = pet;
		//open connection
		Connection con = DBConnect();

		//SQL statement
		Statement stmt;
		ResultSet rs;

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
			temp.setPID(rs.getInt("last_insert_rowid()"));
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
		return temp;	
	} 

	public List<Pet> DBGetAllPets(Customer cus) {
		List<Pet> petList = new ArrayList<Pet>();   

		//open connection
		Connection con = DBConnect();

		//SQL statement for getting Customers Pets by matching cid
		Statement stmt0 = null;
		ResultSet res = null;
		try
		{
			String sql0 = "SELECT * FROM Pet " +
					"WHERE cid=(SELECT cid FROM Customer WHERE last_name = '" + cus.getLastName() + "' AND  first_name='" + cus.getFirstName() + "');";
			stmt0 = con.createStatement();
			res = stmt0.executeQuery(sql0);
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running PET LIST statement: " + e.toString());
		}

		//Analyzing result and parsing the records to ArrayList
		try
		{
			if (!res.next()) {
				System.out.println("No pets found");
			} else {
				do {
					Pet tempPet = new Pet();
					tempPet.setPID(res.getInt("pid"));
					tempPet.setSpecies(res.getString("species"));
					tempPet.setName(res.getString("pet_name"));
					tempPet.setGender(res.getString("gender"));
					String tmp = res.getString("birthday");
					if (tmp==null) {
						//System.out.println("next_visit was not set");
						tempPet.setBirthDay(null);
					} else {
						//System.out.println("Date object retrieved: " + res.getString("next_visit"));
						//System.out.println("Date object retrieved: " + ft.format(ft.parse(res.getString("next_visit"))).toString());
						Calendar tmpCal = new GregorianCalendar();
						tmpCal.setTime(dbPetDateFormat.parse(tmp));
						tempPet.setBirthDay(tmpCal);
					}
					tempPet.setFurColour(res.getString("fur_colour"));
					tempPet.setSpecialChars(res.getString("special_chars"));
					tempPet.setChipNumber(res.getString("chip_number"));
					tempPet.setPhotoPath(res.getString("photo_path"));
					petList.add(tempPet);
				} while (res.next());
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error analyzing PET LIST statement: " + e.toString());
		} catch (ParseException e1) {
			System.out.println("Error parsing DATE: " + e1.toString());
		}
		//close connection
		try {
			con.close();
			System.out.println("Connection Closed!");
		}
		catch (Exception e1) {
			System.out.println("Error closing connection: " + e1.toString());
		}
		return petList;
	}

	public void DBUpdatePet(Customer cus, Pet oldPet, Pet newPet) {

		//open connection
		Connection con = DBConnect();

		//SQL Statement
		//Update record
		Statement stmt = null;
		try
		{
			String sql1 = "UPDATE Pet " +
					"SET species='" + newPet.getSpecies() + "', pet_name='" + newPet.getName() + "', gender='" + newPet.getGender() + "', birthday='" + dbPetDateFormat.format(newPet.getBirthDay().getTime()) +
					"', fur_colour='" + newPet.getFurColour() + "', special_chars='" + newPet.getSpecialChars() + "', chip_number='" + newPet.getChipNumber() + "', photo_path='" + newPet.getPhotoPath() + "' " +
					"WHERE cid=(SELECT cid FROM Customer WHERE last_name='" + cus.getLastName() + "' AND first_name='" + cus.getFirstName() + "') AND pet_name='" + oldPet.getName() + "';";
			stmt = con.createStatement();
			int rows = stmt.executeUpdate(sql1);
			System.out.println("Pet record updated! rows: " + rows);
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running PET UPDATE statement: " + e.toString());

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

	public void DBDeletePet(Customer cus, Pet pet) {

		//open connection
		Connection con = DBConnect();

		//SQL Statement
		//Delete related MedHistory
		Statement stmt0 = null;
		try
		{ String sql2 = "DELETE FROM Medical_History " +
				"WHERE pid=(SELECT pid FROM Pet WHERE pet_name='" + pet.getName() + "' AND cid=(SELECT cid FROM Customer WHERE last_name='" + cus.getLastName() + "' AND first_name='" + cus.getFirstName() +"'));";
		stmt0 = con.createStatement();
		stmt0.executeUpdate(sql2);
		System.out.println("Medical History record deleted!");
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running MED HISTORY DELETE statement: " + e.toString());
		}

		//SQL Statement
		//Delete Pet
		Statement stmt1 = null;
		try
		{ String sql2 = "DELETE FROM Pet " +
				"WHERE cid=(SELECT cid FROM Customer WHERE last_name='" + cus.getLastName() + "' AND first_name='" + cus.getFirstName() +"') AND pet_name='" + pet.getName() + "';";
		stmt1 = con.createStatement();
		stmt1.executeUpdate(sql2);
		System.out.println("Pet record deleted!");
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running PET DELETE statement: " + e.toString());
		}

		//Close statement & connection
		try {
			stmt1.close();
			con.close();
			System.out.println("Connection closed succesfully!");
		}
		catch (Exception e1) {
			System.out.println("Error closing connection: " + e1.toString());
		}
	}

	public Pet DBGetPet(Customer cus, String petName) { 

		Pet pet = new Pet();

		//open connection
		Connection con = DBConnect();

		//SQL statement
		Statement stmt = null;
		ResultSet res = null;
		try
		{
			String sql = "SELECT * FROM Pet " 
					+ "WHERE pet_name='" + petName + "' AND cid=(SELECT cid FROM Customer " +
					"WHERE last_name='" + cus.getLastName() + "' AND first_name='" + cus.getFirstName() + "'); ";
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running SELECT PET statement: " + e.toString());
		}

		//Analyzing result and parsing the records to ArrayList
		try
		{
			if (!res.next()) {
				System.out.println("No records found");
			} else {
				pet.setPID(res.getInt("pid"));
				pet.setName(res.getString("first_name"));
				pet.setSpecies(res.getString("species"));
				pet.setGender(res.getString("gender"));
				String temp = res.getString("birthday");
				if (temp==null) {
					pet.setBirthDay(null);
				} else {
					Calendar tempCal = new GregorianCalendar();
					tempCal.setTime(dbDateFormat.parse(res.getString("next_visit")));
					pet.setBirthDay(tempCal);
				}
				pet.setFurColour(res.getString("fur_colour"));
				pet.setSpecialChars(res.getString("special_chars"));
				pet.setChipNumber(res.getString("chip_number"));
				System.out.println("Data analysis successfull!");
			}
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
		return pet;
	}


	//============================== MEDICAL HISTORY DB CONNECTIVITY =============================

	public MedHistory DBCreateMedHistory(Pet pet, FemMedHistory history) {
		FemMedHistory med = new FemMedHistory();
		med = history;
		//open connection
		Connection con = DBConnect();

		//SQL statement
		Statement stmt;
		ResultSet rs;

		try {
			String sql = "INSERT INTO Medical_History (pid, grafts, allergies, diseases, surgeries, treatments)" +
					"VALUES ('" + pet.getPID() + "', '" + history.getGrafts() + "', '" + history.getAllergies()  + "', '" + 
					history.getDiseases() + "', '" + history.getSurgeries() + "', '" + history.getMedicalTreatment() + "' " + ");";
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			rs = stmt.getGeneratedKeys();
			System.out.println("Statement Executed!");
			System.out.println("MID:" + rs.getInt("last_insert_rowid()"));
			med.setMID(rs.getInt("last_insert_rowid()"));
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
		return med;
	}

	public void DBUpdateMedHistory(MedHistory oldMedHist, MedHistory newMedHist) {

		//open connection
		Connection con = DBConnect();

		//SQL Statement
		//Update record
		Statement stmt = null;
		String sql1 = null;
		try
		{	
			sql1 = "UPDATE Medical_History " +
					"SET allergies='" + newMedHist.getAllergies() + "', grafts='" + newMedHist.getGrafts() + "', diseases='" + newMedHist.getDiseases() + 
					"', surgeries='" + newMedHist.getSurgeries() + "', treatments='" + newMedHist.getMedicalTreatment() + "' " +
					"WHERE mid='" + oldMedHist.getMID() + "';";

			stmt = con.createStatement();
			int rows = stmt.executeUpdate(sql1);
			System.out.println("Medical History record updated! rows: " + rows);
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running MEDICAL HISTORY UPDATE statement: " + e.toString());
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

	public void DBDeleteMedHistory(Pet pet) {

		//open connection
		Connection con = DBConnect();

		Statement stmt0 = null;
		try
		{ String sql2 = "DELETE FROM Medical_History " +
				"WHERE pid='" + pet.getPID() + "';";
		stmt0 = con.createStatement();
		stmt0.executeUpdate(sql2);
		System.out.println("Medical History record deleted!");
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running MED HISTORY DELETE statement: " + e.toString());
		}

		//Close statement & connection
		try {
			stmt0.close();
			con.close();
			System.out.println("Connection closed succesfully!");
		}
		catch (Exception e1) {
			System.out.println("Error closing connection: " + e1.toString());
		}
	}

	public MedHistory DBGetMedHistory(Pet pet) {

		//open connection
		Connection con = DBConnect();

		//SQL statement
		Statement stmt = null;
		ResultSet res = null;
		try
		{
			String sql = "SELECT * FROM Medical_History " 
					+ "WHERE pid='" + pet.getPID() + "'));";
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running SELECT MED HISTORY statement: " + e.toString());
		}

		//Analyzing result and parsing the records to ArrayList
		MedHistory history = new FemMedHistory();
		try
		{
			if (!res.next()) {
				System.out.println("No Medical History found");
			} else {
				history.setAllergies(res.getString("allergies"));
				history.setGrafts(res.getString("grafts"));
				history.setDiseases(res.getString("diseases"));
				history.setSurgeries(res.getString("surgeries"));
				history.setMedicalTreatment(res.getString("treatments"));
				history.setMID(res.getInt("mid"));
				System.out.println("Data analysis successfull!");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error processing results: " + e.toString());
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

		return history;
	}

	//============================== BIRTH DB CONNECTIVITY =============================

	public Birth DBCreateBirth(MedHistory history, Birth birth) {
		Birth temp = new Birth();
		temp = birth;

		//open connection
		Connection con = DBConnect();

		//SQL statement
		Statement stmt;
		ResultSet rs;

		try {
			String sql = "INSERT INTO Birth (mid, date, compilations,  children)" +
					"VALUES ('" + history.getMID() + "', '" + dbDateFormat.format(temp.getDate().getTime()) + "', '" 
					+ temp.getComplications() + "', '" + temp.getNumberOfChildren() + "');";
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			rs = stmt.getGeneratedKeys();
			System.out.println("Statement Executed!");
			System.out.println("BID:" + rs.getInt("last_insert_rowid()"));
			temp.setBID(rs.getInt("last_insert_rowid()"));
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
		return temp;
	}


	public void DBDeleteBirth(Birth birth) {

		//open connection
		Connection con = DBConnect();

		Statement stmt0 = null;
		try
		{ String sql2 = "DELETE FROM Birth " +
				"WHERE bid='" + birth.getBID() + "';";
		stmt0 = con.createStatement();
		stmt0.executeUpdate(sql2);
		System.out.println("Birth record deleted!");
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running BIRTH DELETE statement: " + e.toString());
		}

		//Close statement & connection
		try {
			stmt0.close();
			con.close();
			System.out.println("Connection closed succesfully!");
		}
		catch (Exception e1) {
			System.out.println("Error closing connection: " + e1.toString());
		}
	}

	public Birth DBGetBirth(MedHistory med, Calendar cal) {

		//open connection
		Connection con = DBConnect();

		//SQL statement
		Statement stmt = null;
		ResultSet res = null;
		try
		{
			String sql = "SELECT * FROM Birth " 
					+ "WHERE mid='" + med.getMID() + "' AND date='" +  dbDateFormat.format(cal.getTime())+ "';";
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running SELECT BIRTH statement: " + e.toString());
		}

		//Analyzing result and parsing the records to ArrayList
		Birth birth = new Birth();
		try
		{
			if (!res.next()) {
				System.out.println("No Medical History found");
			} else {
				birth.setBID(res.getInt("bid"));
				birth.setComplications(res.getString("compilations"));
				birth.setNumberOfChildren(res.getInt("children"));
				String temp = res.getString("date");
				Calendar tmpCal = new GregorianCalendar();
				tmpCal.setTime(dbPetDateFormat.parse(temp));
				birth.setDate(tmpCal);
				System.out.println("Data analysis successfull!");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error processing results: " + e.toString());
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

		return birth;
	}
	public void DBUpdateBirth(Birth oldBirth, Birth newBirth) {

		//open connection
		Connection con = DBConnect();

		//SQL Statement
		//Update record
		Statement stmt = null;
		String sql1 = null;
		try
		{	
			sql1 = "UPDATE Birth " +
					"SET compilations='" + newBirth.getComplications() + "', children='" + newBirth.getNumberOfChildren() + 
					"', date='" +  dbPetDateFormat.format(newBirth.getDate().getTime()) + "' " +
					"WHERE bid='" + oldBirth.getBID() + "';";

			stmt = con.createStatement();
			int rows = stmt.executeUpdate(sql1);
			System.out.println("Birth record updated! rows: " + rows);
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running BIRTH UPDATE statement: " + e.toString());
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

	public List<Birth> DBGetAllBirths(MedHistory med) {
		List<Birth> birthList = new ArrayList<Birth>();   

		//open connection
		Connection con = DBConnect();

		//SQL statement for getting Customers Pets by matching cid
		Statement stmt0 = null;
		ResultSet res = null;
		try
		{
			String sql0 = "SELECT * FROM Birth " +
					"WHERE mid='" + med.getMID() + "';";
			stmt0 = con.createStatement();
			res = stmt0.executeQuery(sql0);
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running SELECT BIRTH statement: " + e.toString());
		}

		//Analyzing result and parsing the records to ArrayList
		try
		{
			if (!res.next()) {
				System.out.println("No births found");
			} else {
				do {
					Birth tempBirth = new Birth();
					tempBirth.setBID(res.getInt("bid"));
					tempBirth.setComplications(res.getString("compilations"));
					tempBirth.setNumberOfChildren(res.getInt("children"));
					String tmp = res.getString("date");
					if (tmp==null) {
						//System.out.println("next_visit was not set");
						tempBirth.setDate(null);
					} else {
						//System.out.println("Date object retrieved: " + res.getString("next_visit"));
						//System.out.println("Date object retrieved: " + ft.format(ft.parse(res.getString("next_visit"))).toString());
						Calendar tmpCal = new GregorianCalendar();
						tmpCal.setTime(dbPetDateFormat.parse(tmp));
						tempBirth.setDate(tmpCal);
					}
					birthList.add(tempBirth);
				} while (res.next());
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error analyzing PET LIST statement: " + e.toString());
		} catch (ParseException e1) {
			System.out.println("Error parsing DATE: " + e1.toString());
		}

		//Close statement & connection
		try {
			stmt0.close();
			con.close();
			System.out.println("Connection closed succesfully!");
		}
		catch (Exception e1) {
			System.out.println("Error closing connection: " + e1.toString());
		}

		return birthList;
	}

}
