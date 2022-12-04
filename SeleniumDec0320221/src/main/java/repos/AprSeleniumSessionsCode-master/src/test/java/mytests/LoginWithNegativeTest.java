package mytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithNegativeTest {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}
	
	
	@DataProvider
	public Object[][] getLoginNegativeData() {
		
		return new Object[][] {
			
			{"test1112121@gmail.com", "test12333"},
			{"naveenanimation20@gmail.com", "test12333"},
			{"test1112121@gmail.com", "Selenium@12345"},
			{"    ", "Selenium@12345"},
			{"testttttt@gmail.com", "    "}
			
		};
		
	}
	
	

	@Test(dataProvider = "getLoginNegativeData")
	public void loginTestWithNegativeData(String username, String password) {

		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(username);
		
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String errorMesg = driver.findElement(By.cssSelector("div.alert-dismissible")).getText().trim();
		System.out.println(errorMesg);
		Assert.assertEquals(errorMesg, "Warning: No match for E-Mail Address and/or Password.");
		
		
	}

}
