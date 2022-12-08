package bridgelabz.TestNG.Annotations;

import org.testng.annotations.Test;

public class Group_Concepts {
	//Smoke, sanity, regression, etc are the categories of testing here which is declared by group
	
	@Test(groups = {"Smoke"})
	public void test_Case1() {
		System.out.println("This is 1st test case");
	}
	
	@Test(groups = {"Smoke", "Sanity"})
	public void test_Case2() {
		System.out.println("This is 2nd test case");
		}
	
	@Test(groups = {"Smoke", "Sanity","Regression"})
	public void test_Case3() {
		System.out.println("This is 3rd test case");
	}
	
	@Test(groups = {"Sanity"})
	public void test_Case4() {
		System.out.println("This is 4th test case");
	}
	
	@Test(groups = {"Regression"})
	public void test_Case5() {
		System.out.println("This is 5th test case");
	}

}
