package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();		
		WebDriver driver = brUtil.initDriver("chrome");
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println(brUtil.getPageTitle());
		System.out.println(brUtil.getPageUrl());
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(emailId, "naveen@gmail.com");
		eleUtil.doSendKeys(password, "test@123");
		
		brUtil.closeBrowser();
		
	}

}
