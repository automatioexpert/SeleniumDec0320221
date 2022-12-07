package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	/**
	 * This method is used to load the properties from config.properties file
	 * @author Hemanshu Chauhan
	 * @return 
	 * 
	 */
	
	public Properties init_Prop()
	{
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("/Users/hemanshuchauhan/Downloads/Cucumber6_BDDFramework_JUnit-master/src/test/resources/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}

}
