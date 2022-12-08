package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	static AppiumDriver<MobileElement> driver;

	
	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		// device data

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ASUS_Z01QD");
		cap.setCapability(MobileCapabilityType.UDID, "127.0.0.1:21503");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");

		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		
		// App data
		cap.setCapability("appPackage", "com.tokopedia.tkpd");
		cap.setCapability("appActivity", "com.tokopedia.navigation.presentation.activity.MainParentActivity");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);


	}
	
	@AfterSuite
	public void afterTest() {
//		driver.close();
//		driver.quit();
	}

}
