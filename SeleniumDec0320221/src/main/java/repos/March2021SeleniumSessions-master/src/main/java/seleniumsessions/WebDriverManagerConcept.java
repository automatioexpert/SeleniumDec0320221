package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {

//		WebDriverManager.chromedriver().setup();
//		
//		WebDriver driver = new ChromeDriver();//1.launch the browser
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://google.com");//2. launch url
		
		String title = driver.getTitle();//3. get the title of the page
		System.out.println(title);
		
		driver.quit();
		
		
		
		
	}

}
