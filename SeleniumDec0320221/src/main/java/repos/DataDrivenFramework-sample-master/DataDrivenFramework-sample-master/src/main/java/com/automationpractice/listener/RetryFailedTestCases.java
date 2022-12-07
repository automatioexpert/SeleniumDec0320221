package com.automationpractice.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {

	private int retryCount = 0;
	// If there are any failed test cases, then it runs 2 times
	private int maxRetryCount = 1;
	
	@Override
	public boolean retry(ITestResult arg0) {
		if(retryCount < maxRetryCount) {
			System.out.println("Retrying the failed test cases.");
			retryCount++;
			return true;
		}
		return false;
	}

}
