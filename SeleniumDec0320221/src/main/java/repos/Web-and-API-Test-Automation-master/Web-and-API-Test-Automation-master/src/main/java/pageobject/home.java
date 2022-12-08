package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class home {
	
	public WebDriver driver;
	
	By searchBox = By.className("default-input");
	
	
	
	//Constructor
	public home (WebDriver driver) {
		this.driver=driver;
	}
	
	public void mainpageControl() {
	
		Assert.assertEquals(driver.getTitle(), "Beymen.com – Türkiye’nin Tek Dijital Lüks Platformu"); 
	}
	
	public void getSearchbox() throws InterruptedException {
		
		driver.findElement(searchBox).sendKeys("şort");
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(Keys.COMMAND + "a");
		driver.findElement(searchBox).sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys("gömlek",Keys.ENTER);
		Thread.sleep(2000);
	}
	

}
