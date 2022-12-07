package com.testcases;

import junit.framework.TestResult;
import junit.framework.TestSuite;

public class TestStandAloneSuite {

	
	public static void main(String[] args) {
		TestSuite suite = new TestSuite("StandAlone Suite");
		TestResult result = new TestResult();
		suite.addTestSuite(TestMyClass.class);
		suite.addTestSuite(TestFailure.class);
		suite.run(result);
		System.out.println("Run Count : " + result.runCount());
		System.out.println("Failure Count : " + result.failureCount());
		System.out.println("Error Count : " + result.errorCount());

	}

}
