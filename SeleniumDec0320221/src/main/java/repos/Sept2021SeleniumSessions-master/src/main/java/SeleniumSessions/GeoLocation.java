package SeleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.emulation.Emulation;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocation {

	public static void main(String[] args) throws MalformedURLException {
		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		DevTools devTools = ((ChromeDriver)driver).getDevTools();
//		devTools.createSession();
//		devTools.send(Emulation.setGeolocationOverride(Optional.of(25.204849),
//		                Optional.of(-55.270782),
//		                Optional.of(1)));
//		driver.get("https://my-location.org/");
		
		ChromeOptions options = new ChromeOptions();
		options.setBrowserVersion("94");
		options.setPlatformName("Mac OS X");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

	}

}
