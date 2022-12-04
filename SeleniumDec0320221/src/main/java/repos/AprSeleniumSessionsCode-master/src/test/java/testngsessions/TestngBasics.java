package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngBasics {

	// testNG: java unit testing fw
	// global pre condition
	// pre condition
	// test steps (test cases) + exp result vs act result --> PASS/FAIL
	// post steps
	
	
	/**
	 *  BS - connectWithDB
		BT - createUser
		BC - launchBrowser

				BM -- login
				add to cart test
				AM -- logout

				BM -- login
				home page test
				AM -- logout

				BM -- login
				search test
				AM -- logout

		AC -- close browser
		AT -- delete user
		AS -- disconnectWithDB

	 */

	@BeforeSuite
	public void connectWithDB() {
		System.out.println("BS - connectWithDB");
	}

	@BeforeTest
	public void createUser() {
		System.out.println("BT - createUser");
	}

	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC - launchBrowser");
	}

	@BeforeMethod
	public void login() {
		System.out.println("BM -- login");
	}

	@Test
	public void homePageTest() {
		System.out.println("home page test");
	}

	@Test
	public void searchTest() {
		System.out.println("search test");
	}

	@Test
	public void addToCartTest() {
		System.out.println("add to cart test");
	}

	@AfterMethod
	public void logout() {
		System.out.println("AM -- logout");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("AC -- close browser");
	}

	@AfterTest
	public void deleteUser() {
		System.out.println("AT -- delete user");
	}

	@AfterSuite
	public void disconnectWithDB() {
		System.out.println("AS -- disconnectWithDB");
	}

}
