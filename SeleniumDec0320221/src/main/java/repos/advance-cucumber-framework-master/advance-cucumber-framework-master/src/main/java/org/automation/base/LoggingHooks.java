package org.automation.base;

import static org.automation.config.DriverFactory.clearCookies;
import static org.automation.config.DriverFactory.getDriver;
import static org.automation.logger.Log.error;
import static org.automation.logger.Log.info;
import static org.openqa.selenium.OutputType.BYTES;

import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;

public final class LoggingHooks implements En {

	public LoggingHooks() {
		Before((Scenario sc) -> info("Scenario [" + sc.getName() + "] execution started"));
		After(this::after);
	}

	private void after(Scenario sc) {
		clearCookies();
		if (sc.isFailed()) {
			error("Scenario [" + sc.getName() + "] " + sc.getStatus(), null);
			byte[] data = ((TakesScreenshot) getDriver()).getScreenshotAs(BYTES);
			sc.attach(data, "image/png", "Failure");
		} else {
			info("Scenario [" + sc.getName() + "] " + sc.getStatus());
		}
	}

}
