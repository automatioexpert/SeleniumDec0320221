package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefExceptionConcept {

	// Page -- DOM -- v1
	// E1 -- v1
	// refresh
	// Page -- DOM -- v2
	// E1.click --?

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailid = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
		WebElement login_ele = driver.findElement(emailid);//DOM v1
		login_ele.sendKeys("tom@gmail.com");//DOM v1
		Thread.sleep(4000);
		driver.navigate().refresh();
		//DOM -- v2
		login_ele = driver.findElement(emailid);//DOM v2
		login_ele.sendKeys("Anu@gmail.com");		
		
	}

}
