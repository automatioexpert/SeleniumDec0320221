/**
 * 
 */
package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author anand acharya
 * we will write in JUnit to test the features
 */

@RunWith(Cucumber.class)
@CucumberOptions(
			//features = "D:\\Selemuinn\\FreeCrmBDDFramework\\src\\main\\java\\features\\Login.Feature", //the path of the feature file
			features = "D:\\Selemuinn\\FreeCrmBDDFramework\\src\\main\\java\\features\\Contacts.Feature", //the path of the feature file
			//features = "D:\\Selemuinn\\FreeCrmBDDFramework\\src\\main\\java\\features\\Deals.Feature", //the path of the feature file
			//features = "D:\\Selemuinn\\FreeCrmBDDFramework\\src\\main\\java\\features\\DealsMap.Feature", //the path of the feature file
			//features = "D:\\Selemuinn\\FreeCrmBDDFramework\\src\\main\\java\\features\\Tagging.Feature", //the path of the feature file
			//features = "D:\\Selemuinn\\FreeCrmBDDFramework\\src\\main\\java\\features\\TaggedHooks.Feature", //the path of the feature file
			glue = {"stepDefinitions"}, //the path of the step definition files
			plugin = {"pretty","html:test-output", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reports
			monochrome = true, //display the console output in proper readable format
			strict = true, //it will check if any step is not defined in the step definition file 
			dryRun=false //to check if mapping is proper between feature file and step definition file
			//tags = {"@SmokeTest","@RegressionTest"}
		)

public class TestRunner {
	
}

//ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all test tagged as @SmokeTest OR @RegressionTest
//ANDed : tags = {"@SmokeTest","@RegressionTest"} -- execute all test tagged as @SmokeTest AND @RegressionTest
