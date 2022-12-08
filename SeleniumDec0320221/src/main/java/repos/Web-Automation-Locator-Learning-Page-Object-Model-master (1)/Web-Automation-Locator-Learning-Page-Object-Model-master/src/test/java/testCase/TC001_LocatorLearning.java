package testCase;

import java.time.Duration;

import org.testng.annotations.Test;

import base.DriverSetup;
import pageObjects.P001_LocatorLearning;

public class TC001_LocatorLearning extends DriverSetup {

String baseUrl = "https://rahulshettyacademy.com/locatorspractice/";
	
	@Test
	public void locatorLearning() throws InterruptedException {
		
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		P001_LocatorLearning object = new P001_LocatorLearning(driver);
		
		object.enterUsername("Saimum");
		
		object.enterPassword("Saimum");
		Thread.sleep(2000);
		
		object.clickLoginButton();
		Thread.sleep(2000);
		
		object.pageError();
		Thread.sleep(2000);
		
		object.forgotPassword();
		Thread.sleep(2000);
		
		object.enterName("Saimum");
		
		object.enterEmail("saimumislam@gmail.com");
		
		object.enterPhoneNumber("01738002113");
		Thread.sleep(2000);
		
		object.resetButton();
		
		object.goToLogin();
		Thread.sleep(2000);
		
		object.enterUserName2("Saimum");
		
		object.enterPassword2("rahulshettyacademy");
		
		object.clickCheckBox();
		
		object.clickLoginButton2();
		Thread.sleep(2000);
		
	}
}
