package testngsessions;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	// pre conditions -> @BS, @BT, @BC, @BM
	// Test Case --> @Test + Assertions
	// --> @Test + Assertions
	// --> @Test + Assertions
	// Post Steps --> @AM, @AC, @AT, @AS

	// pre cond: open the browser
	// luanch the url

	// TC_01: check the title (with some steps) --> actual vs expected
	// TC_02: Search Test (with some steps) --> actual vs expected

	// post steps: close the browser
	
	
	/**
	 * 	beforeSuite --I
		beforeTest --II
		beforeClass --III

			beforeMethod --IV
			search test -- t1
			afterMethod --V
			
			beforeMethod --VI
			title test -- t2
			afterMethod --VII

		afterClass --VIII
		afterTest--IX
		afterSuite --X

	 */

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite -- create a user in DB");
		
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest -- launch browser");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass -- enter url");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod -- login to app");
	}

	@Test
	public void titleTest() {
		System.out.println("title test");
		Assert.assertEquals("google", "google");
	}

	@Test
	public void searchTest() {
		System.out.println("search test");
		Assert.assertEquals("naveen", "naveen");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod -- logout");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass -- close the browser");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest -- delete the user");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite --- close the DB connection");
	}

}
