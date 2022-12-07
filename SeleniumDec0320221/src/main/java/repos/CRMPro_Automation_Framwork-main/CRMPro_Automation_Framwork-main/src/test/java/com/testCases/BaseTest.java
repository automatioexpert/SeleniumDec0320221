package com.testCases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.driver.Driver;

public class BaseTest {

	protected BaseTest() {
	
	}
	
	@BeforeMethod(alwaysRun = true)	//this method will be executed before every @test method
	@Parameters(value={"browser"})
	protected void setUp() throws Exception {
		//log.debug("Browser got launched");
		Driver.initDriver();
		//log.debug("Navigated to application URL");
	}
	
	@AfterMethod(alwaysRun = true) //--this method will be executed after every test method
	protected void tearDown(ITestResult result) {		
		Driver.quitDriver();
	}
	
	/*
	 * log.info("****************************** Browser is launched *****************************************");
	 * 
	 * log.info("****************************** Browser is Closed *****************************************");
		
	 */
}
