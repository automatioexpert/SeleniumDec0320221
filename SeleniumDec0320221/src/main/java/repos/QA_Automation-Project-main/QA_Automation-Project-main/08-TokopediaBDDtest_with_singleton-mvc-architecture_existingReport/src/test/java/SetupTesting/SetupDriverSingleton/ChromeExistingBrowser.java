package SetupTesting.SetupDriverSingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeExistingBrowser implements DriverStrategyInterface {

	public WebDriver setStrategy() {
		/*
		 * Navigate to chrome directory using the cd command In my case chrome.exe is
		 * under C:\Program Files (x86)\Google\Chrome\Application
		 *  ==> cd C:\Program Files (x86)\Google\Chrome\Application
		 * 
		 * Syntax chrome.exe –remote-debugging-port=any-free-port
		 * –user-data-dir=directory (path where you need to store data)
		 * 
		 * Example in my case
		 * 	==> chrome.exe --remote-debugging-port=9222 --user-data-dir=C:\chromeData
		 */
		
		String path = System.getenv("WEBDRIVER");
		System.setProperty("webdriver.chrome.driver", path);
		// Create object of ChromeOptions Class
		ChromeOptions opt = new ChromeOptions();

		// pass the debuggerAddress and pass the port along with host. Since I am
		// running test on local so using localhost
		opt.setExperimentalOption("debuggerAddress", "localhost:9222 ");

		// pass ChromeOptions object to ChromeDriver constructor
		WebDriver driver = new ChromeDriver(opt);
		return driver;
	}
}
