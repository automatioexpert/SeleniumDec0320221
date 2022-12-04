package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartTest {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.initDriver("chrome");

		br.launchUrl("https://demo.opencart.com/index.php?route=account/login");

		System.out.println(br.doGetTitle());

		By email = By.id("input-email");
		By password = By.id("input-password");

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(email, "test@gmail.com");
		eleUtil.doSendKeys(password, "test@123");
		
		br.closeBrowser();

	}

}
