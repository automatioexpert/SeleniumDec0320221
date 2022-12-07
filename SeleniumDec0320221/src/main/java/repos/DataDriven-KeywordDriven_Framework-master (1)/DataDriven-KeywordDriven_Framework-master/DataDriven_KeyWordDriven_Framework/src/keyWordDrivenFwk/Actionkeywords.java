/**
 * 
 */
package keyWordDrivenFwk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * @author anand acharya
 * methods for each action keywords
 */
public class Actionkeywords {
static WebDriver driver;
	
	public static void openbrowser()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(ffprofile);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	public static void openurl() throws Exception
	{
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
	}
	
	public static void entercredentials()
	{
		driver.findElement(By.id("email")).sendKeys("testkeyworddrivenframework@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("test123");
	}
	
	public static void clicklogin() throws InterruptedException
	{
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(5000);
		System.out.println("Test successfully completed");
	}
}
