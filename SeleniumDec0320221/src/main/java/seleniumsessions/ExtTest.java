package seleniumsessions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtTest {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("/Users/naveenautomationlabs/Downloads/loopjjegnlccnhgfehekecpanpmielcj.crx"));
		options.addArguments("--headless=chrome");
		//options.setHeadless(true);
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		driver.get("chrome-extension://loopjjegnlccnhgfehekecpanpmielcj/testCaseStudio/studioWindow.html");
		driver.findElements(By.cssSelector("table#command-grid th")).stream().forEach(e -> System.out.println(e.getText()));
		
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("http://www.google.com");
//		driver.findElement(By.name("q")).sendKeys("naveen automation");
//		driver.findElement(By.name("btnK")).click();
		
		//driver.quit();

		
	}

}
