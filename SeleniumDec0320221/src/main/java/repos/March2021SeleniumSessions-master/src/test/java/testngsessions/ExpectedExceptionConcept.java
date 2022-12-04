package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

	@Test(priority = 1, expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void a_test() {
		System.out.println("a test");
		int i = 9 / 0;
	}

}
