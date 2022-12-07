//package com.testcases;


import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;

//@Ignore
public class TestError{
	
	@Test()
	public void testInvalidCode() {
		try {
			CodeProperties p = CodePropertiesLookup.getCodeProperties("ABC");
			Assert.fail("Expected Was IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Ignore
	@Test
	public void testInvalidNumCode() {
		CodeProperties p = CodePropertiesLookup.getCodeProperties("124");
		
	}

	@Ignore
	@Test
	public void testNullCode() {
		CodeProperties p = CodePropertiesLookup.getCodeProperties("");
		
	}
	
	@Test()
	public void testAlfaNumerciCode() {
		try {
			CodeProperties p = CodePropertiesLookup.getCodeProperties("A1S2D3");
			Assert.fail("Expected Was IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test
	public void failTest(){
		Assert.fail("Failed By User");
	}
	@Test(timeout=100)
	public void timeTest() {
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
		}
		
	}

}
