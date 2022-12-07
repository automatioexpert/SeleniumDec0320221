package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day2 {
	@Test(dataProvider="getData")
	public void day2(String username, String password)
	{
		System.out.println();
		System.out.println("Data provider");
		System.out.println(username);
		System.out.println(password);
		System.out.println();
	}
	@Test (groups= {"Smoke"})
	public void smoke()
	{
		System.out.println("Smoke");
	}
	@BeforeTest //Before executing any other methods in this file, TestNG will first execute this method
	public void prerequisite()
	{
		System.out.println("Before Test");
	}
	@AfterTest
	//Will execute in last of test suite and not at the end of framework
	public void last()
	{
		System.out.println("After Test");
	}
	//Parameterizing with multiple data sets by running tests with multiple connection
	@DataProvider
	public Object[][] getData()
	{
		//1st combination - user name and password - good credit history
		//2nd - user name and password -no credit history
		//2nd - user name and password -false credit history
		//Creating multi-dimensional array
		Object[][] data = new Object[3][2]; //Array with 3 rows for 3 combination and 2 columns for 2 parameters used
		data[0][0]="firstrowusername";
		data[0][1]="password";
		//columns in the row are nothing but values for that particular combination
		
		//2nd set
		data[1][0]="secondrowusername";
		data[1][1]="secondpassword";
		
		//3nd set
		data[2][0]="secondrowusername";
		data[2][1]="secondpassword";
		return data; //must return data
	}
}
 