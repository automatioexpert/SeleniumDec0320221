package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/DataFeatureFiles",
glue = "definitionData",
plugin={
	"pretty",
	"html:target/cucumber-reports",
	"json:target/cucumber-reports/DataTest.json"
})
public class RunnerData extends AbstractTestNGCucumberTests {

}