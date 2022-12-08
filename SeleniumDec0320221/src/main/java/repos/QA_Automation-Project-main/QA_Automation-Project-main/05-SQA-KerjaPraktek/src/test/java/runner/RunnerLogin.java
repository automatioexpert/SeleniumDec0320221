package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/LoginFeatureFiles",
glue = "definitionLogin",
plugin={
	"pretty",
	"html:target/cucumber-reports",
	"json:target/cucumber-reports/LoginTest.json"
})
public class RunnerLogin extends AbstractTestNGCucumberTests {

}