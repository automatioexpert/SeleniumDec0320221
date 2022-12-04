package MyTests;

import org.testng.annotations.Test;

public class InvocationCountTest {

	@Test(invocationCount = 100)
	public void getUserInfoTest() {
		System.out.println("get user...");
		// get api call
	}

}
