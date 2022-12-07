/**
 * 
 */
package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.SignInPage;

/**
 * @author anand acharya
 *
 */
public class HomePageTest extends TestBase {

	HomePage homepage;
	SignInPage signInPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		homepage = new HomePage();
	}
	
	@Test(priority=1)
	public void verifyTitleTest(){
		String title = homepage.verifyTitle();
		Assert.assertEquals(title, "Amazon.com.au: Shop online for Electronics, Apparel, Toys, Books, DVDs & more");
	}
	
	@Test(priority=2)
	public void verifySearch(){
		homepage.enterSearch();
	}
	
	@Test(priority=3)
	public void clickSignInTest(){
		signInPage = homepage.clickSignIn();
	}
	
	
	
	@AfterMethod
	public void teardown(){
		driver.close();
	}
}
