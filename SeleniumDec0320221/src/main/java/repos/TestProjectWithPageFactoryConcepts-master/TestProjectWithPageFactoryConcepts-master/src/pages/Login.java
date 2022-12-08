/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

/**
 * @author rohitnegi
 *
 */
public class Login {
	
	WebDriver driver;
	
	@FindBy(id="username")
	WebElement user;
	
	@FindBy(id="password")
	WebElement passwd;
	
	@FindBy(id="loginbtn")
	WebElement loginbtn;
	
	public Login(WebDriver driver){
		this.driver = driver;
		//testBase = new TestBase();
		PageFactory.initElements(driver, this);
	}
	
	@Step("Loggin in with {0} and {1}")
	public void loginToApplication(String username, String password){
		
		user.sendKeys(username);
		passwd.sendKeys(password);
		loginbtn.click();
		
	}

}