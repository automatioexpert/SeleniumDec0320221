package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementDisplayed {
	static WebDriver driver;

	public static void main(String arg[]) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/register");

//		boolean flag1 = driver.findElement(By.id("input-firstname")).isDisplayed();
//		boolean flag2 = driver.findElement(By.linkText("Login")).isDisplayed();
//
//		System.out.println(flag1);
//		System.out.println(flag2);

		By firstName = By.id("input-firstname");
		By loginLink = By.linkText("Login");
		System.out.println(doIsDisplayed(firstName));

		// checkpoint:
		if (doIsDisplayed(loginLink)) {
			doClick(loginLink);
		} else {
			System.out.println("Login link is not displayed....");
		}
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}

	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public static boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

}
