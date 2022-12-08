package com.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLSelectCommand_1 {
	 /*
	  * Data Retriveal/Data Query Language
	  */
	
	public static void main(String[]args) throws SQLException {
		//1.	Create a connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight","root","root");
		
		//2.	Create a statement/Query
		Statement stmt=con.createStatement();
		
		String query="SELECT tripId, ssn, fromCity, toCity, departureDate, returnDate FROM trip";
		String query2="SELECT * FROM trip WHERE tripId=102";
				
		//	3.	Execute statement/Query
		stmt.execute(query);
		//stmt.execute(query2);
		
		//4.	Store the results in result set
		ResultSet rs=stmt.executeQuery(query);
		//ResultSet rs=stmt.executeQuery(query2);
		
		while (rs.next()) {
			int tripid=rs.getInt("tripId");
			int ssn=rs.getInt("ssn");
			String cityn=rs.getString("fromCity");
			String destin=rs.getString("toCity");
			String depart=rs.getString("departureDate");
			String retrn=rs.getString("returnDate");
			 
			System.out.println(tripid+ "     " +ssn +"     " +cityn +"    "+destin+"       "+depart+ "    "+retrn);
		}
		
		//5.	Close connection
		con.close();
		
		System.out.println("Query executed succefully");
	}
}
