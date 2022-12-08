/**
 * 
 */
package com.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author anand acharya
 * To auto re-run a failed test 
 */
public class RetryFailedTest implements IRetryAnalyzer {

	private int retryCnt = 0;
    //If any failed testcases then it re-run max 2 times
    private int maxRetryCnt = 2;
    
    //This method will be called every time a test fails. It will return TRUE if a test fails and need to be retried, else it returns FALSE
    public boolean retry(ITestResult result) {
        if (retryCnt < maxRetryCnt) {
            System.out.println("Retrying " + result.getName() + " again and the count is " + (retryCnt+1));
            retryCnt++;
            return true;
        }
        return false;
    }
}
