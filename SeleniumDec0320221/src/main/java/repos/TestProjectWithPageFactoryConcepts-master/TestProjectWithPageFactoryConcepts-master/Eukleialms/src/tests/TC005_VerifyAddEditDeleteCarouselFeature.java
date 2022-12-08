package tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
import pages.AddEditCarousel;
import pages.Home;
import pages.Login;
import pages.ManageCarousel;

public class TC005_VerifyAddEditDeleteCarouselFeature {
	
	
	public static WebDriver driver;
	Login login;
	Home home;
	ManageCarousel mc;
	AddEditCarousel anc;
	
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
	
	
	 @Test(priority=0)
	  public void VerifyAbleToAddNewCarouselInTheSystem() throws InterruptedException, IOException{ 
		  
		  mc=new ManageCarousel(driver);
		  mc.clickOnaddCarouselLink();
		  anc=new AddEditCarousel(driver);
		  
		  anc.setCarouselName(PropertyUtil.getProperty("test_carousel"));
		  anc.clickOnAddItemButton();
		  anc.waitForAttachmentElmtToBeClickable();
		  anc.fillDataForAddItem();
		  
		  Assert.assertEquals(
				   driver.findElement(By.xpath("//tbody/tr/td[text()='"+PropertyUtil.getProperty("test_carousel")+"']")).isDisplayed(),
				   true, 
				  "Either some error in adding process/created carousel didn't load, Failing Test!");
		  
		  System.out.println("New Carousel: "+PropertyUtil.getProperty("test_carousel")
		  		+ " has been added into the system successfully, Passing Test!"); 
		 
	  }
	 
	 
	 @Test(priority=1)
	  public void VerifyIsAbleToEditNewlyAddedCarousel() throws InterruptedException{ 

		  mc=new ManageCarousel(driver); 
		  driver.findElement(
		  By.xpath("//tbody/tr/td[text()='"+PropertyUtil.getProperty("test_carousel")+"']//following-sibling::td//input[@value='Edit Carousel']"))
		  .click();
		  WaitUtil.waitForElementVisibility(driver, 10, driver.findElement(By.xpath("//legend//a[contains(text(),'Item')]")));
		  anc=new AddEditCarousel(driver);
		  anc.setCarouselName(PropertyUtil.getProperty("test_carousel").concat("New"));
		  driver.findElement(By.xpath("//legend//a[contains(text(),'Item')]")).click();
		  WaitUtil.simpleWait(3);
		  anc.clickOnSaveChanges();
		  
		  WaitUtil.waitForElementVisibility(
				  driver, 
				  30, 
				  driver.findElement(By.xpath("//tbody/tr/td[text()='"+PropertyUtil.getProperty("test_carousel").concat("New")+"']"))
				  );
		  
		  Assert.assertEquals(
				   driver.findElement(By.xpath("//tbody/tr/td[text()='"+PropertyUtil.getProperty("test_carousel").concat("New")+"']")).isDisplayed(),
				   true, 
				  "Either some error in editing process/edited carousel didn't load, Failing Test!");
		  
		  System.out.println("Existing Carousel: "+PropertyUtil.getProperty("test_carousel")
		  		+ " has been Edited to "+PropertyUtil.getProperty("test_carousel").concat("New")
		  		+ " successfully, Passing Test!"); 
		 
	  }
	 
	 
	 @Test(priority=2)
	  public void VerifyIsAbleToDeleteItemsFromAddedEditedCarousel() throws InterruptedException{ 

		  mc=new ManageCarousel(driver); 
		  driver.findElement(
		  By.xpath("//tbody/tr/td[text()='"+PropertyUtil.getProperty("test_carousel").concat("New")+"']//following-sibling::td//input[@value='Edit Carousel']"))
		  .click();
		  WaitUtil.waitForElementVisibility(driver, 10, driver.findElement(By.xpath("//legend//a[contains(text(),'Item')]")));
		  anc=new AddEditCarousel(driver);
		  driver.findElement(By.xpath("//legend//a[contains(text(),'Item')]")).click();
		  WaitUtil.simpleWait(3);
		  anc.clickOnDeleteChkBox();
		  anc.clickOnSaveChanges();
		  
		  WaitUtil.waitForElementVisibility(
				  driver, 
				  30, 
				  driver.findElement(By.xpath("//tbody/tr/td[text()='"+PropertyUtil.getProperty("test_carousel").concat("New")+"']"))
				  );
		 
		  driver.findElement(
				  By.xpath("//tbody/tr/td[text()='"+PropertyUtil.getProperty("test_carousel").concat("New")+"']//following-sibling::td//input[@value='Edit Carousel']"))
				  .click();
		  
		  Assert.assertEquals(
				  driver.findElements(By.xpath("//legend//a[contains(text(),'Item')]")).size()<1,
				   true, 
				  "Either some error in deleting an item process/All elements didn't load correctly, Failing Test!");
		  
		  System.out.println("Earlier added item to Edited Carousel: "+PropertyUtil.getProperty("test_carousel").concat("New")
		  		+ " has been deleted successfully by clicking DeleteCheckBox, Passing Test!"); 
		 
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
