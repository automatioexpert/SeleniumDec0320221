package mytests;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

	
	@Test(expectedExceptions = {NullPointerException.class, 
								ArithmeticException.class})
	public void searchTest() {
		System.out.println("search test");
		int i = 9/0;
	}
	
	
	
	
}
