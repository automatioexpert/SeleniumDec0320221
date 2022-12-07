package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'Admin area demo')]")
	@CacheLookup
	WebElement SLOGAN;

	@FindBy(xpath = "//label[@for='Email']")
	@CacheLookup
	WebElement EmailLabel;

	@FindBy(xpath = "//input[@id='Email']")
	@CacheLookup
	WebElement Email;

	@FindBy(xpath = "//label[@for='Password']")
	@CacheLookup
	WebElement PasswordLabel;

	@FindBy(xpath = "//input[@id='Password']")
	@CacheLookup
	WebElement Password;

	@FindBy(xpath = "//input[@id='RememberMe']")
	@CacheLookup
	WebElement rememberMeCheckBox;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement linkLogout;

	// We will use this boolean for assertion. To check if page is opened
	public boolean isPageOpened() {
		return SLOGAN.getText().toString().contains("Admin area demo");
	}

	public String ReturnSloganText() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(SLOGAN));
		return SLOGAN.getText();
	}

	public String ReturnEmailLabelText() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(EmailLabel));
		return EmailLabel.getText();
	}

	public void setUserName(String uname) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(Email));
		if (Email.isDisplayed() & Email.isEnabled()) {
			Email.clear();
			Email.sendKeys(uname);
		}
	}

	public String ReturnSPasswordLabelText() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PasswordLabel));
		return PasswordLabel.getText();
	}

	public void setPassword(String pwd) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(Password));
		if (Password.isDisplayed() & Password.isEnabled()) {
			Password.clear();
			Password.sendKeys(pwd);
		}
	}

	public void clickLoginButton() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(btnLogin));
		if (btnLogin.isDisplayed() & btnLogin.isEnabled()) {
			btnLogin.click();
		}
	}

	public void clickLogoutLink() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(linkLogout));
		if (linkLogout.isDisplayed() & linkLogout.isEnabled()) {
			linkLogout.click();
		}
	}

	public String getHomePageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Your store. Login"));
		return driver.getTitle();
	}
}
