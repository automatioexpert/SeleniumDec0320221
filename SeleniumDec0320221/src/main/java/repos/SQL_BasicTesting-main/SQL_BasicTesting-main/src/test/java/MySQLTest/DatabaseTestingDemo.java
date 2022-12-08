package MySQLTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DatabaseTestingDemo {
	static Connection con = null; // connection object
	static Statement stmt = null; // statement object

	static final String DB_URL = "jdbc:mysql://localhost:3306/flight"; // constant for database URL
	static final String USER = "root"; // constant for database username
	static final String PASS = "root"; // constant for database password

	@BeforeMethod

	@BeforeTest
	public static void setUp() throws Exception {
		try {
			// Open a connection
			System.out.println("Connecting to database...");
			con = DriverManager.getConnection(DB_URL, USER, PASS);

			// Create statement
			System.out.println("Creating statement...");
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		try {
			// Execute a query
			System.out.println("Execute the query ...");
			String query = "SELECT tripId, ssn, fromCity, toCity, departureDate, returnDate FROM trip";
			ResultSet rs = stmt.executeQuery(query); // get the contents of the query

			// retrieve by column name
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
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		try {
			// Execute a query
			System.out.println("Execute the query ...");
			String query = "SELECT tripId, ssn, fromCity, toCity, departureDate, returnDate FROM trip WHERE tripId=102";
			ResultSet rs = stmt.executeQuery(query); // get the contents of the query

			// retrieve by column name
			while (rs.next()) {
				int tripid = rs.getInt(1);
				int ssn = rs.getInt(2);
				String cityn = rs.getString(3);
				String destin = rs.getString(4);
				String depart = rs.getString(5);
				String retrn = rs.getString(6);

				System.out.println(tripid + "     " + ssn + "     " + cityn + "    " + destin + "       " + depart
						+ "    " + retrn);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@AfterMethod

	@AfterTest
	public void tearDown() {
		try {
			// Close environment
			stmt.close();
			con.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// used to close resources
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e2) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
