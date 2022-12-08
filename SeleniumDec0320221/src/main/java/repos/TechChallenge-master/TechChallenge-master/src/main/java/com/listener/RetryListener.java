/**
 * 
 */
package com.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/**
 * @author anand acharya
 * Listener to re-run to failed test case
 */
public class RetryListener implements IAnnotationTransformer  {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		 IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		 
		 if (retry == null) {
		 annotation.setRetryAnalyzer(RetryFailedTest.class);
		 }
		
	}
}
