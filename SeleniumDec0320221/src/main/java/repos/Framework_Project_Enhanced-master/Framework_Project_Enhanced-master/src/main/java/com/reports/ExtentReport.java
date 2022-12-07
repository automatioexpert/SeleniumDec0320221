package com.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {

	private ExtentReport() {

	}

	private static ExtentReports extent;

	public static void initReports() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();

			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);

			spark.config().setDocumentTitle("Test Results");
			spark.config().setReportName("ExtentReports - CRMPro Automation");
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setEncoding("utf-8");
			spark.config().setProtocol(Protocol.HTTPS);

			extent.setSystemInfo("Tested By", "Hassen Hannachi");
			extent.setSystemInfo("GUI Testing", "QA");
			extent.setSystemInfo("Application", "crmpro.com/index.html");
		}
	}

	public static void flushReports() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}	
		ExtentManager.unload();
	}

	public static void creatTest(String testcasename) {
		ExtentTest test =extent.createTest(testcasename);
		ExtentManager.setExtentTest(test);
	}

}
