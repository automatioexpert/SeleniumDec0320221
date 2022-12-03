package testcases;

import org.testng.annotations.Test;

public class ExpectedExceptionTest {

	@Test(invocationCount = 10)
	public void createUserTest() {
		System.out.println("Hello World");
		int i=1;
		
		i++;
		System.out.println(i);
		
		
	}
	
	
}
