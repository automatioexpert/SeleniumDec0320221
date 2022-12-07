package org.qa.sharif.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReportManager {
    public static ExtentReports report;
    public static ExtentTest test;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    public static Logger log;

}
