package com.TestNG.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LinkedInTest_Listeners implements ITestListener{
	//When any method start
	public void onStart(ITestContext context) {
		System.out.println("On start method invoked...");
	}
	
	//when test case get started, this method will call
	public void onTestStart(ITestResult result) {
		System.out.println("Name of the test method started: " + result.getName() );
	}
	
	//When test case failed
	public void onTestFailure(ITestResult result) { 
		System.out.println("Name of the method failed: " + result.getName());  //by result parameter, it will get failed test method
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of the method skipped: " + result.getName()); 
	}
	
	//when test case got successfully executed
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of the test method succesfully execute: " + result.getName() );
	}

	public void onFinish(ITestContext context) {
		System.out.println("On finished methods..");
	}
	
	
}
