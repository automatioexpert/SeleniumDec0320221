package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessIncognito {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		//headless:
		//no browser is displayed
		//testing is fast
		
		ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
		//co.setHeadless(true);
		//co.addArguments("--incognito");
		
		FirefoxOptions fo = new FirefoxOptions();
		fo.setHeadless(true);
		
		WebDriver driver = new FirefoxDriver(fo);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
		
		
		
		
		
	}

}
