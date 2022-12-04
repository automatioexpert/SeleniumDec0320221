package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	
	String name;
	
	
	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void searchTest() {
		System.out.println("macbook");
		int i = 9/0;
		ExpectedExceptionConcept obj = new ExpectedExceptionConcept();
		obj = null;
		//obj.name = "Tom";//NPE
		System.out.println("bye");
	}
	
	

}
