package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlertConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		// 1. ImplictlylWait: global wait
		// 2. Explicit Wait: for a specific element, custom wait, non web elements
		// (alerts, url, title)
		// a. WebDriverWait
		// b. FluentWait

		// WebDriverWait(C) extends FluentWait(C) implements Wait (Interface) - until();

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.name("proceed")).click();

	}

	public static Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}

	public static void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}

	public static String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}

}
