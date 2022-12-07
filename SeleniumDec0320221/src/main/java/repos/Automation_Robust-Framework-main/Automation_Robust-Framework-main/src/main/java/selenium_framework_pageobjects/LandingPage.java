package selenium_framework_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageAbstractcomponents.Abstractcomponent;



public class LandingPage extends Abstractcomponent  {

	WebDriver driver;

//create constructor
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * driver.findElement(By.id("userEmail")).sendKeys("srilekha123@gmail.com");
	 * driver.findElement(By.id("userPassword")).sendKeys("@Srilekha18");
	 * driver.findElement(By.id("login")).click();
	 */
	@FindBy(id = "userEmail")
	WebElement userEle;
	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	public ProductCatalogue loginApplication(String email,String password)
	{
		userEle.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return  productCatalogue;
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	
}