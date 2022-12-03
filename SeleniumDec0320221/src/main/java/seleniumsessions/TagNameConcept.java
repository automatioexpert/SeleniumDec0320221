package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagNameConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
//		String prName = driver.findElement(By.tagName("h1")).getText();
//		System.out.println(prName);
		
		//By name = By.tagName("a");
		
//		By productHeader = By.tagName("h1");
//		By terms = By.linkText("Terms & Conditions");
//		
//		String actPrName = doElementGetText(productHeader);
//		if(actPrName.equals("MacBook")) {
//			System.out.println("product name is correct..PASS");
//		}
//		else {
//			System.out.println("FAIL");
//		}
//		
//		System.out.println(doElementGetText(terms));
		
		By firstNameLabel = By.xpath("//*[@id=\"account\"]/div[2]/label");
		System.out.println(doElementGetText(firstNameLabel));
	}
	
	public static String doElementGetText(By locator) {
		String eleText = getElement(locator).getText();
		return eleText;
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
