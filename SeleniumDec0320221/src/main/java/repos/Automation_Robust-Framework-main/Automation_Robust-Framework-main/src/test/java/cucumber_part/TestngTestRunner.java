package cucumber_part;


	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;
	//cucumber->  TestNG, junit

	@CucumberOptions(features="src/test/java/cucumber_part",glue="cucumber_stepdefinition",
	monochrome=true, 
	 plugin= {"html:target/cucumber.html"})
	public class TestngTestRunner extends AbstractTestNGCucumberTests{

		
	}


