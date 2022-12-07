package com.logs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

public final class JSErrorLogs {	

	public JSErrorLogs (){}
	
	    public static LogEntries getLogs(WebDriver driver) {
	        return driver.manage().logs().get(LogType.BROWSER);
	    }

	    public static Boolean isLoginErrorLog(WebDriver driver) {
	        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	        return logEntries.getAll().stream()
	            .anyMatch(logEntry -> logEntry.getMessage().contains("An invalid email address was specified"));
	    }
}
