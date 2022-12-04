package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlert {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		// driver.findElement(By.name("proceed")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		String text = alert.getText();
		System.out.println(text);

		// alert.sendKeys("testing");

		alert.accept(); // accept the alert

		// alert.dismiss();//dismiss the alert

	}

	public static Alert waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public static String getAlertText() {
		return waitForAlert().getText();
	}

	public static void aceptAlert() {
		waitForAlert().accept();
	}
	
	public static void dismissAlert() {
		waitForAlert().dismiss();
	}
	
	public static void alertSendKeys(String value) {
		waitForAlert().sendKeys(value);
	}

}
