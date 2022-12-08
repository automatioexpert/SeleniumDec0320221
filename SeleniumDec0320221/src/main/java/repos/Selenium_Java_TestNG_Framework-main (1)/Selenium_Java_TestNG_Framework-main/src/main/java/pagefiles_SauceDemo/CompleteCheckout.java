package pagefiles_SauceDemo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.testBase;

public class CompleteCheckout extends testBase {
	
	@FindBy(xpath="//h2[text()='THANK YOU FOR YOUR ORDER']")
	private WebElement thankyou;

	@FindBy(xpath="//span[text()='Checkout: Complete!']")
	private WebElement Checkout;
	
	@FindBy(xpath="//button[text()='Open Menu']")
	private WebElement Menu;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement Logout;
	
	public CompleteCheckout() throws Exception {

		PageFactory.initElements(getDriver(),this);
	}
	
	public  void ValidateCheckout()
	{
		String checkout="CHECKOUT: COMPLETE!";
		String thanks="THANK YOU FOR YOUR ORDER";
		Assert.assertEquals(checkout,Checkout.getText());
		Assert.assertEquals(thanks,thankyou.getText());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", Checkout);
	}
	
	
	public  void Logout()
	{
		Menu.click();
		Logout.click();
	}
	
}
