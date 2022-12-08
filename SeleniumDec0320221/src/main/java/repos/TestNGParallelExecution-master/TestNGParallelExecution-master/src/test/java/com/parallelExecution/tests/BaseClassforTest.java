package com.parallelExecution.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.parallelExecution.base.BaseClass;

public abstract class BaseClassforTest extends BaseClass {

	abstract public void beforeClass();

	abstract public void afterClass();
	/*
	 * @BeforeSuite public void setUp() { System.out.println("In Before suite " +
	 * Thread.currentThread().getId()); }
	 * 
	 * @AfterSuite public void tearDown() { System.out.println("In After Suite " +
	 * Thread.currentThread().getId()); }
	 */

}
