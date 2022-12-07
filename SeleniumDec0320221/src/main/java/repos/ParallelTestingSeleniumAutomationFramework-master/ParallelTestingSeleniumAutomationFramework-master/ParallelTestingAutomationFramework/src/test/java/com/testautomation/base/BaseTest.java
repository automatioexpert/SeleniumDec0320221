package com.testautomation.base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.testautomation.utilities.PropertiesFileReader;
import com.testautomation.utilities.TestDataHandler;

public class BaseTest {
	
	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	
	@BeforeSuite(alwaysRun=true)
	public void oneTimeSetUp() {
		PropertiesFileReader configData = new PropertiesFileReader();
		Properties prop=null;
		try {
			prop = configData.getPropertyForConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}
		new TestDataHandler().setEnvironment(prop.get("ApplicationEnvironment").toString());
	}
	
	@AfterSuite(alwaysRun=true)
	public void oneTimeTearDown() {
		logger.info("Completed with executing all the Test cases...");
	}
	
	
}
