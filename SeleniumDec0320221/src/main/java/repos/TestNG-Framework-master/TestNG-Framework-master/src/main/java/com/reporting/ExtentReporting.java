package com.reporting;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utils.DateUtils;
import com.utils.FileUitls;
import com.utils.LoggersUtils;

public class ExtentReporting {

	ExtentReports extent;
	ExtentTest test;

	public ExtentReporting(String name) throws ClassNotFoundException {
		createExtentReports(name);
	}

	public void createExtentReports(String name) {
		extent = new ExtentReports();
		try {
			LoggersUtils.getInstance(Class.forName("com.testing." + name));
		} catch (ClassNotFoundException e) {
			System.err.println("Please check the logger initilization package name for class: " + name
					+ " in createExtentReports() method.");
			System.exit(1);
		}

		String folderName = FileUitls.getReportsFolderPath(name);

		ExtentSparkReporter spark = new ExtentSparkReporter(
				folderName + "/HTMLReport" + DateUtils.getTimeStamp() + ".html");

		spark.config().enableOfflineMode(true);
		spark.config().setDocumentTitle("Automation Suite");
		spark.config().setEncoding("utf-8");
		spark.config().setProtocol(Protocol.HTTPS);
		spark.config().setReportName("Club Kitchen Automation");
		spark.config().setCss("css");
		spark.config().setJs("js");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		extent.attachReporter(spark);
		extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
		InetAddress id = null;
		try {
			id = InetAddress.getLocalHost();
			extent.setSystemInfo("Host IP Address", id.getLocalHost().getHostAddress());
			extent.setSystemInfo("HostName", id.getHostName());
			extent.setSystemInfo("OS", System.getProperty("os.name"));
		} catch (UnknownHostException e) {
			System.err.println("Failed at getting host name...");
		}

	}

	public void createTestCase(String name) {
		test = extent.createTest(name);
	}

	public void createTestCase(String name, String author, String category) {
		test = extent.createTest(name);
		test.assignAuthor(author);
		test.assignCategory(category);
	}

	public void createTestCase(String name, String author, String category, String device) {
		test = extent.createTest(name);
		test.assignAuthor(author);
		test.assignCategory(category);
		test.assignDevice(device);

	}

	public void logTestSteps(Status status, String message) {
		switch (status) {
			case FAIL:
				test.fail(message);
				LoggersUtils.getLog().fatal(message);
				break;
			case INFO:
				test.info(message);
				LoggersUtils.getLog().info(message);
				break;
			case PASS:
				test.pass(message);
				LoggersUtils.getLog().info(message);
				break;
			case SKIP:
				test.skip(message);
				break;
			case WARNING:
				test.warning(message);
				LoggersUtils.getLog().warn(message);
				break;
			default:
				break;

		}
	}

	public void logTestStepWithScreenshot(WebDriver driver, Status status, String message) throws IOException {

		String screenshotName = takeScreenshot(driver);
		Media mediaModel = MediaEntityBuilder.createScreenCaptureFromPath("../../screenshots/"+ screenshotName, "screenshot").build();

		switch (status) {
			case FAIL:
				test.fail(message, mediaModel);
				LoggersUtils.getLog().fatal(message);
				break;
			case INFO:
				test.info(message, mediaModel);
				LoggersUtils.getLog().info(message);
				break;
			case PASS:
				test.pass(message, mediaModel);
				LoggersUtils.getLog().info(message);
				break;
			case SKIP:
				test.skip(message, mediaModel);
				break;
			case WARNING:
				test.warning(message, mediaModel);
				LoggersUtils.getLog().warn(message);
				break;
			default:
				break;

		}

	}

	private String takeScreenshot(WebDriver driver) throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destFile = new File(
				System.getProperty("user.dir") + "/screenshots/scren_" + DateUtils.getTimeStamp() + ".png");
		FileUtils.copyFile(screenshotFile, destFile);
		return destFile.getName();

	}

	public void closeTest() {

		extent.flush();
	}

}
