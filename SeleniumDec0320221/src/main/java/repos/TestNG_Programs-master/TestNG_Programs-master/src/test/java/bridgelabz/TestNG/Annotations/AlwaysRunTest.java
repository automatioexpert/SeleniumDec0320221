package bridgelabz.TestNG.Annotations;

import org.junit.Assert;
import org.testng.annotations.Test;

public class AlwaysRunTest {
	//Always Run = True(When TestNG skips execution of a test case for whatever reasons, and we wants to execute then we use this methods)
	
	@Test(priority = 1)
	public void TestCase1() {
		System.out.println("This is 1st case");
		Assert.fail("We are forcefully failing this test case to check others");
	}
	
	@Test(priority = 2, dependsOnMethods = "TestCase1", alwaysRun = true)
	public void TestCase2() {
		System.out.println("This is 2nd case");
	}
	
	@Test(priority = 3, dependsOnMethods = {"TestCase1", "TestCase2" }, alwaysRun = true)
	public void TestCase3() {
		System.out.println("This is 3rd case");
	}
	
	@Test(priority = 4, dependsOnMethods = {"TestCase1", "TestCase2", "TestCase3"}, alwaysRun = true)
	public void TestCase4() {
		System.out.println("This is 4th case");
	}
}
