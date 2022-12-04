package TestngSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotations {
	
	//BS
	//BT
	//BC
	
	//BM
		//T1
	//AM
	//BM
		//T2
	//AM
	
	//AC
	//AT
	//AS
//	beforeSuite - create user in DB
//	beforeTest - uploadUserDetails
//	beforeClass - launch browser and url
//	
//	beforeMethod -- login
//	verifyUserNameTest
//	after method --- logout
//	
//	beforeMethod -- login
//	verifyUserAccountNameTest
//	after method --- logout
//	
//	afterClass -- close the browser
//	afterTest -- delete user from DB
//	afterSuite -- disconnect from DB

	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("beforeSuite - create user in DB");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("beforeTest - uploadUserDetails");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("beforeClass - launch browser and url");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("beforeMethod -- login");
	}
	
	@Test(priority=1)
	public void verifyUserNameTest(){
		System.out.println("verifyUserNameTest");
		int i = 9/0;
	}
	
	@Test(priority=2)
	public void verifyUserAccountNameTest(){
		System.out.println("verifyUserAccountNameTest");
	}
	
	@AfterMethod
	public void logout(){
		System.out.println("after method --- logout");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("afterClass -- close the browser");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("afterTest -- delete user from DB");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("afterSuite -- disconnect from DB");
	}
	

}
