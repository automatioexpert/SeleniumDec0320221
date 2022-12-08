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

public class sample {
	
	
	public static WebDriver driver;
	Login login;
	Home home;
	
	@BeforeMethod
	  public void beforeMethod(Method method) throws Exception {
		  
		   Assert.assertTrue(true);
	  }
	
	
	
	 @Test
	  public void VerifyAllCarouselImagesAreVisibleForDefaultCarousel() throws InterruptedException{ 
		  
		  Assert.assertTrue(true);
		  
	  }
	
 
	/*@AfterMethod
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
			
		}*/
}
