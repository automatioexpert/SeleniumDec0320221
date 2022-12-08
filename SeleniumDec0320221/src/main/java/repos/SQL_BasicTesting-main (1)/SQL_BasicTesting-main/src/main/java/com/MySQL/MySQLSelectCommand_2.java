package com.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLSelectCommand_2 {
	/* 
	 * In this class example We will use try & catch to capture any SQLExecption
	 * */
	
	static final String DB_URL="jdbc:mysql://localhost:3306/flight";

	//Datbase credentials
	static final String USER="root";
	static final String PASS="root";
	
	public static void main(String[] args) {		
		
		Connection con=null;
		Statement stmt=null;

		try {
			//Open a connection
			System.out.println("Connecting to database...");
			con =DriverManager.getConnection(DB_URL,USER,PASS);

			//Create statement
			System.out.println("Creating statement...");
			stmt=con.createStatement();

			//Execute a query
			System.out.println("Execute the query ...");
			String query="SELECT tripId, ssn, fromCity, toCity, departureDate, returnDate FROM trip";
			ResultSet rs=stmt.executeQuery(query);

			//retrieve by column name
			while (rs.next()) {
				int tripid = rs.getInt("tripId");
				int ssn = rs.getInt("ssn");
				String cityn = rs.getString("fromCity");
				String destin = rs.getString("toCity");
				String depart = rs.getString("departureDate");
				String retrn = rs.getString("returnDate");

				System.out.println(tripid + "     " + ssn + "     " + cityn + "    " + destin + "       " + depart
						+ "    " + retrn);
			}

			//Close environment
			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException se) {
			// TODO: handle exception
			se.printStackTrace();

		}catch (Exception e) {
			// TODO: handle exception	
			e.printStackTrace();
		}finally {
			//used to close resources
			try {
				if (stmt!=null) {
					stmt.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				if (con!=null) {
					con.close();
				}
			} catch (SQLException se) {
				// TODO: handle exception
				se.printStackTrace();
			}
		}	
	}
}
