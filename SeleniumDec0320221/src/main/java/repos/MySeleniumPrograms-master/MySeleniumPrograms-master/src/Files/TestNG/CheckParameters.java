package Files.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

 public class CheckParameters {

	
  //@Parameters("UserName") - Use this to pass single parameter 
	@Parameters({"UserName","password"})
	@Test
    public void checkSingleparam(@Optional("Selenium")String User_Name,String passwordvalue) 
	// Use "@Optional" keyword when you give wrong Username parameter in XML file(SuiteSample.xml) then Optional will
    // override the wrong parameter and prints the value given in "@Optional".
	//public void checkparameters(String User_Name,String passwordvalue)
	{
		System.out.println("User_Name from the Xml file parameter Tag:" +User_Name);
		System.out.println("Password from the Xml file parameter Tag:" +passwordvalue);
		
	
    }

	
	
}