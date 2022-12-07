package hooks;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private ConfigReader configReader;
	Properties prop;
	private WebDriver driver;

	@Before(value = "@skipScenarioViaHook", order = 0)
	public void skipScenario(Scenario scenario) {
		System.out.println("Skipped Scenario is "+scenario.getName());
		Assume.assumeTrue(false);
	}
	
	@Before(order=1)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_Prop();
	}
	
	@Before(order=2)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		String siteURL = prop.getProperty("url");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		driver.get(siteURL);
	}
		
	@After(order = 0)
	public void closeBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		//Take screenshot
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ","_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
		
	}

}
