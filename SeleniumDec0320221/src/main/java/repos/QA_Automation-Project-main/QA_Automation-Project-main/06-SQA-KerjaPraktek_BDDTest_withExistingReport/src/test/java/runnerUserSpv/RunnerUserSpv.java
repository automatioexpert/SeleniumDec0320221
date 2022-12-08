package runnerUserSpv;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/UserSpvFeatureFiles",
glue = "userSpvStepdefs",
plugin={
	"pretty",
	"html:target/cucumber-reports",
	"json:target/cucumber-reports/UserSpvTest.json"
})
public class RunnerUserSpv extends AbstractTestNGCucumberTests {

}