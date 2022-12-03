package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {

		//dynamic wait:
		//imp wait: global wait: will be applied for all the elements on the page
		//its only applicable for webelements
		//not applicable for non webelements: alerts, url, title
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//sel 3.x
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//sel 4.x
		//global time out = 10 secs
		
		//home page: 10
		WebElement mac = driver.findElement(By.linkText("MacBook"));//2 secs
		
		mac.click();
		
		//2nd page: 10 secs
		//e2 
		//e3
		//e4 - click
		//logout ---> Login Page
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//sel 4.x

		//3rd page: 20 secs 
		//e5 e6 e7 - click
		
		//home page: 10
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//sel 4.x

		//register page: 5
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//sel 4.x

		//home page: 5
		
		//forgotpwd : 0 --nullify imp wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));//sel 4.x
		
	}

}
