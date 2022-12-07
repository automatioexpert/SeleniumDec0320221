package Files.TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testexample {
	
	@BeforeTest
	public void beforetest() {
		System.out.println("This test is for the before Test");
	}

	@AfterTest
	public void aftertest() {
		System.out.println("This test is for the after Test");
	}
	 
	@Test
	public void verifyTest_1() {
		System.out.println("This test is to verifyTest_1");
	}


}
