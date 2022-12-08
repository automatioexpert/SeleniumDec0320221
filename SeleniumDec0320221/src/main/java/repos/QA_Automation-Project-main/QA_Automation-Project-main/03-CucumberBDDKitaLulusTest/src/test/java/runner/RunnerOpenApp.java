package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/featureOpenApp",
glue = "definition.OpenApp",
plugin={
	"pretty",
	"html:target/cucumber-reports",
	"json:target/cucumber-reports/OpenAppTest.json"
})
public class RunnerOpenApp extends AbstractTestNGCucumberTests {

}
