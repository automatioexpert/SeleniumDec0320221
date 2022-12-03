package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		String title = brUtil.getPageTitle();
		System.out.println(title);
		
		System.out.println(brUtil.getPageUrl());
		
		By email = By.id("input-email");
		By password = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(email, "Anuradha@gmail.com");
		eleUtil.doSendKeys(password, "Anu@123");
		
		brUtil.quitBrowser();
	}

}
