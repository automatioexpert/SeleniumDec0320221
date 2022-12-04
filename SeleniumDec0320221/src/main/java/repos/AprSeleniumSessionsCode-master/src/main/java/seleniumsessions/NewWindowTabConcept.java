package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindowTabConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		//Creates a new browser window and switches the focus for future
		//commands of this driver to the new window/tab.
		driver.switchTo().newWindow(WindowType.WINDOW);//sel 4.x
		driver.get("https://naveenautomationlabs.com/opencart/");
		System.out.println(driver.getTitle());
		
		//driver.close();
		
		//come back to the parent window: using window handler api
	}

}
