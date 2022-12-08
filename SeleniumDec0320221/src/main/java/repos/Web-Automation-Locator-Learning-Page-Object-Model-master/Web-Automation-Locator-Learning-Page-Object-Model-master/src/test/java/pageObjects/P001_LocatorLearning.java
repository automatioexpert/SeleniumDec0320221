package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P001_LocatorLearning {

WebDriver driver = null;
	
	public P001_LocatorLearning(WebDriver driver) {
		this.driver = driver;
	}
	
	By username = By.id("inputUsername");
	By pasword = By.name("inputPassword");
	By signin = By.className("signInBtn");
	
	By pageError = By.cssSelector("p.error");
	
	By forgotPassword = By.linkText("Forgot your password?");
	
	By enterName = By.xpath("//input[@placeholder='Name']");
	By enterEmail = By.cssSelector("input[placeholder='Email']");
	By phoneNumber = By.xpath("//input[@type='text'][3]");
	By reset = By.cssSelector(".reset-pwd-btn");
	
	By goToLogin = By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]");
	
	By username2 = By.cssSelector("#inputUsername");
	By password2 = By.cssSelector("input[type*='pass']");
	By checkBox = By.id("chkboxOne");
	By signin2 = By.xpath("//button[contains(@class,'submit')]");
	
	
	public void enterUsername(String text) {
		driver.findElement(username).sendKeys(text);
	}
	
	public void enterPassword(String text) {
		driver.findElement(pasword).sendKeys(text);
	}
	
	public void clickLoginButton() {
		driver.findElement(signin).click();
	}
	
	public void pageError() {
		System.out.println(driver.findElement(pageError).getText());
	}
	
	public void forgotPassword() {
		driver.findElement(forgotPassword).click();
	}
	
	public void enterName(String text) {
		driver.findElement(enterName).sendKeys(text);
	}
	
	public void enterEmail(String text) {
		driver.findElement(enterEmail).sendKeys(text);
	}
	
	public void enterPhoneNumber(String text) {
		driver.findElement(phoneNumber).sendKeys(text);
	}
	
	public void resetButton() {
		driver.findElement(reset).click();
	}
	
	public void goToLogin() {
		driver.findElement(goToLogin).click();
	}
	
	public void enterUserName2(String text) {
		driver.findElement(username2).sendKeys(text);
	}
	
	public void enterPassword2(String text) {
		driver.findElement(password2).sendKeys(text);
	}
	
	public void clickCheckBox() {
		driver.findElement(checkBox).click();
	}
	
	public void clickLoginButton2() {
		driver.findElement(signin2).click();
	}
}
