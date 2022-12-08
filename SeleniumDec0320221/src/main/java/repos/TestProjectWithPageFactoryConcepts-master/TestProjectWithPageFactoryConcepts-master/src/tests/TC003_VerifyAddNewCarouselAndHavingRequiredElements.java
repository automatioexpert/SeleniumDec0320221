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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutil.GetDriver;
import commonutil.Listener;
import commonutil.PropertyUtil;
import commonutil.WaitUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pages.AddEditCarousel;
import pages.Home;
import pages.Login;
import pages.ManageCarousel;

@Listeners({Listener.class})
@Epic("Regression")
@Feature("Test Routing of Add new carousel button")
public class TC003_VerifyAddNewCarouselAndHavingRequiredElements extends GetDriver{
	
	
	public static WebDriver driver;
	Login login;
	Home home;
	ManageCarousel mc;
	AddEditCarousel anc;
	
	@BeforeMethod
	  public void beforeMethod(Method method) throws Exception {
		  
		 System.out.println("Executing: "+method.getName());
		    init(PropertyUtil.getProperty("browser"), PropertyUtil.getProperty("url"));
		   // driver=GetDriver.init(PropertyUtil.getProperty("browser"), PropertyUtil.getProperty("url"));
		    login=new Login(driver);
		    login.loginToApplication(PropertyUtil.getProperty("username"), PropertyUtil.getProperty("password"));
		    WaitUtil.simpleWait(5);
		    home=new Home(driver);
		    home.clickOnManageCarousel();
		    
	  }
	
	
	@Description("Checking able to route to Add new carousel form and having required elements")
	 @Test(priority=0)
	  public void VerifyAbleToRouteToAddNewCarouselHavingSomeFields() throws InterruptedException{ 

		  mc=new ManageCarousel(driver);
		  mc.clickOnaddCarouselLink();
		  anc=new AddEditCarousel(driver);
		  
		  Assert.assertEquals(
				  anc.isCarouselNameFieldMandatory() && anc.isAddItemButtonExist() && anc.isSaveChangesButtonExist(), true, 
				  "Either carousel name field is not mandatory/Add Item button doesn't exist, Failing Test!\n");
		  
		  System.out.println("Able to route Add New Carousel page, having these fields:\n"
		  		+ "Mandatory Carousel Name field\nButton to Add Item to carousel\n"
		  		+ "Button to save your changes, Passing Test!\n"); 
		 
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
