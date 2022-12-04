package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessMode {

	public static void main(String[] args) {
		
		//no browser
		//its fast
		//testing is happening behind the scene
		//it wont block your work on the same machine
		
		//dis adv:
		//for complex apps - html DOM
		//mouse hover, move to element, 
		//alert/ pop ups/ 

		WebDriverManager.chromedriver().setup();

		ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
		co.addArguments("--incognito");

		WebDriver driver = new ChromeDriver(co);

//		FirefoxOptions fo = new FirefoxOptions();
//		fo.addArguments("--headless");
//
//		WebDriver driver = new FirefoxDriver(fo);

		driver.get("https://google.com");// 2. launch url

		String title = driver.getTitle();// 3. get the title of the page
		System.out.println(title);

		// Verification point/checkpoint/act vs exp result:
		if (title.equals("Google")) {
			System.out.println("correct title");
		} else {
			System.out.println("incorrect title");
		}

		System.out.println(driver.getCurrentUrl());

		// System.out.println(driver.getPageSource());

		// close the browser:
		driver.quit();

	}

}
