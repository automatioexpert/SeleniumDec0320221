package Com.QATechTesting.Zalenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ExecuteTestZalenium2 {
	
	@Test
	public void test1() throws MalformedURLException, InterruptedException
	{
		System.out.println(Thread.currentThread().getId());
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), cap);
		driver.get("http://www.facebook.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
