package com.inetBanking.utilites;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.inetBanking.testCases.BaseClass;


public class Reporting extends TestListenerAdapter {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void onStart(ITestContext testContext) {
		System.out.println("I am in onStart Test: " + testContext.getName());
		System.out.println("Extent Reports Version 4 Test Suite started!");
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String repName = "Test-Report-" + timeStamp + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentTestReport/" + repName);// specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/Configuration/extent-config.xml");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("QA Tester Name", "Hassen");
		extent.setSystemInfo("Application Name", "e-Banking Test");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("OS", "Windows 10");		
		extent.setSystemInfo("Browser", "Chrome");

		//htmlReporter.config().setDocumentTitle("InetBanking Test Project"); // Tile of report
		//htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
		//htmlReporter.config().setTheme(Theme.DARK);		
	}

	public void onTestSuccess(ITestResult tr) {
		System.out.println("I am in onTestSuccess method " +  tr.getName() + " succeed");
		//test.pass("Test passed");
		
		String feature = tr.getMethod().getRealClass().getName() + " @TestCase : " + tr.getMethod().getMethodName(); 
				
		test = extent.createTest(feature, tr.getName()); // create new entry in th report
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName()+ " - Test Case Passed", ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	}

	public void onTestFailure(ITestResult tr)  {
		String feature = tr.getMethod().getRealClass().getName() + " @TestCase : " + tr.getMethod().getMethodName(); 		
		test = extent.createTest(feature, tr.getName()); // create new entry in th report
		
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the passed information to the report with RED color highlighted
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		test.fail(tr.getThrowable());
		
		try {
			WebDriver driver=((BaseClass)tr.getInstance()).driver;
			String screenshotPath = captureScreen(driver, tr.getName());
			test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));
		} catch (Exception e) {
			// TODO: handle exception
		}
							
		System.out.println("I am in onTestFailure method " +  tr.getName() + " failed");
		System.out.println("***** Error " + tr.getName() + " test has failed *****");	
	}

	public void onTestSkipped(ITestResult tr) {
		System.out.println("I am in onTestSkipped method "+  tr.getTestName() + " skipped");
		test.skip(tr.getThrowable());
		
		String feature = tr.getMethod().getRealClass().getName() + " @TestCase : " + tr.getMethod().getMethodName(); 
		
		test = extent.createTest(feature, tr.getName()); // create new entry in th report
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName()+ " - Test Case Skipped", ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext) {
		System.out.println("I am in onFinish method " + testContext.getName());
		System.out.println(("Extent Reports Version 4  Test Suite is ending!"));
		extent.flush();
		
	}
	
	public static String captureScreen(WebDriver driver, String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String target = System.getProperty("user.dir") + "/Screenshots/" + tname +"_"+ timeStamp.toString().replace(":", "_") + ".png";

		File finalTaget=new File(target);
		FileUtils.copyFile(src, finalTaget);

		System.out.println("**********************************");
		System.out.println("Screenshot taken and stored at :"+ target);
		System.out.println("**********************************");	

		return target;		
	}
}