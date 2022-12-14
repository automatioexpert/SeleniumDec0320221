package org.automation.logger;

import static org.automation.logger.LogConfig.getLogger;

/**
 * Log class to provide logging capabilities.
 * 
 * @author Sujay Sawant
 * @version 1.0.0
 * @since 06/11/2020
 *
 */
public final class Log {
	
	private Log() { }

	/**
	 * Provides the information logs.
	 * 
	 * @param message information message
	 */
	public static void info(String message) {
		getLogger().info(message);
	}

	/**
	 * Provides the error logs.
	 * 
	 * @param message error message
	 * @param error   the exception to log, including its stack trace
	 */
	public static void error(String message, Throwable error) {
		getLogger().error(message, error);
	}

	/**
	 * Provides the warning logs.
	 * 
	 * @param message warning message
	 */
	public static void warn(String message) {
		getLogger().warn(message);
	}

	/**
	 * Provides the debug logs.
	 * 
	 * @param message debug message
	 */
	public static void debug(String message) {
		getLogger().debug(message);
	}

	/**
	 * Provides the fatal logs.
	 * 
	 * @param message fatal messages
	 * @param error   the exception to log, including its stack trace
	 */
	public static void fatal(String message, Throwable error) {
		getLogger().fatal(message, error);
	}

}
