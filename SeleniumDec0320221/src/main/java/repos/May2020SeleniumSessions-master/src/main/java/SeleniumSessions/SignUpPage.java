package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

	public static void main(String[] args) {

		String browser = "chrome";
		WebDriverFactory wf = new WebDriverFactory();
		
		WebDriver driver = wf.launchBrowser(browser);
		wf.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		System.out.println(wf.getPageTitle());
		
		By firstName = By.id("Form_submitForm_FirstName");
		By lastName = By.id("Form_submitForm_LastName");
		By countryName = By.id("Form_submitForm_Country");
		
		ElementUtil elementUtil = new ElementUtil(driver);
		elementUtil.doSendKeys(firstName, "Rufat");
		elementUtil.doSendKeys(lastName, "Malikov");
		elementUtil.doSelectValuesByVisibleText(countryName, "United States");
		
		wf.closeBrowser();

		
		
		
		
	}

}
