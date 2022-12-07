package parabank.po;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class PO_Login {

	//1st Section
	WebDriver driver;

	//2nd Paramatrized constructor
	public PO_Login(WebDriver driver) {
		this.driver = driver;
	}

	//3rd Section: Locators
	@FindBy(how = How.NAME,using = "username") 
	private WebElement txtbx_username;

	@FindBy(how = How.NAME,using = "password") 
	private WebElement txtbx_password;

	@FindBy(how = How.XPATH,using = "//*[@id='loginPanel']/form/div[3]/input") 
	private WebElement btn_submit;

	//4th Section- methods
	public void EnterUserName(String text) {
		txtbx_username.sendKeys(text);

	}

	public void EnterPassword(String text) {
		txtbx_password.sendKeys(text);


	}

	public void ClickSubmitButton() {
		btn_submit.click();

	}

	//************KW Layer****************
	public void LoginInToParabank(String u, String p) {
		EnterUserName(u);
		EnterPassword(p);
		ClickSubmitButton();

		String expected = "ParaBank | Accounts Overview";
		String actual = driver.getTitle();

		Assert.assertEquals(actual, expected);

	}

}
