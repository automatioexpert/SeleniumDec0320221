package test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basics {
	/*
	 * For TestNg framework we can skip using main()
	 * We have to create a method and write our test cases in that method
	 * For multiple test scenarios we have to create multiple methods
	 * Then, to run it we just have to write @Test (annotation) before each method so that TestNG can detect it
	 * then we have to import the required libraries like import org.testng.annotations.Test;
	 */
	
	@Test
	public void Demo1()
	{
		System.out.println("Learning TestNG");
		Assert.assertTrue(false);
	}
	
	@Test
	public void Demo2()
	{
		System.out.println("Second Test Case in TestNG");
	}
	@Parameters({"URL","APIKey"})
	@Test
	public void Demo3(String url1,String url2)
	{
		System.out.println();
		System.out.println(url1);
		System.out.println("Multiple Parameter");
		System.out.println(url2);
		System.out.println();
	}
}
