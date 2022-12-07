package allocator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.core.api.Scenario;

public class WebConnector<V> {

	public static WebDriver driver=null;
	public static Properties prop = new Properties();
	ReusableMethods RM= new ReusableMethods();

	public WebConnector(){
		try {
			prop.load( new FileInputStream("./src/test/config/Application.properties") );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setUpDriver() throws Exception{
		String browser = prop.getProperty("browser");
		if (browser == null) {
			browser = "chrome";
		}
		switch (browser) {
        case "chrome":
        	System.setProperty("webdriver.chrome.driver","./src/test/lib/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("--disable-notifications");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(prop.getProperty("AppURL"));
           ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            break;
        case "firefox":
        	System.setProperty("webdriver.gecko.driver","./src/test/lib/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
             //session = ((FirefoxDriver)driver).getSessionId();
            break;
        default:
            throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
    }
}

public void closeDriver(Scenario scenario){
    if(scenario.isFailed()){
      // saveScreenshotsForScenario(scenario);
    }
    driver.close();
}}
