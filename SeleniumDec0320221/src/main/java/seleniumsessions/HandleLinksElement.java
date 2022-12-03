package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinksElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//6. link text:
		//driver.findElement(By.linkText("MacBook")).click();
		//link html tag = <a> with text
//		By macLink = By.linkText("MacBook");
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doClick(macLink);
		//Thread.sleep(5000);
		//driver.findElement(By.linkText("CONTACT SALES")).click();
		
//		String contactsales_text = "CONTACT SALES";
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doClick("linktext", contactsales_text);
		
		//7. partial link text:
		//CONTACT SALES
		//CONTACT TEAM
		//CONTACT Marketing
		driver.findElement(By.partialLinkText("SALES")).click();
		
		

	}

}
