package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//To take screenshot of every code that fails
	//TestNG Listner
	//Listner listens to test cases i.e listens if a test case is failing or passing
	
public class Listners implements ITestListener {
	/*ItestListenrs is a interface which implements TestNG listners
	 * When override methods are not loading in latest version follow this
	 * Right click(on the Listeners class ) -> go to source-> click on overide/implement methods 
	 * -> select the check boxes for the ITest listener (make sure all check box inside it should be checked )
	 * ->click on oK.
	 */
	
	//We have to tell our XML file where exactly the listenr class is located else it will never know

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		System.out.println("I successfully executed listners class code ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		//write screenshot code
		//response if api is failed
		System.out.println("I  failed listners class code ");
		//To print name of test cases that actually failed we do this
		System.out.println("I  failed listners class code" +result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}
	

}
