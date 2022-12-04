package MyTests;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	String name = "Tom";

	@Test(expectedExceptions = { NullPointerException.class, ArithmeticException.class })
	public void loginTest() {
		System.out.println("login...");
		try {
			int a = 9 / 0;
		} catch (ArithmeticException e) {
			System.out.println("AE is coming....");
		}
		ExpectedExceptionConcept obj = new ExpectedExceptionConcept();
		// obj = null;
		System.out.println(obj.name);
	}

}
