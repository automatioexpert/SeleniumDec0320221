package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//In TestNG the flow of execution would be based on alphabetical order of method name among similar level methods
public class Day3 {
	@Parameters({"URL"})
	@Test
	public void WebLoginCar(String urlname)
	{
		System.out.println("Web Login Car");
		System.out.println();
		System.out.println(urlname);
		System.out.println();
	}
	@Test
	public void MobileLoginCar()
	{
		System.out.println("Mobile Login Car");
	}
	@Test
	public void APILoginCar()
	{
		System.out.println("API Login Car");
	}
	@Test
	public void APILoginCar2()
	{
		System.out.println("API Login Car2");
	}
	@Parameters({"URL"})
	@Test
	public void APILoginCar3(String url2)
	{ 
		System.out.println("API Login Car3");
		System.out.println();
		System.out.println(url2);
		System.out.println();
	}
	@Test
	public void APILoginCar4()
	{
		System.out.println("API Login Car4");
	}
	@BeforeSuite
	//Will execute first when suite has been asked to run
	public void beforeAll()
	{
		System.out.println("before suite");
	}
	@AfterSuite
	//Will execute at end of suite
	public void afterAll()
	{
		System.out.println("After suite");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}

}
