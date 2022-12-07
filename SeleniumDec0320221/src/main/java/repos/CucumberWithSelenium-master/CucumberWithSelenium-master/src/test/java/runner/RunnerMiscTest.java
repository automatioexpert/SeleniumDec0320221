package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="classpath:features/Misc",
		glue="misc",
		plugin = {"pretty",
				"html:target/cucumber2",
				"json:target/cucumber2.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "",
		dryRun = false
		
		)
public class RunnerMiscTest {

}
