package com.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.driver.DriverManager;
import com.reports.ExtentLogger;
import com.reports.ExtentReport;


public final class ListenerClass implements ITestListener, ISuiteListener{
	
	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("before suite in listener");
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after suite in listener");
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getTestClass().getName()+ " @ "+ result.getMethod().getMethodName()+ " @ " + result.getMethod().getDescription());
		System.out.println(("*** Running Test Method " + result.getMethod().getMethodName() + "..."));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+ " Test is Passed");
		System.out.println("after method in listener : pass");
		System.out.println("*** Test Method " + result.getMethod().getMethodName() + " Executed successfully...");	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentLogger.fail(result.getMethod().getMethodName()+ " Test is Failed", true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println("after method in listener : fail and I am attaching screenshots here");
		System.out.println("*** Test Method " + result.getMethod().getMethodName() + " Failed...");
		
		/*try {
			DriverManager.getDriver() = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		     // We can replace the above code with a short one: 
		      // DriverManager.getDriver()=(WebDriver) ((Base)result.getInstance()).driver;
		     
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String screenshotPath=getPngScreenshot(testMethodName, driver);
			ExtentReport.initReports().addScreenCaptureFromPath(screenshotPath, testMethodName);
		} catch (IOException e) {
			e.printStackTrace();
		}*/	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " Test is Skipped");
		System.out.println("after method in listener : skipped and ignored");
		System.out.println("*** Test Method " + result.getMethod().getMethodName() + " Skipped...");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test Failed but within percentage % " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("*** Test Failed but with Timeout" + result.getMethod().getMethodName());		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("*** Test " + context.getName() + " Started! ***");	
	}

	@Override
	public void onFinish(ITestContext context) {		
		System.out.println(("*** Test " + context.getName() + " Ended! ***"));		
	}
}
