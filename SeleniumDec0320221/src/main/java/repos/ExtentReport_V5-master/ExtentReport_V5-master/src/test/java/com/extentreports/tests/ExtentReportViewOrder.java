package com.extentreports.tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReportViewOrder {
	
	/**
	 * 1. Change the viewing order
	 * 2. Remove some menu
	 * 3. Highlight a particular log line
	 * 4. List of string --> How can i log in the report
	 * 5. Map<String, String>  --> How can i log in the report
	 */

	private ExtentReportViewOrder() {

	}

	@Test
	public void extentTest() throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html").viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY}).apply(); 

		extent.attachReporter(spark);

		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Extent Reports Demo");

		ExtentTest test = extent.createTest("Login Test").assignAuthor("Hassen").assignCategory("Smoke")
				.assignCategory("Regression").assignDevice("Chrome 84"); 
		
		test.pass("Login Test Started successfully"); 
		test.info("URL is Loaded");
		test.info("Value is entered");
		test.pass("Login Test completed successfully");
		
		Arrays.asList(new String[] {"Selenium","Appium","Rest Assured"}).forEach(e->test.pass(e));  // forEach(test::pass)
		test.pass(MarkupHelper.createOrderedList(Arrays.asList(new String[] {"Selenium","Appium","Rest Assured"})).getMarkup());
		test.pass(MarkupHelper.createUnorderedList(Arrays.asList(new String[] {"Selenium","Appium","Rest Assured"})).getMarkup());
		
		Map<String, String> map=new HashMap<>();
		map.put("fname", "Amuthan");
		map.put("lname", "sakthivel");
		map.put("channelname", "testingminibytes");
		map.forEach((k,v)->test.pass(k+":"+v));
		test.pass(MarkupHelper.createUnorderedList(map).getMarkup());
				
		test.pass(MarkupHelper.createLabel("Login Test completed successfully", ExtentColor.GREEN));
		
		ExtentTest test1=extent.createTest("HomePage Test").assignAuthor("Anis").assignAuthor("Lyes")
				.assignCategory("Regression").assignDevice("Fireforx 60"); 
		
		test1.pass("HomePage Test Started successfully");  
		test1.info("URL is Loaded");
		test1.info("Value is entered");
		test1.fail("HomePage Test failed miserably");
		test1.fail(MarkupHelper.createLabel("HomePage Test failed miserably", ExtentColor.RED));
		
		extent.flush();  
		Desktop.getDesktop().browse(new File("index.html").toURI());  
	}
}
