package com.testcases;

import org.junit.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;

public class TestJunit extends org.junit.Assert{
	
	@Test
	public void testIsoCode() {
		CodeProperties p = CodePropertiesLookup.getCodeProperties("AOA");
		System.out.println("Currency Code : " + p.getCurrencyCode());
		System.out.println("Currency Name : " + p.getCurrencyName());
		System.out.println("Fraction Digit : " + p.getFractionDigits());
		System.out.println("Symbol : " + p.getSymbol());
		System.out.println("=====================================\n");
		assertEquals("973", p.getCurrencyCode());
		assertEquals("Kwanza", p.getCurrencyName());
		assertEquals(2, p.getFractionDigits());
		assertEquals("AOA", p.getSymbol());
		
	}
	
	
	@Test
	public void testNumCode() {
		CodeProperties p = CodePropertiesLookup.getCodeProperties("952");
		assertEquals("952", p.getCurrencyCode());
		assertEquals("CFA Franc BCEAO", p.getCurrencyName());
		assertEquals(0, p.getFractionDigits());
		assertEquals("XOF", p.getSymbol());
		System.out.println("Currency Code : " + p.getCurrencyCode());
		System.out.println("Currency Name : " + p.getCurrencyName());
		System.out.println("Fraction Digit : " + p.getFractionDigits());
		System.out.println("Symbol : " + p.getSymbol());
		
	}
	
	@Test
	public void testNumCodeTwo() {
		CodeProperties p = CodePropertiesLookup.getCodeProperties("960");
		assertEquals("960", p.getCurrencyCode());
		assertEquals("SDR (Special Drawing Right)", p.getCurrencyName());
		assertEquals(-1, p.getFractionDigits());
		assertEquals("XDR", p.getSymbol());
		System.out.println("Currency Code : " + p.getCurrencyCode());
		System.out.println("Currency Name : " + p.getCurrencyName());
		System.out.println("Fraction Digit : " + p.getFractionDigits());
		System.out.println("Symbol : " + p.getSymbol());
		
	}
	

}
