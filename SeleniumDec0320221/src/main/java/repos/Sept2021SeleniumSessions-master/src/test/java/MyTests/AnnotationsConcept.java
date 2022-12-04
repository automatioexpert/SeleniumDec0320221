package MyTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsConcept {
	
	/**
	 *  BS -- DBConnection
		BT -- createUser
		BC -- launchBrowser
		
			BM -- loginToApp
			accountInfoTest
			AM -- logout

			BM -- loginToApp
			userInfoTest
			AM -- logout

		AC -- closeBrowser
		AT -- deleteUser
		AS -- disconnectDB
	 */

	@BeforeSuite//1
	public void DBConnection() {
		System.out.println("BS -- DBConnection");
	}

	@BeforeTest//2
	public void createUser() {
		System.out.println("BT -- createUser");
	}

	@BeforeClass//3
	public void launchBrowser() {
		System.out.println("BC -- launchBrowser/url");
	}

	@BeforeMethod//4
	public void loginToApp() {
		System.out.println("BM -- loginToApp");
	}

	@Test
	public void userInfoTest() {
		System.out.println("userInfoTest");
	}

	@Test
	public void accountInfoTest() {
		System.out.println("accountInfoTest");
	}
	
	@Test
	public void profileTest() {
		System.out.println("profileTest");
	}

	@AfterMethod
	public void logout() {
		System.out.println("AM -- logout");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("AC -- closeBrowser");
	}

	@AfterTest
	public void deleteUser() {
		System.out.println("AT -- deleteUser");
	}

	@AfterSuite
	public void disconnectDB() {
		System.out.println("AS -- disconnectDB");
	}

}
