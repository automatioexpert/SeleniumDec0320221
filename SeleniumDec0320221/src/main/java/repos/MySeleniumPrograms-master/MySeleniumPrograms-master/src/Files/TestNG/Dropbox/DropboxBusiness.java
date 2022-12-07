package Files.TestNG.Dropbox;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DropboxBusiness {

	WebDriver driver;

	@Parameters({ "browser", "URL" })
	@Test(priority = 0)
	public void Launch_Browser(String browser, String URL) {
		System.out.println("Running Browser Name is :" + browser);
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Parameters({ "UserName", "Password" })
	@Test(priority = 1)
	public void DropboxTabs(String UserName, String Password) {
		// Open the Tab "Solutions" from the dropdown "Learn more"
		driver.findElement(By.xpath("//a[@id='try-dfb']")).click();
		driver.findElement(By.xpath("//a[@class='dropdown__link'][contains(text(),'Learn more')]")).click();
		driver.findElement(By.xpath("//a[@class='dropdown__content-link'][contains(text(),'Solutions')]")).click();

		// Go Back to Home Page
		driver.findElement(By.xpath("//img[@class='arbor-logo__glyph']")).click();

		// Scroll the page down
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("window.scrollBy(0,3000)");

		// Privacy and Terms
		driver.findElement(By.xpath("//a[contains(text(),'Privacy & terms')]")).click();

		// Scroll the page down
		JS.executeScript("window.scrollBy(0,3000)");
		driver.navigate().back();

		// Scroll the page up
		JS.executeScript("window.scrollBy(0,-5000)");

		// driver.close();

	}

}
