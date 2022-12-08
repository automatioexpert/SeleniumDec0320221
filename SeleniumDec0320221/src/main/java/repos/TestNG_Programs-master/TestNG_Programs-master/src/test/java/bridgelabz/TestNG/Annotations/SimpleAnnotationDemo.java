package bridgelabz.TestNG.Annotations;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SimpleAnnotationDemo {
	
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver; 
   
      @BeforeTest
      public void launchBrowser() {
        System.out.println("launching Edge browser"); 
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
  		driver = new EdgeDriver();
        driver.get(baseUrl);
      }
      
      //Go to the home page and verify its title.
      @BeforeMethod
      public void verifyHomepageTitle() {
          String expectedTitle = "Welcome: Mercury Tours";
          String actualTitle = driver.getTitle();
          Assert.assertEquals(actualTitle, expectedTitle);
      }
      
      //Click REGISTER and verify the title of its target page.
      @Test
      public void register(){
          driver.findElement(By.linkText("REGISTER")).click() ;
          String expected = "Register: Mercury Tours";
          String actual = driver.getTitle();
          Assert.assertEquals(actual, expected);
      }
          
      //Go back to the home page and verify if it still has the correct title.
      @AfterMethod
      public void goBackToHomepage ( ) {
    	  driver.findElement(By.linkText("Home")).click() ;
      }
      
      //Closing browser
      @AfterTest
      public void terminateBrowser(){
          driver.close();
      }
}