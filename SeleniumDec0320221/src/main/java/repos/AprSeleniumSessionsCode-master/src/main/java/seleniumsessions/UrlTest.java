package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UrlTest {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/#display-grid");

		ElementUtil el = new ElementUtil(driver);
		String url = el.waitForUrl(10, "naveen");
		
		System.out.println(url);
	}

}
