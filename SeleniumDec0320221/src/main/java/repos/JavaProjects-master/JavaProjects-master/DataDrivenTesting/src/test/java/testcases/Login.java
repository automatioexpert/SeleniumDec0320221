package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class Login extends BaseClass{
	


	
	@Test
	private void loginAsManager() throws IOException, InterruptedException {
	
		System.out.println(objectRepo.getProperty("bank_manager_loginBtn"));
		WebElement bank_manager_loginBt = driver.findElement(By.cssSelector(objectRepo.getProperty("bank_manager_loginBtn")));
		bank_manager_loginBt.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	

			
	}
	
	
	
	@Test
	private void verifyLoginAsManager() {
		WebElement add_customerBtn = driver.findElement(By.cssSelector(objectRepo.getProperty("add_customerBtn")));
		add_customerBtn.click();
		WebElement fname = driver.findElement(By.cssSelector(objectRepo.getProperty("fname")));
		AssertJUnit.assertTrue(fname.isDisplayed());
		driver.navigate().back();
	}
	
	
	
	

}
