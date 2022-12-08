/**
 * 
 */
package com.listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.base.Testbase;

/**
 * @author anand acharya
 *	Listener to generate TestNg report after test suite execution
 */
public class TestNGReporter extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult result) {
		Object currentClass = result.getInstance();
		WebDriver driver =  ((Testbase)currentClass).getDriver();
		if(result.getStatus()==ITestResult.FAILURE) {
			Reporter.log("Test case failed is : "+result.getName());
			Reporter.log("Test case error is : "+result.getThrowable());
			try {
				String screenshot = getFailedScreenshotNameTestNg(result.getName(), driver);
				String html = "cid:"+screenshot;
				Reporter.log("<img src='"+html+"'/>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS){
			Reporter.log("Test case passed is : "+result.getName());
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		if(result.getStatus()==ITestResult.SKIP){
			Reporter.log("Test case skipped is : "+result.getName());
		}
	}
	
	//capture screenshots of failure and store in a folder
	public String getFailedScreenshotNameTestNg(String screenshotName, WebDriver driver) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String fileName = screenshotName+dateName+".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/failedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return fileName;
	}
}
