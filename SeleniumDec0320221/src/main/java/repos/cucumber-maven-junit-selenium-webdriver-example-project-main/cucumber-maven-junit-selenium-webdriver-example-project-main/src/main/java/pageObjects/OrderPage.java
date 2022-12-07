package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage{
	WebDriver driver;
	public By countrySelect =  By.xpath("//div[@class=\"wrapperTwo\"]//select");
	public By selectedCountry = By.xpath("//option[@value=\"Bangladesh\"]");
	public By termsAndConditions = By.xpath("//input[@type=\"checkbox\"]");
	public By proceedButton = By.xpath("//button[text()=\"Proceed\"]");
	
	//constructor method
	public OrderPage(WebDriver driver) {
		this.driver = driver;
	}
	//common method
	public WebElement getPageElement(By element) {
		return driver.findElement(element);
	}
}
