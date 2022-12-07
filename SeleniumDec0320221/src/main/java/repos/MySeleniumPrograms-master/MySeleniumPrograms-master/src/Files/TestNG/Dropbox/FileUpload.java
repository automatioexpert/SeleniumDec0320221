package Files.TestNG.Dropbox;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FileUpload {

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
		Reporter.log("Window is maximized");
	}

	@Parameters({ "UserName", "Password", "Printmsg" })
	@Test(priority = 1)
	public void SignupDetails(String UserName, String Password, String Printmsg) {
		driver.findElement(By.name("login_email")).sendKeys(UserName);
		driver.findElement(By.name("login_password")).sendKeys(Password);
		driver.findElement(By.name("remember_me")).click();
		driver.findElement(By.className("signin-text")).click();
		// Execute the below two lines of code for the very first time, from the next
		// run comment them
		// driver.findElement(By.xpath("//img[contains(@class,'sprite sprite_web
		// s_web_close_small')]")).click();
		// driver.findElement(By.xpath("//img[contains(@class,'sprite sprite_web
		// s_web_banner_x')]")).click();
		System.out.println(Printmsg);
		Reporter.log("Print message is printed successfully");
	}

	@Test(priority = 2)
	public void UploadAFile() throws AWTException { 
		driver.findElement(
				By.xpath("//span[@class='primary-action-menu__button action-upload mc-button mc-button-primary']"))
				.click();
		driver.findElement(By.xpath("//button[@class='action-upload-files mc-popover-content-item']")).click();

		String requiredpath = "F:\\Dropbox\\Test.txt";

		StringSelection attachment = new StringSelection(requiredpath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(attachment, null);

		Robot robot = new Robot();

		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//span[@class='tree-view__item-label']")).click();
		driver.findElement(By.xpath("//span[@class='mc-button-content'][contains(text(),'Upload')]")).click();

		System.out.println("Uploaded File Successfully");
		Reporter.log("File is uploaded successfully");

		// driver.close();
	}

}