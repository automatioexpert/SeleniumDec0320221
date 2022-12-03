package testcases;

import org.testng.annotations.Test;

public class DependsOnConcept {

	@Test(priority = 0)
	public void loginTest() {
		System.out.println("loginTest");
		int div = 100 / 0;
		System.out.println(div);

	}

	@Test(priority = 1,dependsOnMethods = "loginTest")
	public void addProductTest() {
		System.out.println("addProductTest");

	}

}
