/**
 * 
 */
package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.RegisterAccount;
import com.qa.pages.SignInPage;

/**
 * @author anand acharya
 *
 */
public class SignInPageTest extends TestBase {

	HomePage homepage;
	SignInPage signInPage;
	RegisterAccount registerAccount;
	
	public SignInPageTest(){
		super();
	}
	
	@BeforeMethod()
	public void setup(){
		initialization();
		homepage = new HomePage();
		signInPage = homepage.clickSignIn();
	}
	
	@Test()
	public void verifyCreateAccountTest(){
		registerAccount = signInPage.clickCreateAccount();
	}
	
	@AfterMethod
	public void teardown(){
		driver.close();
	}
}
