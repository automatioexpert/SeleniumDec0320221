package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import utililty.ReadProperties;

public class testBase extends ListenerTest {
	
	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	
	
	@BeforeClass
    public void Setup() throws Exception{
		WebDriver webdriver = BrowserSetup.initDriver();
		threadLocalDriver.set(webdriver);
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		getDriver().get(ReadProperties.getData("saucedemo"));
	}
	 //get thread-safe driver
    public static WebDriver getDriver(){
        
        return threadLocalDriver.get();
    }

    @AfterClass
    public void tearDown()
    {
    	getDriver().quit();
    	threadLocalDriver.remove();
    }
}
