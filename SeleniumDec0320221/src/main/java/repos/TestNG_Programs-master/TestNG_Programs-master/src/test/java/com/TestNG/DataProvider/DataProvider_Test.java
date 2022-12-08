package com.TestNG.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Test {
	//parameterization = test case (Username + Password)[U1/P1, U2/P2, U3/P3...Un/Pn]
	//1st step: It return 2 dimensional array, so we need create object of 2D array
	//2nd step: Need to specify row and coloumns
	@DataProvider
	public Object[][]getData() {
		Object[][] data = new Object[3][4];
		
		data[0][0] = "Username";
		data[0][1] = "Password";
		data[0][2] = 101;
		data[0][3] = "Chrome";
		
		data[1][0] = "Username1";
		data[1][1] = "Password1";
		data[1][2] = 102;
		data[1][3] = "Firefox";

		data[2][0] = "Username2";
		data[2][1] = "Password2";
		data[2][2] = 103;
		data[2][3] = "Safari";
		
		return data;
	}
	
	@Test(dataProvider = "getData")   //3rd steps: Name of dataProvider has to be mentioned inside the data provider
	public void DataBank(String Username, String password, int ID, String Browser) {
		//4th step: no of input parameter inside the method = number of cols in the DataProvider object array
	}
}
