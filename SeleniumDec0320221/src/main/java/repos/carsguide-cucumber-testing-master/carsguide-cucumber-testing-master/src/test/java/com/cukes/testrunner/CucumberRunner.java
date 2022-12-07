package com.cukes.testrunner;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features 	= { "src/test/resources/features" }, 
	glue 		= { "com.cukes.stepdefinitions.ui", "org.automation.base" }, 
	tags 		= "@CarsGuide", 
	dryRun 		= false, 
	monochrome 	= true, 
	snippets 	= CAMELCASE, 
	plugin 		= { "pretty:target/cucumber.log", 
					"html:target/cucumber.html", 
					"json:target/cucumber.json", 
					"junit:target/cucumber.xml", 
					"org.automation.base.DriverHandler", 
					"de.monochromata.cucumber.report.PrettyReports:target" }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
