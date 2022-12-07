package Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {
    public static AppiumDriver driver;

    private void androidSetupAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
//      capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("deviceName", "Pixel 3XL");
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("app", System.getProperty("user.dir") + "/app/app-debug.apk");
        capabilities.setCapability("appPackage", "community.farmer.caribfarm");
        capabilities.setCapability("appActivity", "community.farmer.caribfarm.MainActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    /**
     * In case it shows NullPointerException or driver is null,
     * then call the androidSetup.setDriver manually from stepDefinitions Constructors
     */

    @Before("")
    public void setDriver() throws MalformedURLException {
        androidSetupAppium();
    }

    public AndroidDriver getDriver() {
        return (AndroidDriver) driver;
    }

    @After("")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

