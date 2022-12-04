package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) throws InterruptedException {

		// Thread.sleep(5000);//static wait

		// dynamic waits:
		// 1. Implictly wait : global wait, and applied for webelements only...
		// 2. Explicit Wait
		// 2.a: WebDriverWait
		// 2.b: FluentWait

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://app.hubspot.com/login");
		//System.out.println(driver.getTitle());
		
		driver.findElement(By.id("username")).sendKeys("testnaveen");//15
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("password")).sendKeys("testnaveen");//5
		driver.findElement(By.id("loginBtn")).click();//5
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitly wait
		//e4
		//e5
		//e6
		
		
		
		

	}

}
