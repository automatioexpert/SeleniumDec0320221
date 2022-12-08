package com.TestNG.DataProvider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class Multiple_DataRepository {
	
	//Here 'DataProvider' is for storing data
	@DataProvider
	
	public static Object[][] getData(Method name){
		System.out.println("Test case which has the method is: " + name.getName());
		Object[][] data = new Object[3][3];
		
		data[0][1] = "Raj";
		data[0][2] = 101;
		data[0][3] = "Rajkawale712@gmail.com";
		
		data[1][1] = "Sam";
		data[1][2] = 102;
		data[1][3] = "Sammy00@gmail.com";
		
		data[2][1] = "David";
		data[2][2] = 103;
		data[2][3] = "DavidBeck@gmail.com";
		
		return data;
	}
}
