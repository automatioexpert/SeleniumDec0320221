package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listener extends Base implements ITestListener {
	
	public WebDriver driver=null;
	
	ExtentReports extentReport= ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread=new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();		
		extentTest=extentReport.createTest(testName+ " Execution started");
		
		extentTestThread.set(extentTest);		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		//extentTest.log(Status.PASS, testName+ " Test get Passed");	
		extentTestThread.get().log(Status.PASS, testName+ " Test get Passed");	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testMethodName = result.getName();
		
		//extentTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		    /* We can replace the above code with a short one: 
		     *      driver=(WebDriver) ((Base)result.getInstance()).driver;
		     */
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String screenshotPath=takeScreenshot(testMethodName, driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotPath, testMethodName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//extentTest.log(Status.SKIP, " Test skipped");
		extentTestThread.get().log(Status.SKIP, " Test skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		String testName=context.getName();		
		extentTest=extentReport.createTest("On Start Test Method" +testName);	
	}

	@Override
	public void onFinish(ITestContext context) {
		String testName=context.getName();		
		extentTest=extentReport.createTest("On Start Test Method" +testName);	
		extentReport.flush();
		System.out.println(("Extent Reports Version 5  Test Suite is ending!"));
	}
}
