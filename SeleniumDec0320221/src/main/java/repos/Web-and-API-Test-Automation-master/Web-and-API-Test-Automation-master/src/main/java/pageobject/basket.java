package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class basket {

	public WebDriver driver;
	
	By basketpagecontrol = By.className("m-basket__header--title");
	By sizecontrol = By.xpath("//*[@disabled='disabled' and @value='2']");
	By removeItem = By.id("removeCartItemBtn0-key-0");
	By emptycontrol = By.xpath("//*[text()='Sepetinizde Ürün Bulunmamaktadır']");
	
	
	public basket(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	public void ValidateBasket() throws InterruptedException {
		
		Assert.assertEquals(driver.findElement(basketpagecontrol).getText(), "ALIŞVERİŞ SEPETİM");
		Assert.assertTrue(driver.findElement(sizecontrol).isDisplayed());
		Thread.sleep(1000);
	}
	
	
	public void DeleteItems() throws InterruptedException {
		
		driver.findElement(removeItem).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(emptycontrol).isDisplayed());
	}
}
