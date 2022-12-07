package Files.TestNG;

import org.testng.annotations.AfterTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAnnotations {
	
	
	@BeforeTest
	public void beforetest() {
		System.out.println("This test is for the before Test");
	}

	@AfterTest
	public void aftertest() {
		System.out.println("This test is for the after Test");
	}
	 
	@BeforeMethod()
	public void TestBeforeMethod() {
		System.out.println("This is BeforeMethod");
	}
	
	@AfterMethod
	public void TestAfterMethod() {
		System.out.println("This is AfterMethod");
	}
	
	@Test(priority=1)
	public void verifyTest_1() {
		
		System.out.println("This test is to verifyTest_1");
		
		Assert.assertEquals("A", "B");
	}
	// Depends on Methods keyword
	@Test(priority=1,dependsOnMethods="verifyTest_1",alwaysRun=true)
	public void verifyTest_2() {
    // This Method will not execute if the method verifyTest_1 is failed, 
	// but it will execute only when the keyword "alwaysRun = true" is given.
		
		System.out.println("This test is to verifyTest_2");
	}
	
	@Test(priority=0)
	public void verifyTest_3() {
		System.out.println("This test is to verifyTest_3");
	}
}
