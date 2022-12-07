package com.extentreports.tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class AttachLogo {
	
	/**
	 * 1. Attach company Logo to the extent report
	 * 2. How to use config files to set up extent report
	 * @throws IOException 
	 */
	@Test
	public void attachLogoTest() throws IOException {
		ExtentReports extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("index.html");
		spark.loadXMLConfig(new File("extentconfig.xml"));
		extent.attachReporter(spark);
		
		ExtentTest test=extent.createTest("First Test");
		test.pass("Test started");
		test.pass("Test finished");
		
		extent.flush();  
		Desktop.getDesktop().browse(new File("index.html").toURI());  
	}

}
