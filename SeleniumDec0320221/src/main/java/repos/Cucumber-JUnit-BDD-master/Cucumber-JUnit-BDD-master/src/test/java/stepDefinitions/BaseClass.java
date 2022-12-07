package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage loginPage;
	public AddCustomerPage addCust;
	public SearchCustomerPage serachCust;
	
	//Greated for generatin random string for Unique email
	public static String randomString() {
		String generateString1=RandomStringUtils.randomAlphabetic(5);
		return (generateString1);
	}
}
