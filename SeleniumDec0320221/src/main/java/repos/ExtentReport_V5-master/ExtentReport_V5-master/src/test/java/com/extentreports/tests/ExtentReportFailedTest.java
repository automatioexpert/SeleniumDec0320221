package com.extentreports.tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReportFailedTest{
	
	/**
	 * 1. To have all the tests irrespective of test status -->index.html
	 * 2. To have only the failed test case --> failed-tests-index.html
	 * @throws IOException 
	 */
	
	private ExtentReportFailedTest() {

	}

	@Test
	public void extentTest() throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html"); // html file will be generated
		ExtentSparkReporter failedspark=new ExtentSparkReporter("failed-tests-index.html").filter().statusFilter().as(new Status [] {Status.FAIL}).apply();
		
		extent.attachReporter(spark, failedspark);
	
		failedspark.config().setDocumentTitle("Failed Test");

		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Extent Reports Demo");

		ExtentTest test = extent.createTest("Login Test").assignAuthor("Hassen").assignCategory("Smoke")
				.assignCategory("Regression").assignDevice("Chrome 84"); // Create a test node in the report
		test.pass("Login Test Started successfully"); // Create a test step node in the report
		test.info("URL is Loaded");
		test.info("Value is entered");
		test.pass("Login Test completed successfully");

		// version 5 removed debug, fatal, error --> To match JUnit or Testing

		ExtentTest test1 = extent.createTest("HomePage Test").assignAuthor("Anis").assignAuthor("Lyes")
				.assignCategory("Regression").assignDevice("Fireforx 60");   // Create a test node in the report
		test1.pass("HomePage Test Started successfully"); // Create a test step node in the report
		test1.info("URL is Loaded");
		test1.info("Value is entered");
		test1.fail("HomePage Test failed miserably");

		extent.flush(); // Unless you call this method, your report will be not written with logs
		Desktop.getDesktop().browse(new File("index.html").toURI()); // will open the file in the desktop default browser.
		Desktop.getDesktop().browse(new File("failed-tests-index.html").toURI());
	}
}
