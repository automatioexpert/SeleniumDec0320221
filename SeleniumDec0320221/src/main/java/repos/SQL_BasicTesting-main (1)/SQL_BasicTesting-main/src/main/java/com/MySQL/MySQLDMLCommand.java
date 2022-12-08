package com.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDMLCommand {
	
	public static void main(String[]args) throws SQLException {
		//1.	Create a connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_test","root","root");
		
		//2.	Create a statement/Query
		Statement stmt=con.createStatement();
		
		//String query="INSERT INTO STUDENT (snum,firstname) VALUES (100003,'SMITH')";
		//String query="UPDATE STUDENT SET FIRSTNAME='DAVID' WHERE SNUM=100003";
		String query="DELETE FROM STUDENT WHERE snum=100003";
		
		//	3.	Execute statement/Query
		stmt.execute(query);
		
		//4.	Close connection
		con.close();
		
		System.out.println("Query executed..");
	}
}
