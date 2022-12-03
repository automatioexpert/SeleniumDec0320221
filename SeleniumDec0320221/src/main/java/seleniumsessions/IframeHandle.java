package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeHandle {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();//Browser

		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");//page

		driver.findElement(By.cssSelector("div#imageTemplateContainer img")).click();
		Thread.sleep(4000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));

		driver.findElement(By.id("RESULT_TextField-7")).sendKeys("123333");
		
		driver.switchTo().defaultContent();//come back to the main page
		
		
	}

}
