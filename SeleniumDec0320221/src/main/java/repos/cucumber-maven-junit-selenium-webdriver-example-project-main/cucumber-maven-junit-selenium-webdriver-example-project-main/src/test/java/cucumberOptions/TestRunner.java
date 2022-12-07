package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinations", stepNotifications = true, tags="@GreenKartUITest or @GreenKartFunctionalTest or @GreenKartSearchTest",
		plugin = {"html:target/cucumber.html", "json:target/cucmber.json", "junit:target/cukes.xml"}
		)

public class TestRunner {

}
