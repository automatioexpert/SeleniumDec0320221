package MyTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("browser launch");
		int i = 9/0;
	}
	
	@Test
	public void createUserTest() {
		System.out.println("create user test");
		//int i = 9/0;
	}
	
	@Test()
	public void loginTest() {
		System.out.println("login to appp");
		//int i = 9/0;
	}
	
	@Test(dependsOnMethods = {"loginTest", "createUserTest"}, priority = 1)
	public void homePageTest() {
		System.out.println("home page test");
	}
	
	@Test(dependsOnMethods = "loginTest", priority = 2)
	public void searchTest() {
		System.out.println("search test");
	}
	
	
	//unit test :
	//test case should be independent
	//never create any dependency
	//every test should have its own pre condition, test steps, assertion, status
	
	
	
	

}
