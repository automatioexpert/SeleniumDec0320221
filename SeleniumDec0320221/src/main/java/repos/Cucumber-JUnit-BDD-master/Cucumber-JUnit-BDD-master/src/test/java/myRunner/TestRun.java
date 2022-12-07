package myRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features//Customer.feature", 
		glue = "stepDefinitions",
		dryRun=false,
		monochrome = true, 
		plugin = { "pretty", "html:target/cucumber-HTML_report",
				             "junit:target/cucumber.xml",
				             "json:target/cucumber.json",	
				             }
		/*plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/report.html"}
		*/
		)
public class TestRun {

	@AfterClass
	public static void setup() {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"./extent-config.xml"));
        //Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
		Reporter.setSystemInfo("User Name", "AJ");
		Reporter.setSystemInfo("Application Name", "Test App ");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Environment", "Production");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
		
		Reporter.setSystemInfo("Selenium", "3.7.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}

//https://rlogiacco.gethub.io/Natural/