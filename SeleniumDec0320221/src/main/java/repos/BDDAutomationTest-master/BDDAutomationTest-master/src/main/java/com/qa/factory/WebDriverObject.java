package com.qa.factory;

public class WebDriverObject {

	private static WebDriverObject driver = null;

	public WebDriverObject() {

	}

	public static WebDriverObject getDriver() {
		if (driver == null) {
			driver = new WebDriverObject();
		}
		return driver;
	}
}
