package tests;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonutil.GetDriver;
import commonutil.PropertyUtil;
import commonutil.WaitUtil;
import pages.Home;
import pages.Login;

public class TC001_VerifyImagesForDefaultCarouselBlock {
	
	
	public static WebDriver driver;
	Login login;
	Home home;
	
	@BeforeMethod
	  public void beforeMethod(Method method) throws Exception {
		  
		    System.out.println("Executing: "+method.getName());
		    driver=GetDriver.init(PropertyUtil.getProperty("browser"), PropertyUtil.getProperty("url"));
		    login=new Login(driver);
		    login.loginToApplication(PropertyUtil.getProperty("username"), PropertyUtil.getProperty("password"));
		    WaitUtil.simpleWait(5);
	  }
	
	
	
	 @Test
	  public void VerifyAllCarouselImagesAreVisibleForDefaultCarousel() throws InterruptedException{ 
		  
		  home=new Home(driver);
		  Assert.assertEquals("Home", home.getHomeLinkText(), "Login unsuccessfull");
		  System.out.println("Login Successfull"); 
		  int counter=home.IsAllCarouselImagesExists();
		  Assert.assertEquals(5, counter, "Only "+counter+" images are visible in Carousel Slider on Homepage\n"
		  		+ "Either Default carousel is disabled or admin have added other carousels in the system");
		  System.out.println("All carousel images are visible for Default Carousel, Passing Test!"); 
		  
	  }
	
 
	@AfterMethod
	  public void afterMethod(ITestResult result) {
		  
		  if(ITestResult.FAILURE==result.getStatus()){
				try{
					// To create reference of TakesScreenshot
					TakesScreenshot screenshot=(TakesScreenshot)driver;
					// Call method to capture screenshot
					File src=screenshot.getScreenshotAs(OutputType.FILE);
					// Copy files to specific location 
					// result.getName() will return name of test case so that screenshot name will be same as test case name
					FileUtils.copyFile(src, new File("screenshots\\"+result.getName()+".png"));
					System.out.println("Successfully captured screenshot for failed TestCase: "+result.getName()+"\n\n\n\n");
					
				}catch (Exception e){
					
					System.out.println("Exception while taking screenshot "+e.getMessage());
				} 
		}
			driver.quit();
			
		}
	
}
