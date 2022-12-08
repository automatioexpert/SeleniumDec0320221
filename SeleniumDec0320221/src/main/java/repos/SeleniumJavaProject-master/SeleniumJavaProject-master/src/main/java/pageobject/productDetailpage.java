package pageobject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class productDetailpage {

	public WebDriver driver;
	
	
	
	
	
	//Asus PC is coming.
	
	
	By productname = By.xpath("//*[@id='product-name' and @itemprop='name']");
	By sellerpanel = By.className("seller-container");
	By sellerword = By.xpath("//*[contains(@data-bind,'Satıcı') and text()='Satıcı:']");
	By specialsellername =By.xpath("//a[contains(@data-bind,'product') and contains(@data-hbus,'GoToSellerClick')]");
	By commenttab= By.id("productReviewsTab");
	By commentbutton = By.xpath("//*[@type='button' and contains(@class,'RE6UiZXjK2YNmohcFORJ')]");
	
	
	public productDetailpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
    
    
public WebElement getproductname() {
		
		return driver.findElement(productname);
	}

public WebElement getsellerpanel() {
	
	return driver.findElement(sellerpanel);
}

public WebElement getsellerword() {
	
	return driver.findElement(sellerword);
}

public WebElement getspecialsellername() {
	
	return driver.findElement(specialsellername);
}

public WebElement getcommenttab() {
	
	return driver.findElement(commenttab);
}

public WebElement getcommentbutton() {
	
	return driver.findElement(commentbutton);
}
}
