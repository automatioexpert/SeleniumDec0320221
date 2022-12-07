package Files.TestNG.Dropbox;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateFolder {

	WebDriver driver;

	@Parameters({ "browser", "url" })
	@Test(priority = 0)
	public void DropboxLogin(String browser, String url) {
		System.out.println("Running Browser Name is :" + browser);
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Parameters({ "UserName", "Password" })
	@Test(priority = 1)
	public void CreateAFolder(String UserName, String Password) throws InterruptedException {
		driver.findElement(By.name("login_email")).sendKeys(UserName);
		driver.findElement(By.name("login_password")).sendKeys(Password);
		driver.findElement(By.name("remember_me")).click();
		driver.findElement(By.className("signin-text")).click();

		// Wait for the page to load in DOM
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[contains(text(),'Files')]")).click();
		driver.findElement(
				By.xpath("//div[@class='ue-effect-container uee-AppActionsView-SecondaryActionMenu-text-new-folder']"))
				.click();
		WebElement element = driver.findElement(
				By.xpath("//div[@class='ue-effect-container uee-AppActionsView-SecondaryActionMenu-text-new-folder']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys("Dropbox-Test");
		actions.click();
		actions.build().perform();
		driver.findElement(By.xpath(
				"//label[@class='brws-checkbox brws-checkbox-checked mc-checkbox mc-checkbox-checked']//*[@class='mc-checkbox-checked-icon']"))
				.click();

		// driver.close();
	}
}
