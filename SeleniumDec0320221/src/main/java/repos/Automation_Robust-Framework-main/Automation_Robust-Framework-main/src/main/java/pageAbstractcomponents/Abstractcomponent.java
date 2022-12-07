package pageAbstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import selenium_framework_pageobjects.Cartpage;
import selenium_framework_pageobjects.OrderPage;

public class Abstractcomponent {
	WebDriver driver;

	public Abstractcomponent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	public Cartpage goToCartPage() {
		cartHeader.click();
		return new Cartpage(driver);
	}

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	public OrderPage goToOrdersPage()
	{
		orderHeader.click();
		OrderPage orderPage = new selenium_framework_pageobjects.OrderPage(driver);
		return orderPage;
	}

	public void waitForElementToDisappear(WebElement ele) throws InterruptedException   {
		Thread.sleep(1000);
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.invisibilityOf(ele));

	}

}
