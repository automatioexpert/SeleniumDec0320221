package SeleniumSessions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitylWaitConcept {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//imp wait: 
		//dynamic wait
		//global wait -- it will be applicable only for all the web elements by default
		//can not be applied for non web elements: alerts, url, title
		
		driver.get("https://classic.crmpro.com/index.html");
		
		//login page: 10 secs
		driver.findElement(By.name("username")).sendKeys("naveen");//5 secs
		driver.findElement(By.name("password")).sendKeys("naveen123");//0 secs
		//click on login -- 0 secs
		
		//home page: 15 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//sel 4
		//driver.manage().timeouts().implicitlyWait(TimeUnit.SECONDS);//sel 3
		//e4
		//e5
		//e6
		
		//contacts page: 5 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//e7
		//e8
		
		//home page: 5 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		//click on logout
		//login page: 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//registration page:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		//0 sec: nullify of implicit wait
		//e10
		//e11
		
		//login page: 

		
		
		
	}

}
