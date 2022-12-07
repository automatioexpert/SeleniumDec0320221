package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


// headless testing of the web applications
public class loginTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.setHeadless(true);
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.facebook.com/");
		System.out.println("Title of the page"+driver.getTitle());
		
	}

}
