package UI;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import java.security.PublicKey;
import java.sql.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assetionTestNg3 {
	
	@Test
	public void GetTitle()
	{
	    WebDriverManager.chromedriver().setup();
	    ChromeDriver driver =  new ChromeDriver();
	    driver.get("https://www.facebook.com/");
	    SoftAssert softAssert = new SoftAssert();
	    String actualString=driver.getTitle();
	    String expectedString = "Facebook – log in or sign up";
	    System.out.println("Ttile assertion");
	    AssertJUnit.assertEquals(actualString,expectedString);
	    String actualMessageString = driver.findElementByXPath("//*[@id=\"content\"]/div/div/div/div[1]/h2").getText();
	    String expectedString2 = "Facebook helps you connect and share with the people in your life.";
	    System.out.println("message assertion");
	    AssertJUnit.assertEquals(actualMessageString, expectedString2);
	    softAssert.assertAll();
	    driver.quit();
	    
	    
	    
	    
	}
	
	

}
