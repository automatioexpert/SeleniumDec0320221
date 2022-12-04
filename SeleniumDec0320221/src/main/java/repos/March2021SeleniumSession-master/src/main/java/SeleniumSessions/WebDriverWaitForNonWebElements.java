package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitForNonWebElements {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.name("proceed")).click();

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//
//		System.out.println(alert.getText());
//		alert.accept();
		
		alertGetText(5);
	}

	private static Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}

	public static void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}

	public static String alertGetText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}

	public static void alertSendKeys(int timeOut, String value) {
		waitForAlert(timeOut).sendKeys(value);
	}

}
