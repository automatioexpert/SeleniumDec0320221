package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {
	
	//avoid dependency in tests
	//test cases -- should independenct to each other
	
	@Test
	public void loginTest() {
		System.out.println("loginTest");
		int i = 9/2;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void HomePageTest() {
		System.out.println("HomePageTest");
		int i=9/0;
	}
	
	@Test(dependsOnMethods = {"loginTest","HomePageTest"})
	public void SearchPageTest() {
		System.out.println("Search PageTest");
	}
	
	
	

}
