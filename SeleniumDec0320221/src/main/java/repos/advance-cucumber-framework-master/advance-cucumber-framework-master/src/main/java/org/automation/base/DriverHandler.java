package org.automation.base;

import static org.automation.config.DriverFactory.closeDriverObjects;
import static org.automation.config.DriverFactory.instantiateDriverObject;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.Plugin;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;

public final class DriverHandler implements Plugin, ConcurrentEventListener {

	@Override
	public void setEventPublisher(EventPublisher event) {
		event.registerHandlerFor(TestRunStarted.class, e -> instantiateDriverObject());
		event.registerHandlerFor(TestRunFinished.class, e -> closeDriverObjects());
	}

}
