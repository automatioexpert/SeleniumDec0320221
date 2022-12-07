package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//In TestNG the flow of execution would be based on alphabetical order of method name among similar level methods
public class Day5 {
	@Parameters({"URL"}) //Value from TestNG XML file lands here. This is a GLOBAL environment variable
	@Test
	public void WebLoginCar(String urlname) //Value that has landed above in parameters will be caught here
	//Should be executed from XML file
	{
		System.out.println("Personal LOAN");
		System.out.println();
		System.out.println(urlname);
		System.out.println();
	}
	@Test
	public void MobileLoginCar()
	{
		System.out.println("Mobile Login Car");
	}
	@Test(dependsOnMethods= {"WebLoginCar"})
	//This says that this particular case is dependent on the mentioned case. So here first the mentioned method will run and
	//then the dependent method. 1. WebLoginCar; 2.APILoginCar
	public void APILoginCar()
	{
		System.out.println("API Login Car");
	}
	@Test(dependsOnMethods= {"WebLoginCar","MobileLoginCar"})
	/*
	 * This means that the above method is dependent on more than one method to execute
	 */
	public void APILoginCar2()
	{
		System.out.println("API Login Car2");
	}
	@Test(enabled=false) //TestNG will safely skip this case while executing. This could be due to known bug in the module and avoid
	//a false report/failure/red flag
	public void APILoginCar3()
	{ 
		System.out.println("API Login Car3");
	}
	@Test(timeOut=4000) //Will not fail until 40seconds before throwing and error
	//Can be used when the particular execution is taking time. So we say hold on for mentioned time
	public void APILoginCar4()
	{
		System.out.println("API Login Car4");
	}
}
