package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	// when ever a test is failed this method retry will be called. 
	// if this method return true, the failed method will be return
	
	int counter = 0;
	int retryLimint = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (counter < retryLimint) {
			System.out.println("Retrying " + result.getName() + " again and the count is " + (counter+1));
			counter++;
			return true;
		}
		return false;
	}

}
