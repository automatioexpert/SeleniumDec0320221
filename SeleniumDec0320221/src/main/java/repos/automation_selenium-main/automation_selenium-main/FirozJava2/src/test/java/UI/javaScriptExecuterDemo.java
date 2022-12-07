package UI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecuterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/");
		WebElement element = driver.findElementByXPath("/html/body/div/header/div/ul/li[2]/a");
		javaScriptUtil.flash(element, driver);
		javaScriptUtil.border(element, driver);
		String s = javaScriptUtil.returnTitle(driver);
		System.out.println(s);
		WebElement image = driver.findElementByXPath("//*[@id=\"rslides3_s0\"]/div[1]/img");
		javaScriptUtil.scrollTillTheElement(image,driver);
	   // javaScriptUtil.clickByJs(element, driver);
		//String message = "Login succesfull";
	 //	javaScriptUtil.generateAlert(message,driver);
			
		//driver.quit();
		javaScriptUtil.scrollTillEnd(driver);
	}
}
