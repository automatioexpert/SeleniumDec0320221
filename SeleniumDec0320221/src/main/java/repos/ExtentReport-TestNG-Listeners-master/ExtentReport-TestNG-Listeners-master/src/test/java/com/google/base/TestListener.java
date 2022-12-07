package com.google.base;

import com.aventstack.extentreports.Status;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		ExtentTestManager.getTest().fail(result.getThrowable());
		try {
			WebDriver driver=((TestBase)result.getInstance()).driver;
			String path = TakeScreenshot(driver, result.getMethod().getMethodName());
			ExtentTestManager.getTest().fail("Screenshot is below:" + ExtentTestManager.getTest().addScreenCaptureFromPath(path));
		} catch (Exception e) {
		
		}		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
	public static String TakeScreenshot(WebDriver driver, String tname) throws IOException {
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
	
	public String Takescreenshot2(WebDriver driver, String methodName) {
		String fileName = getScreenshotName(methodName);
		String projectPath = System.getProperty("user.dir") + "\\Screeshots\\";
		new File(projectPath).mkdirs();
		String path = projectPath + fileName;
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(path));
			
			System.out.println("**********************************");
			System.out.println("ScreenShot stored at: " + path);
			System.out.println("**********************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String fileName = methodName + "_" + d.toString().replace(":", "_") + ".png";
		return fileName;
	}
}
