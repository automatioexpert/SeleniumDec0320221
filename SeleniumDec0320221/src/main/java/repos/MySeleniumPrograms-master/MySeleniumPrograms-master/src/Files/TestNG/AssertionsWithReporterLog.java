package Files.TestNG;

import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssertionsWithReporterLog {
	WebDriver driver;
	String url;
  @Test
  public void verify01() {
	  url="http://google.com"; 
	  System.setProperty("webdriver.gecko.driver", "C:/chromedriver/chromedriver.exe");
	  driver=new FirefoxDriver();
	  driver.get(url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  String expTitle="Google";
	  String actTitle=driver.getTitle();
	  Assert.assertEquals(expTitle, actTitle);
	  Reporter.log("Title is : " + expTitle,true);
  }
  
  @Test
  public void verify02() {
	  WebElement logo=driver.findElement(By.id("hplogo"));
	  Assert.assertTrue(logo.isDisplayed(),"Verify logo is dispalyed");
	  Reporter.log("Logo is displayed", true);
  }
  
}
