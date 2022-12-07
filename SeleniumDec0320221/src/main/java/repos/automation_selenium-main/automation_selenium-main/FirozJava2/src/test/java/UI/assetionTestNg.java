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

import io.github.bonigarcia.wdm.WebDriverManager;

public class assetionTestNg {
	
	@Test
	public void GetTitle()
	{
	    WebDriverManager.chromedriver().setup();
	    ChromeDriver driver =  new ChromeDriver();
	    driver.get("https://www.facebook.com/");
	    String actualString=driver.getTitle();
	    String expectedString = "Facebook – log in or sign up";
	    AssertJUnit.assertEquals(actualString,expectedString);
	    System.out.println("heye baba");
	    driver.quit();
	}
	
	

}
