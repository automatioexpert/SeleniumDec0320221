package com.extentreports.tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReportBasic {
	
	private ExtentReportBasic() {
		
	}

	@Test
	public void extentTest() throws IOException {
		ExtentReports extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("index.html");  //html file will be generated
		extent.attachReporter(spark);
		
		/*
		 * To load extent XML config file for extent report
		 *  
		 * final File CONF = new File("extentconfig.xml");
		 * spark.loadXMLConfig(CONF);
		*/
		
		/*To load extent Json config file for extent report
		 * 
		 * final File CONF = new File("extentconfig.json");
		 * spark.loadJSONConfig(CONF);
		 */
		
		/* It can be Replaced with config.xml or config.json file*/		
		spark.config().setTheme(Theme.STANDARD); 
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Extent Reports Demo"); 
		  		
		ExtentTest test=extent.createTest("Login Test").assignAuthor("Hassen")
				.assignCategory("Smoke").assignCategory("Regression").assignDevice("Chrome 84"); // Create a test node in the report
		test.pass("Login Test Started successfully");  // Create a test step node in the report
		test.info("URL is Loaded");
		test.info("Value is entered");		
		test.pass("Login Test completed successfully");
		
		// version 5 removed debug, fatal, error --> To match JUnit or Testing
				
		ExtentTest test1=extent.createTest("HomePage Test").assignAuthor("Anis").assignAuthor("Lyes")
		 
				.assignCategory("Regression").assignDevice("Fireforx 60"); // Create a test node in the report
		test1.pass("HomePage Test Started successfully");  // Create a test step node in the report
		test1.info("URL is Loaded");
		test1.info("Value is entered");
		test1.fail("HomePage Test failed miserably");
		
		extent.flush();  //Unless you call this method, your report will be not written with logs
		Desktop.getDesktop().browse(new File("index.html").toURI());  //will open the file in the desktop default browser.
	}
}
