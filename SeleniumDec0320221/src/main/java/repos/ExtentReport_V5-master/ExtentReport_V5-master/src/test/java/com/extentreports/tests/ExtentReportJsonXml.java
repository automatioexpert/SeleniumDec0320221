package com.extentreports.tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportJsonXml {
	
	// To Logging JSON and XML in extent report 
	
	private ExtentReportJsonXml() {

	}
	
	@Test
	public void extentTest() throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html"); // html file will be generated
		
		extent.attachReporter(spark);

		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Extent Reports Demo");

		ExtentTest test = extent.createTest("Login Test").assignAuthor("Hassen").assignCategory("Smoke")
				.assignCategory("Regression").assignDevice("Chrome 84"); // Create a test node in the report
		test.pass("Login Test Started successfully"); // Create a test step node in the report
		test.info("URL is Loaded");
		test.info("Value is entered");
		
		String jsoncode="{ \r\n" +
				" \"accounting\": [ \r\n"+
				" 				  { \"firstname\" : \"John\", \r\n" +
				"					 \"lastname\" : \"Doe\", \r\n" +
				"					 \"age\"      : 23}, \r\n" +
				"\r\n" +
				" 				  { \"firstname\" : \"Mary\", \r\n" +
				"					 \"lastname\" : \"Smith\", \r\n" +
				"					 \"age\"      : 32}, \r\n" +
				"  				],							 \r\n" +
				"  \"sales\"	: [ \r\n"+
				"				  { \"firstname\" : \"Sally\", \r\n" +
				"					\"lastname\"  : \"Green\", \r\n" +
				"					\"age\"       : 27}, \r\n" +
				"\r\n" +
				"				  { \"firstname\" : \"Jim\", \r\n" +
				"				    \"lastname\"  : \"Galley\", \r\n" +
				"					\"age\"       : 41}, \r\n" +
				"			  ] \r\n" +
				"}";
		
		test.info(jsoncode);		
		test.info("<pre>"+ jsoncode.replace("\n", "<br>")+ "</pre>");
		test.info(MarkupHelper.createCodeBlock(jsoncode, CodeLanguage.JSON));
		
		String xmlcode= "\r\n"+
						" <employee>\r\n"+
						" <firstname>John</firstname>\r\n"+
						" <lastname>Smith</lasttname>\r\n"+
						"</employee>";
		test.info(MarkupHelper.createCodeBlock(xmlcode, CodeLanguage.XML));
		
		test.pass("Login Test completed successfully");
		
		extent.flush();  //Unless you call this method, your report will be not written with logs
		Desktop.getDesktop().browse(new File("index.html").toURI());  //will open the file in the desktop default browser.
	}

}
