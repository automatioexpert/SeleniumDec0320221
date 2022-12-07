package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"@ target/failedrerun.txt"},
		monochrome = true,
		glue = {"stepdefinitions", "hooks"},
		
		plugin = {"pretty",
				"rerun: target/failedrerun.txt"
		}
		)


public class RerunFailedTC {

}
