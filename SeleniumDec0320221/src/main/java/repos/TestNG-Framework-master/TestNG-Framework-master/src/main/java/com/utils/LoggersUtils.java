package com.utils;

import org.apache.log4j.PropertyConfigurator;
import org.testng.log4testng.Logger;

public class LoggersUtils {

	private static LoggersUtils loggersUtils;
	private static Logger log;

	public LoggersUtils() {
		if (loggersUtils != null) {
			throw new RuntimeException("Use getInstance() method to create the object.");
		}
	}

	public LoggersUtils(Class<?> className) {
		setLog(Logger.getLogger(className));
		PropertyConfigurator.configure("./src/test/resources/log4j.properties");
	}

	public static LoggersUtils getInstance(Class<?> className) {

		if (loggersUtils == null) {
			synchronized (LoggersUtils.class) {
				if (loggersUtils == null)
					loggersUtils = new LoggersUtils(className);
			}
		}
		return loggersUtils;
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		LoggersUtils.log = log;
	}

}
