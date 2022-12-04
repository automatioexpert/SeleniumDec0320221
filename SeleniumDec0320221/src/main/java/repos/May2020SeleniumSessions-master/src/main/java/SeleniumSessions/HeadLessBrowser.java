package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser {

	public static void main(String[] args) {
		
		String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";

		// headleass : no browser
		// testing is happening behind the scene
		// fast? yes
		// headed mode - with browser
		
		//HTMLUNITDriver
		//GhostDriver
		//PhantomJS

		//WebDriverManager.chromedriver().setup();
		
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless");
//
//		WebDriver driver = new ChromeDriver(co);// launch browser
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--headless");
		WebDriver driver = new FirefoxDriver(fo);

		driver.get("http://www.amazon.com");// enter url

		String actualTitle = driver.getTitle();// get the page title
		System.out.println("page title is: " + actualTitle);

		// verification point: checkpoint: expected vs actual result :
		// Assertions
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("correct title");
		} else {
			System.out.println("incorrect title");
		}

		String url = driver.getCurrentUrl();
		System.out.println(url);

		if (url.contains("amazon")) {
			System.out.println("correct url");
		}
		
		driver.quit();

	}

}
