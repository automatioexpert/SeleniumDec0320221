package TestngSessions;

import org.testng.annotations.Test;

public class InvocationCountConcept {
	
	
	@Test(invocationCount=10)
	public void createUserTest(){
		System.out.println("createUserTest");
	}
	
	

}
