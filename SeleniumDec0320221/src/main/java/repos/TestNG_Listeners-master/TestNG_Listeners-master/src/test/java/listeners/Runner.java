package listeners;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public final class Runner {
	
	
	@BeforeSuite
    public void setUpSuite() {
		System.out.println("before suite in Runner");
	}
	@AfterSuite
    public void tearDownSuite() {
		System.out.println("After suite in Runner");
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("before method in Runner");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("After method in Runner");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");		
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
		Assert.assertTrue(false);
	}
	
	@Test
	public void test3() {
		System.out.println("test3");
	}

}
