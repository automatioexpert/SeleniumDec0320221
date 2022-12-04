package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForUrlConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailid = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");

		waitForElementToBeVisible(emailid, 10).sendKeys("naveenanimation20@gmail.com");
		getElement(password).sendKeys("Selenium12345");
		getElement(loginBtn).click();

		String url = waitForUrl(5, "route=account/account");
		String title = waitForTitleContains(5, "My Account");
		System.out.println(title);
	}

	public static String waitForTitleContains(int timeOut, String titleFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
		} else {
			System.out.println("title is not correct.....");
			return null;
		}
	}

	public static String waitForTitleIs(int timeOut, String titleVal) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleIs(titleVal))) {
			return driver.getTitle();
		} else {
			System.out.println("title is not correct.....");
			return null;
		}
	}

	public static String waitForUrl(int timeOut, String urlFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
		return null;
	}

	public static String waitForUrlToBe(int timeOut, String urlVal) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlToBe(urlVal))) {
			return driver.getCurrentUrl();
		}
		return null;
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static WebElement waitForElementToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));// sel 4.x
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
