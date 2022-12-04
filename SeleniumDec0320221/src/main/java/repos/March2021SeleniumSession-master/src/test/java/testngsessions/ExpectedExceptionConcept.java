package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	int age = 25;

	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void loginTest() {
		System.out.println("login");
		int i = 9 / 0;
		ExpectedExceptionConcept obj = new ExpectedExceptionConcept();
		obj = null;
		System.out.println(obj.age);
	}

}
