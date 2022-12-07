package com.testCases;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.reports.ExtentLogger;
import com.reports.ExtentManager;
import com.reports.ExtentReport;
import com.utils.BrokenImages;
import com.utils.BrokenLinks;

public class FourTest extends BaseTest{

    private FourTest() {
		
	}

	Logger log = LogManager.getLogger(FourTest.class.getName());	
	
	@Test(priority=0, description = "This is a description for testFour")
	public void testFourTest() throws InterruptedException {
		
		log.info("****************************** starting test case testFourTest *****************************************");
		System.out.println("TestFour");		
		
		ExtentLogger.log(Status.INFO, " Hey I'm in FourTest");
		ExtentLogger.log(Status.INFO, "Hellooo testFourTest Method Started ");
		
		ExtentReport.addAuthors('QA', 'Tester', '1');
		
		ExtentReport.addAuthors("QA Tester 1");
		ExtentRepor.assignCategory("Dummy Test");		
		
		Thread.sleep(2000);
		Assert.assertTrue(false);
		log.warn("Test Failed");
		
		log.info("****************************** ending test case testFourTest *****************************************");
	}
	
	@Test(priority=1, description = "Find broken images on a web page")
   	public void verifyBrokenImages(){
		log.info("****************************** starting test case verifyBrokenlinks *****************************************");
    	    	
    	BrokenImages.validateInvalidImages();
	    
    	ExtentLogger.log(Status.INFO," Hey I'm in FourTest");
   		ExtentLogger.log(Status.INFO, " Hey I'm in FourTest");
   		ExtentLogger.log(Status.INFO, "Hellooo validateInvalidImages Method Started ");
   		
   		log.info("****************************** ending test case verifyBrokenImages *****************************************");
   	}
	
	@Test(priority=2, description = "Find broken Links on a web page")
   	public void verifyBrokenlinks(){
		log.info("****************************** starting test case verifyBrokenlinks *****************************************");
		
    	BrokenLinks.myBrokenLinks();
    	
    	ExtentManager.getExtentTest().createNode("INFO")
		 .log(Status.INFO, " Hey I'm in FourTest")
		 .log(Status.INFO, "Hellooo verifyBrokenImages Method Started ");    	
  	
    	ExtentReport.addAuthors(["QA Tester 1"]);
    	ExtentReport.assignCategory("Dummy Test");
   		
   		List<Object> items = Arrays.asList(new Object[] {"Hey I'm in FourTest", "Hellooo started verifyBrokenlinks method"});
   		ExtentManager.getExtentTest().createNode("INFO").info(MarkupHelper.createOrderedList(items));
   		
   		log.info("****************************** ending test case verifyBrokenlinks *****************************************");
   	}
}
