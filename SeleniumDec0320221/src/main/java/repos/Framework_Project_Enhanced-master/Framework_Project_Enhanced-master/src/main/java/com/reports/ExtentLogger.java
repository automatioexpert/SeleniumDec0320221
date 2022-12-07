package com.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.enums.ConfigProperties;
import com.utils.PropertyUtils;
import com.utils.ScreenshotUtils;

/**
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 * @see ExtentManager
 * @see PropertyUtlis
 */
public final class ExtentLogger {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentLogger() {

	}
	
	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param message
	 */
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param message
	 */
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param message
	 */
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param message
	 * @param isScreenshotNeeded
	 * @throws Exception 
	 */
	public static void pass(String message, boolean isScreenshotNeeded) throws Exception {
		if (PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			 ExtentManager.getExtentTest().pass(message, 
					 MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}
	
	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param message
	 * @param isScreenshotNeeded
	 * @throws Exception 
	 */
	public static void fail(String message, boolean isScreenshotNeeded) throws Exception {
		if (PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			 ExtentManager.getExtentTest().fail(message, 
					 MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}
	
	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param message
	 * @param isScreenshotNeeded
	 * @throws Exception 
	 */
	public static void skip(String message, boolean isScreenshotNeeded) throws Exception{
		if (PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			 ExtentManager.getExtentTest().skip(message, 
					 MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			skip(message);
		}
	}	
}
