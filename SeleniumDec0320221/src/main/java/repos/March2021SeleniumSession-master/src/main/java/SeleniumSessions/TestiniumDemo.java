package SeleniumSessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestiniumDemo {
	
	public static final String USERNAME = "naveenanimation";
    public static final String ACCESS_KEY = "331f33702b0dde9a1b1b5c74523e8575";
    public static final String KEY = USERNAME + ":" + ACCESS_KEY;
    public static final String URL = "http://hub.testinium.io/wd/hub";

    public static void main(String[] args) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("key", KEY);

        capabilities.setCapability(CapabilityType.PLATFORM, "WIN10");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        capabilities.setCapability(CapabilityType.VERSION, "86");
        capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        capabilities.setCapability("recordsVideo", true);
        capabilities.setCapability("screenResolution", "SXGA");
        
        WebDriver driver = new RemoteWebDriver(new URL(URL), capabilities);
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
