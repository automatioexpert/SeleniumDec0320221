package Files.TestNG.Dropbox;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignUpWithGoogle {

	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void LaunchDropbox(String browser) {
		System.out.println("Browser Name is :" + browser);
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get("https://www.dropbox.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Parameters("expectedTitle")
	@AfterTest
	public void getTestResult(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Parameters({ "username", "password" })
	@Test
	public void SignupDetails(String username, String password) {
		driver.findElement(By.xpath("//span[@class='sign-up-text']")).click();

		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();

		for (String child : allWindow) {
			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				driver.manage().window().maximize();
			}
		}

		// Wait for the element to be Located
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifierId\"]")));
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(username);
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

		// Wait for the element to be Located
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Allow')]")).click();

		// When you sign up for the very first time use the below two commands, from
		// next time run comment these two
		// driver.findElement(By.name("tos_agree")).click();
		// driver.findElement(By.xpath("//button[@type='submit']")).click();
		// driver.close();
	}

}
