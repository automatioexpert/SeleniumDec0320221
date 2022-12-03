package testcases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class ExpectedExceptionTest1 {

	@Test(expectedExceptions = { ArithmeticException.class,NoSuchElementException.class })
	public void sumTest() {
		int a = 10;
		int b = 20;
		int c = a + b;
		System.out.println(c);
		///System.out.println(c / 0);
		System.out.println(c + 10);
		
		TestNG t = new TestNG();
		System.out.println(t.getClass().getName());
		t.run();
		
		
		

	}
}
