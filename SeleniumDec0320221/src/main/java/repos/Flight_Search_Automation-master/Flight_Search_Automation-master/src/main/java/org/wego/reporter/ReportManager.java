package org.wego.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class ReportManager {
    public static ExtentReports report;
    public static ExtentTest test = null;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
}
