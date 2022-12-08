package pagefiles_SauceDemo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.testBase;

public class CheckoutPage extends testBase {

	@FindBy(xpath="//button[@id='finish']")
	private WebElement finish;
	
	@FindBy(xpath="//div[@class='summary_total_label']")
	private WebElement total;
	
	@FindBy(xpath="//div[text()='SauceCard #31337'] ")
	private WebElement Sauce_Card; 
	
	public CheckoutPage() throws Exception
	{
		
		PageFactory.initElements(getDriver(),this);
	}
	
	public void clickFinish() {
		finish.click();
	}
	
	
	public void ValidateTotal()
	{
		String TotalPrice="Total: $32.39";
		 Assert.assertEquals(TotalPrice, total.getText());
		
	}
	public void ScrollTotal()
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", Sauce_Card);
	}
}
