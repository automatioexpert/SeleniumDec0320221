package Listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import Base.DriverThreadLocal;
import TestCases.TestCase;
import TestCases.TwitterTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport implements ITestListener {
    private static Logger log = Logger.getLogger(ExtentReport.class.getSimpleName());
    public static ExtentReports reports = new ExtentReports("./Reports/" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html", true);

    public static ExtentTest test;

    public void onTestStart(ITestResult result) {
    }

    public void onTestSuccess(ITestResult result) {
        log.info("test success : "+ result.getTestContext().getCurrentXmlTest().getName());
        test.log(LogStatus.PASS, TestCase.finalJson.toString());
    }

    public void onTestFailure(ITestResult result) {
        log.info("test failure : "+ result.getTestContext().getCurrentXmlTest().getName());
        test.log(LogStatus.FAIL, result.getMethod().getMethodName()+ " test is failed");
        TakesScreenshot ts = (TakesScreenshot) DriverThreadLocal.getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("./raw_data/" + result.getMethod().getMethodName() + ".png"));
            String file = test.addScreenCapture("./raw_data/" + result.getMethod().getMethodName() + ".png");
            test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", file);
            test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed",
                    result.getThrowable().getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        log.info("test skipped :" + result.getTestContext().getCurrentXmlTest().getName()+":"+result.getMethod().getDescription());
        test.log(LogStatus.SKIP, result.getTestContext().getCurrentXmlTest().getName()+":"+result.getMethod().getDescription()+ "test is skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("on test success within percentage");
    }

    public void onStart(ITestContext context) {
        log.info(" Initializing : "+ context.getCurrentXmlTest().getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("on finish");
        reports.endTest(test);
        reports.flush();
    }
}
