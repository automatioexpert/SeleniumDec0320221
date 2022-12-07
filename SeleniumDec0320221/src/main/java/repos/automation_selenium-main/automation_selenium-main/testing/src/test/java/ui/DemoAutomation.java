package ui;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","/Users/admin/Documents/BrowserDriver/chromedriver");
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://www.google.com");
		
	}

}
