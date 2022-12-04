package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();//1.launch the browser
				
		driver.get("https://google.com");//2. launch url
		
		String title = driver.getTitle();//3. get the title of the page
		System.out.println(title);
		
		driver.quit();//close the browser
		//driver.close();//close the browser
		
		driver = new ChromeDriver();
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		
		
		
		
	}

}
