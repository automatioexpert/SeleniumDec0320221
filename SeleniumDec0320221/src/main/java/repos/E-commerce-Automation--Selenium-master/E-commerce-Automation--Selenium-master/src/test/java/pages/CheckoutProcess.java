package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class CheckoutProcess extends CommonMethods{
	
	public CheckoutProcess() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	
	@FindAll({
		@FindBy(id = "list"),
	})
	WebElement list;
	
	@FindAll({
		@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	})
	WebElement addToCartElement;
	
	@FindAll({
		@FindBy(xpath = "//a[@title='Proceed to checkout']"),
		@FindBy(xpath = "//span[contains(text(),' Proceed to checkout')]")
	})
	WebElement processToCheckout;
	
	@FindAll({
		@FindBy(className = "standard-checkout")
	})
	WebElement checkoutSteps; 
	
	@FindAll({
		@FindBy(id = "search_query_top")
	})
	WebElement 	search_query_top; 

	
	@FindAll({
        @FindBy(xpath = "//button[@name='processAddress']"),
	})
	WebElement checkoutStepsNext; 
	
	@FindAll({
		@FindBy(id = "cgv"),
	})
	WebElement termsCheck;
	
	
	@FindAll({
        @FindBy(xpath = "//button[@name='processCarrier']"),
	})
	WebElement processCarrier; 

	
	public void womenDress() {
		
		Actions action =  new Actions(PageDriver.getCurrentDriver());
		
		WebElement mainMenuElement =  PageDriver.getCurrentDriver().findElement(By.xpath("//a[contains(text(),'Women')]"));
		action.moveToElement(mainMenuElement).perform();
		
		
		WebElement subMenuElement = PageDriver.getCurrentDriver().findElement(By.xpath("//a[contains(text(),'T-shirts')]"));
		action.click(subMenuElement).perform();
	
		timeOut(2000);
		
		list.click();
		
		timeOut(3000);
		
		addToCartElement.click();
		
		timeOut(3000);
		
		processToCheckout.click();
		timeOut(3000);
		
		checkoutSteps.click();
	
		timeOut(3000);
		
	
		sendText(search_query_top, "fsdfdsfsdf");
		
		checkoutStepsNext.click();
		timeOut(2000);
		
		
        termsCheck.click();
        
        processCarrier.click();
		

	}
}
