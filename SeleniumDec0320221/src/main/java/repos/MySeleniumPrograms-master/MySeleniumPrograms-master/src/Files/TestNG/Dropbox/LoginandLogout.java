package Files.TestNG.Dropbox;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginandLogout {

	WebDriver driver;

	@Parameters("browser")
	@Test(priority = 0)
	public void DropboxLogin(String browser) {
		System.out.println("Running Browser Name is :" + browser);
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get("https://www.dropbox.com/login?src=logout");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Parameters({ "UserName", "Password", "Printmsg" })
	@Test(priority = 1)
	public void SignupDetails(String UserName, String Password, String Printmsg) {
		driver.findElement(By.name("login_email")).sendKeys(UserName);
		driver.findElement(By.name("login_password")).sendKeys(Password);
		// driver.findElement(By.name("remember_me")).click();
		driver.findElement(By.className("signin-text")).click();
		// Execute the below two lines of code for the very first time, from the next
		// run comment them
		// driver.findElement(By.xpath("//img[contains(@class,'sprite sprite_web
		// s_web_close_small')]")).click();
		// driver.findElement(By.xpath("//img[contains(@class,'sprite sprite_web
		// s_web_banner_x')]")).click();
		System.out.println(Printmsg);
	}

	@Parameters("expected")
	@Test(priority = 2)
	public void LogOut(String expected) {
		driver.findElement(By.xpath("//img[@class='mc-avatar-image']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		String getTitle = driver.getTitle();
		Assert.assertEquals(getTitle, expected);
		System.out.println("Logout is successful");
	}

}
