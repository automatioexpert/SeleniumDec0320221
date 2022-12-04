package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {
	
	static String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";

	public static void main(String[] args) throws InterruptedException {

		
		//Windows:
		//System.setProperty("webdriver.chrome.driver", "c:\\users\\downloads\\chromedriverversion\\chromedriver.exe");
		
		//MAC
		System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();//launch browser
		
		driver.get("http://www.amazon.com");//enter url
		
		String actualTitle = driver.getTitle();//get the page title
		System.out.println("page title is: " + actualTitle);
		
		//verification point: checkpoint: expected vs actual result : Assertions
		if(actualTitle.equals(expectedTitle)){
			System.out.println("correct title");
		}
		else{
			System.out.println("incorrect title");
		}
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		if(url.contains("amazon")){
			System.out.println("correct url");
		}
		
		//System.out.println(driver.getPageSource());
		
		Thread.sleep(3000);
		driver.quit();//close the browser
		
	}

}
