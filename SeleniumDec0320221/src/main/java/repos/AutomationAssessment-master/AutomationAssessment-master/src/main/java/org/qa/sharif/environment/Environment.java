package org.qa.sharif.environment;

public class Environment {

    public static final String propertyFileLocation = System.getProperty("user.dir") +"\\src\\main\\resources\\application.properties";
    public static final String testDataFile = System.getProperty("user.dir") +"\\src\\test\\resources\\testdata\\CalculateCurrency.xls";
    public static final String screenshotDirectory = System.getProperty("user.dir") + "\\reports\\screenshot";
    public static final String extentReportDirectory = System.getProperty("user.dir") + "\\reports";

}
