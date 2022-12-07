/**
 * 
 */
package com.xls.report.config;

/**
 * @author - rahul.rathore
 * @date - 02-Aug-2015
 * @project - ExcelReportGenerator
 * @package - com.xls.report.config
 * @file name - ElementLocator.java
 */
public class ElementLocator {
	private String method = "";
	
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	public String getSelector() {
		return selector;
	}
	
	public void setSelector(String selector) {
		this.selector = selector;
	}
	
	private String selector = "";
	
	@Override
	public String toString() {
		return method + " = " + selector;
	}
	

}
