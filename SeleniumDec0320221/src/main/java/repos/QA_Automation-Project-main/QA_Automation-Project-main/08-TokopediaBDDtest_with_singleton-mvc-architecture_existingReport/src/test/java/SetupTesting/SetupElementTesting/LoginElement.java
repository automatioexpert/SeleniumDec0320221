package SetupTesting.SetupElementTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SetupTesting.SetupDriverSingleton.DriverSingleton;


public class LoginElement {
	private WebDriver driver;

	public LoginElement() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	//Element

	@FindBy(xpath = "//button[@data-testid='btnHeaderLogin']")
	private WebElement loginBtn;

	@FindBy(id = "email-phone")
	private WebElement input_email_numb_login;

	@FindBy(id = "email-phone-submit")
	private WebElement btn_submit_login;

	@FindBy(xpath = "/html/body/div[7]/div[2]/h4")
	private WebElement text_alert_error;
	
	
	//method
	public void formEmailPhone(String usernumber){
		input_email_numb_login.sendKeys(usernumber);
	}
	
	public void loginBtn() {
		loginBtn.click();
	}


	public void submitBtn() {
		btn_submit_login.click();
	}

	public String text_alert_error() {
		return text_alert_error.getText();
	}


}
