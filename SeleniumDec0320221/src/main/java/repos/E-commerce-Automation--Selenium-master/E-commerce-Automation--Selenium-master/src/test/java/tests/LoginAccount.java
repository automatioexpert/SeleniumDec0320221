package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import drivers.BaseDriver;
import drivers.PageDriver;
import pages.LoginFormPage;

public class LoginAccount extends BaseDriver{

	@BeforeClass
	public void startURL() {
		PageDriver.getCurrentDriver().get(baseURL);
		PageDriver.getCurrentDriver().manage().window().maximize();
	}
	
	@Test
	public void loginAnAccount() {
		LoginFormPage loginFormPage = new LoginFormPage();
		loginFormPage.clickOnSignIn();
		loginFormPage.login();
		
	}
}
