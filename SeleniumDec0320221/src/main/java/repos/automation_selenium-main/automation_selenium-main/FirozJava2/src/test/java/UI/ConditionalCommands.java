package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//There are thre conditional command 
// isEnabled
// isSelelected

public class ConditionalCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.keynotesupport.com/internet/web-contact-form-example-radio-buttons.shtml");
		WebElement name=driver.findElementById("name1");
		WebElement tell=driver.findElementById("tel");
		WebElement email=driver.findElementById("email");
		if(name.isDisplayed() && name.isEnabled())
			name.sendKeys("firoz Thakur");
		if(tell.isDisplayed() && tell.isEnabled())
			tell.sendKeys("9805348945");
		if(email.isDisplayed() && email.isEnabled())
			email.sendKeys("firozbhaikardar21@gmail.com");
			
		boolean isSelected = driver.findElementByXPath("//*[@id=\"align\"]/span[4]/input").isSelected();
		if(isSelected==false) {
			driver.findElementByXPath("//*[@id=\"align\"]/span[4]/input").click();
			System.out.println(driver.findElementByXPath("//*[@id=\"align\"]/span[4]/input").isSelected());
		}
	
			
		
			
             
		
		
		
			
		
		
		
		
		
		
	}

}