package com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.driver.DriverManager;

public final class ScreenshotUtils {
	
	private ScreenshotUtils() {

	}

	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
	
	public static String getPngScreenshot(String testMethodName, WebDriver driver) {
		File sourceFile =((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		String destinationFilePath=System.getProperty("user.dir")+ "\\Execution Reports\\FailedTestScreenshots\\" + testMethodName +".png";
		try {
			FileUtils.copyFile(sourceFile, new File (destinationFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationFilePath;		
	}
}
