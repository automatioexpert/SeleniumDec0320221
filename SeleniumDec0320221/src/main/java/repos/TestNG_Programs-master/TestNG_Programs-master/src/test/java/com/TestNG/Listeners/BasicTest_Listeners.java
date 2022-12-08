package com.TestNG.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class BasicTest_Listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " Test started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " Test Succefully executed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " Test failed");
	}

}
