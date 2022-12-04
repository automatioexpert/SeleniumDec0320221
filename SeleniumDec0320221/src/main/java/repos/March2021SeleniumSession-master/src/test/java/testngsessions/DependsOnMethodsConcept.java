package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {

	// AAA

	@Test
	public void loginTest() {
		System.out.println("login");
		int i = 9/0;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void homePageTest() {
		System.out.println("homePageTest");

	}
	
	@Test(dependsOnMethods = "loginTest")
	public void cartPageTest() {
		System.out.println("cartPageTest");

	}

}
