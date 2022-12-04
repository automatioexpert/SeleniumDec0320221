package SeleniumSessions;

import java.net.URL;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverCastings {

	public static void main(String[] args) {

		//1. WD - CD -- local
		//WebDriver driver = new ChromeDriver();

		//2. ChromeDriver driver = new ChromeDriver();
		
		//3. RWD - CD - local
//		RemoteWebDriver driver = new ChromeDriver();
//		driver = new FirefoxDriver();
//		driver = new SafariDriver();
		
		//4. WD - RWD - remote machine/server/vm/docker/cloud/cloud vendor
		//WebDriver driver = new RemoteWebDriver(new URL("192.45.1.10:4444"), capabilities);
		
		//5. SC - CD:
		//SearchContext driver = new ChromeDriver();
		
		//6. SC - RWD:
		//SearchContext driver = new RemoteWebDriver(new URL("192.45.1.10:4444"), capabilities);
	}

}
