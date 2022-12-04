package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForPageLoad {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://api.cogmento.com/register/");
		driver.findElement(By.partialLinkText("Log in here")).click();
		JavaScriptUtil js = new JavaScriptUtil(driver);
		js.waitForPageLoaded();
		driver.findElement(By.name("email")).sendKeys("testing");
	}

}
