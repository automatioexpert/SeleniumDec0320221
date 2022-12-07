package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.driver.Driver;


public class BaseTest {

	protected BaseTest() {
		
	}
	
	@BeforeMethod(alwaysRun = true)
	protected void setUp() throws Exception {
		Driver.initDriver();
	}
	
	@AfterMethod(alwaysRun = true)
	protected void tearDown() {		
		Driver.quitDriver();
	}

}
