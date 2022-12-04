package testngsessions;

import org.testng.annotations.Test;

public class InvocationCountConcept {

	@Test(invocationCount = 10, priority = 1, expectedExceptions = ArithmeticException.class)
	public void registerTest() {
		System.out.println("registerTest");
	}

}
