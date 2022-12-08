package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/featureBookmark",
glue = "definition.Bookmark",
plugin={
	"pretty",
	"html:target/cucumber-reports",
	"json:target/cucumber-reports/BookmarkTest.json"
})
public class RunnerBookmark extends AbstractTestNGCucumberTests {

}
