package tests;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonutil.GetDriver;
import commonutil.PropertyUtil;
import commonutil.WaitUtil;
import pages.Home;
import pages.Login;
import pages.ManageCarousel;

public class TC002_VerifyManageCarouselHavingCorrespondingElements {
	
	
	public static WebDriver driver;
	Login login;
	Home home;
	ManageCarousel mc;
	
	@BeforeMethod
	  public void beforeMethod(Method method) throws Exception {
		  
		    System.out.println("Executing: "+method.getName());
		    driver=GetDriver.init(PropertyUtil.getProperty("browser"), PropertyUtil.getProperty("url"));
		    login=new Login(driver);
		    login.loginToApplication(PropertyUtil.getProperty("username"), PropertyUtil.getProperty("password"));
		    WaitUtil.simpleWait(5);
		    home=new Home(driver);
		    home.clickOnManageCarousel();
		    
	  }
	
	
	
	 @Test
	  public void VerifyAllCarouselRecordsHavingCorrespondingEditDeleteBtn() throws InterruptedException{ 
		  
		  mc=new ManageCarousel(driver);
		  int Tot_Carousel=mc.getAllCarousel();
		  System.out.println("Total Carousels avaialable: "+Tot_Carousel);
		  int Tot_EditBtn=mc.isCarouselRecordHasCorrespondingEditButton();
		  int Tot_DelBtn=mc.isCarouselRecordHasCorrespondingDeleteButton();
		
		  Assert.assertEquals(Tot_Carousel==Tot_EditBtn && Tot_Carousel==Tot_DelBtn, true, 
				  "Edit/Delete button for all corresponding Carousel doesn't exist, Failing Test!");
		  
		  System.out.println("Edit/Delete button for all corresponding Carousel exist, Passing Test!"); 
		 
	  }
	 
	 
	 @Test
	 public void VerifyAddCarouselLinkButtonExist() throws InterruptedException{
		  
		 mc=new ManageCarousel(driver);
		 Assert.assertEquals(mc.isAddCarouselLinkButtonExist(), true, "Either Add carousel link button doesn't exist/didn't load, Failing Test!");
		 System.out.print("Add Carousel Link Button is available to add new carousel, Passing Test!");
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
