package com.cucumber.stepdefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void beforeExecution(Scenario sc) {
		System.out.println(sc.getName());
	}

	@After
	public void afterExecutoin(Scenario sc) {
		System.out.println(sc.getStatus());
	}
}
