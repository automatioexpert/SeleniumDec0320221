package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures/Order.feature"},
		glue = {"stepdefinitions", "AppHooks"},
		plugin = {"pretty"}
		
		)

public class OrderTest {

}
