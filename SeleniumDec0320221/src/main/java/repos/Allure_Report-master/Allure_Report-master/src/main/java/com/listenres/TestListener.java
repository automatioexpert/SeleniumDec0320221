package com.listenres;


import static com.reports.ExtentManager.getExtentReports;
import static com.reports.ExtentTestManager.getTest;

import com.aventstack.extentreports.Status;
import io.qameta.allure.Attachment;
import java.util.Objects;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.tests.BaseTest;
import com.logs.Log;

public final class TestListener extends BaseTest implements ITestListener {
	    private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	    }

	    //Text attachments for Allure
	    @Attachment(value = "Page screenshot", type = "image/png")
	    public byte[] saveScreenshotPNG(WebDriver driver) {
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    }

	    //Text attachments for Allure
	    @Attachment(value = "{0}", type = "text/plain")
	    public static String saveTextLog(String message) {
	        return message;
	    }

	    //HTML attachments for Allure
	    @Attachment(value = "{0}", type = "text/html")
	    public static String attachHtml(String html) {
	        return html;
	    }

	    @Override
	    public void onStart(ITestContext iTestContext) {
	        Log.info("I am in onStart method " + iTestContext.getName());
	        iTestContext.setAttribute("WebDriver", this.driver);
	    }

	    @Override
	    public void onFinish(ITestContext iTestContext) {
	        Log.info("I am in onFinish method " + iTestContext.getName());
	        //Do tier down operations for ExtentReports reporting!
	        getExtentReports().flush();
	    }

	    @Override
	    public void onTestStart(ITestResult iTestResult) {
	        Log.info(getTestMethodName(iTestResult) + " test is starting.");
	    }

	    @Override
	    public void onTestSuccess(ITestResult iTestResult) {
	        Log.info(getTestMethodName(iTestResult) + " test is succeed.");
	        //ExtentReports log operation for passed tests.
	        getTest().log(Status.PASS, "Test passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult iTestResult) {
	        Log.info(getTestMethodName(iTestResult) + " test is failed.");

	        //Get driver from BaseTest and assign to local webdriver variable.
	        Object testClass = iTestResult.getInstance();
	        WebDriver driver = ((BaseTest) testClass).getDriver();

	        //Allure ScreenShotRobot and SaveTestLog
	        if (driver != null) {
	            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
	            saveScreenshotPNG(driver);
	        }

	        //Save a log on allure.
	        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");

	        //Take base64Screenshot screenshot for extent reports
	        String base64Screenshot =
	            "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);

	        //ExtentReports log and screenshot operations for failed tests.
	        getTest().log(Status.FAIL, "Test Failed",
	            getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
	    }

	    @Override
	    public void onTestSkipped(ITestResult iTestResult) {
	        Log.info(getTestMethodName(iTestResult) + " test is skipped.");
	        //ExtentReports log operation for skipped tests.
	        getTest().log(Status.SKIP, "Test Skipped");
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	    }
	}
}
