package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="classpath:features/cscart",
		glue="cscart.stepdefs",
		plugin = {"pretty",
				"html:target/cucumber1",
				"json:target/cucumber1.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "@wip",
		dryRun = false
		
		)
public class RunCSCartTest {

}
