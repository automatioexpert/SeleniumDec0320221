package com.homeDepot.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.homeDepot.base.Base;
import com.homeDepot.pages.CreateAccountPage;
import com.homeDepot.pages.HomePage;

public class CreateAccountPageTest extends Base {
	HomePage homepage;
	CreateAccountPage createaccount;
	Base baseTest;

	public CreateAccountPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		baseTest=new Base();
		homepage = new HomePage();
		createaccount = new CreateAccountPage();
		
		initilizatioin();
		homepage.getHomePageTittle(driver);
		homepage.register(driver);
	}

	@Test
	public void registerForNewAccount() {
		createaccount.infoForRegistration("sherlycabrera@gmail.com","Sherly123","33025","9542432255");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}



