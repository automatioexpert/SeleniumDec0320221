package com.cucumber.myrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)

	@CucumberOptions(features = "C:/Users/krishna/eclipse-workspace/Selenium-BDD-Framework/src/main/java/com/cucumber/features", glue = {
		"com.cucumber.stepdefinition" }, dryRun = false)

public class TestRunner {

}
