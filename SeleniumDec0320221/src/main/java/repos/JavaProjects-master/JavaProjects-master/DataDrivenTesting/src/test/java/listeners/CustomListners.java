package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;

public class CustomListners extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test  = repo.startTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("Test Password Customer"+result.SUCCESS);
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"- Passed");
		repo.endTest(test);
		repo.flush();
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("Test Failed"+result.FAILURE);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
