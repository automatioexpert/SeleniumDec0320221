/**
 * 
 */
package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.RegisterAccount;
import com.qa.pages.SignInPage;
import com.qa.util.TestUtil;

/**
 * @author anand acharya
 *
 */
public class RegisterAccountTest extends TestBase {

	HomePage homepage;
	SignInPage signInPage;
	RegisterAccount registerAccount;
	TestUtil testUtil;
	String sheetname = "Sheet1";
	
	public RegisterAccountTest(){
		super();
	}
	
	@BeforeMethod()
	public void setup(){
		initialization();
		homepage = new HomePage();
		signInPage = homepage.clickSignIn();
		registerAccount = signInPage.clickCreateAccount();
		
	}
	
	@DataProvider
	public Object[][] getCreateAccountData(){
		//testUtil = new TestUtil();
		Object[][] accountdata = TestUtil.getTestData(sheetname);
		return accountdata;
	}
	
	@Test(dataProvider = "getCreateAccountData")
	public void verifyCreateNewAccountTest(String name, String email, String pswd, String repswd){
		registerAccount.createNewAccount(name, email, pswd, repswd);
	}
	
	@AfterMethod
	public void teardown(){
		driver.close();
	}
	
}
