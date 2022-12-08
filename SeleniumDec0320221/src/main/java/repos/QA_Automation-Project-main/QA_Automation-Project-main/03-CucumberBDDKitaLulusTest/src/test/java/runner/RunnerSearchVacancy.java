package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/featureSearchVacancy",
glue = "definition.SearchVacancy",
plugin={
	"pretty",
	"html:target/cucumber-reports",
	"json:target/cucumber-reports/SearchVacancyTest.json"
})
public class RunnerSearchVacancy extends AbstractTestNGCucumberTests {

}
