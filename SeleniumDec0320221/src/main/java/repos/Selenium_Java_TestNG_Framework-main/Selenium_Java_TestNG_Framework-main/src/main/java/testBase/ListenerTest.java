package testBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utililty.TakeSnap;

public class ListenerTest implements ITestListener  {
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static ExtentReports extent = ExtentSetup.initExtent();
    public static ExtentTest extentTest;
    public static String timeStamp = new SimpleDateFormat("dd-MM-yyyy-HH_mm_ss").format(new Date());
    public static String screenshot;
    @Override
    public void onTestStart(ITestResult result) {
       
        String classname = result.getTestClass().getName();
        classname=classname.replace("testSauceDemo.","");
         extentTest = extent.createTest(classname)
                 .createNode(result.getMethod().getMethodName())
                 .assignAuthor(System.getProperty("user.name"));
         test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS,"Test Case: "+result.getMethod().getMethodName()+ " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
        test.get().log(Status.FAIL,"Test Case: "+result.getMethod().getMethodName()+ " is failed.");
        
        try {
            screenshot = TakeSnap.capturescreen("Test_Failed_"+timeStamp+".png");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        test.get().addScreenCaptureFromPath(screenshot);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
        test.get().log(Status.SKIP,"Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
        try {
            screenshot = TakeSnap.capturescreen("Test_Skipped_"+timeStamp+".png");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        test.get().addScreenCaptureFromPath(screenshot);
    }


    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
    
    

}
