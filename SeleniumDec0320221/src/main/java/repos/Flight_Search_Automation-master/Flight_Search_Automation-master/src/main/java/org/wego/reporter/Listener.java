package org.wego.reporter;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.wego.driver.DriverHelper;

import java.io.IOException;

public class Listener extends ReportManager implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String methodName = iTestResult.getMethod().getMethodName();
        Object[] parameters = iTestResult.getParameters();
        test = report.createTest(methodName);
        extentTest.set(test);
        for (Object parameter : parameters) {
            extentTest.get().log(Status.INFO, "Test data :" + parameter);
        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String methodName = iTestResult.getMethod().getMethodName();
        try {
            String screenShot = DriverHelper.getScreenshot(methodName);

            extentTest.get().addScreenCaptureFromPath(".\\screenshot" + screenShot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.get().fail(iTestResult.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        String methodName = iTestResult.getMethod().getMethodName();
        test = report.createTest(methodName);
        extentTest.set(test);
        extentTest.get().skip("Test Skip: " + methodName);
        report.flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        report = ExtentReporter.getReportObject();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        report.flush();
    }
}
