package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoCartTest {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		
		WebDriver driver = br.initDriver("chrome");
		

		br.lauchUrl("https://demo.opencart.com/index.php?route=account/login");

		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By registerLink = By.linkText("Register");

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(emailId, "naveen@gmail.com");
		eleUtil.doSendKeys(password, "test@123");
		eleUtil.doClick(registerLink);

		//br.closeBrowser();
		
	}

}
