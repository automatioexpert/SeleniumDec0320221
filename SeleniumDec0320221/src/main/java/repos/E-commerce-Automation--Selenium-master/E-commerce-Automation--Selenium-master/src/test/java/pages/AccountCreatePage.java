package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import drivers.PageDriver;
import utilities.CommonMethods;
import utilities.GetScreenShot;

public class AccountCreatePage extends CommonMethods{
	
	ExtentTest test;

	public AccountCreatePage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	
	}
	
	//@FindBy = driver.findElement(By.)
	
	@FindAll({
		@FindBy(xpath = "//a[contains(text(),'Sign in')]"),
		@FindBy(xpath = "//a[@title='Log in to your customer account']")
	})
	WebElement signIn;
	
	@FindAll({
		@FindBy(id = "email_create"),
		@FindBy(xpath = "//input[@id='email_create']")
	})
	WebElement emailAddress;
	
	@FindAll({
		@FindBy(id = "SubmitCreate"),
		@FindBy(xpath = "//button[@id='SubmitCreate']")
	})
	WebElement accountBtn;
	
	public void clickOnSignIn() throws IOException {
		test.info("Click on Sign in Button");
		
		try {
			if (signIn.isDisplayed()) {
				signIn.click();
				test.pass("<p style=\"color:green; font-size:13px\"><b>Sign-in Button Clicked.</b></p>");
				timeOut();
			}
		} catch (Exception e) {
			test.fail("<p style=\"color:red; font-size:13px\"><b>Sign-in location not avialble.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "signInButton");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "signInButton.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(signIn.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
		
	}
	
	public void sendEmail() throws IOException {
        test.info("Email Address");
		try {
			if (emailAddress.isDisplayed()) {
				sendText(emailAddress, emailGenerate());
				test.pass("<p style=\"color:green; font-size:13px\"><b>Email Address</b></p>");
				timeOut();
			}
		} catch (Exception e) {
			test.fail("<p style=\"color:red; font-size:13px\"><b>Email Address not avialble.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "emailAdress");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "emailAdress.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(emailAddress.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
		
	}
	
	public void clickOnAccountBtn() throws IOException {
		test.info("Click on Account btn");
		try {
			if (accountBtn.isDisplayed()) {
				accountBtn.click();
			
				test.pass("<p style=\"color:green; font-size:13px\"><b>accountBtn click</b></p>");
				timeOut(5000);
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "accountBtn pass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "accountBtnpass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		} catch (Exception e) {
			test.fail("<p style=\"color:red; font-size:13px\"><b>accountBtn not avialble.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "accountBtn");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "accountBtn.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(accountBtn.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
	}
	
	
}
