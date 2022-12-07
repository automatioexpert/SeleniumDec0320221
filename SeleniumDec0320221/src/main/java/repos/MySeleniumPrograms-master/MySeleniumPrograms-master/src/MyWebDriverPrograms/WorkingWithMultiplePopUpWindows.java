package MyWebDriverPrograms;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkingWithMultiplePopUpWindows {

	public static void main(String[] args) {
		WebDriver driver;
		// Launch Chrome
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(); // launch chrome
		driver.get("https://naukri.com"); // Get URL
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// get the parent window of the page
		String Parentwindow = driver.getWindowHandle();
		System.out.println("ParentWindow Name is:" + Parentwindow);

		// get all windows of the page
		Set<String> Allwindows = driver.getWindowHandles();
		// Extended For Loop, Iterate each value in the window

		System.out.println("Allwindows :" + Allwindows);
		for (String currentwindow : Allwindows) {
			System.out.println("Current Window is:" + currentwindow);
			// Go to the curent window and verify current window is Parent window (Naukri
			// page)
			if (!currentwindow.equals(Parentwindow)) {
				// Switch the focus to the required window
				driver.switchTo().window(currentwindow);
				// close the window, closing the webpage instance
				driver.close();
			}
		}
		// Focus back to parent window
		driver.switchTo().window(Parentwindow);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='block']")));
		driver.findElement(By.xpath("//span[@id='block']")).click();

		// Verify how many windows available after closing the popup window
		if (driver.getWindowHandles().size() == 1) {
			System.out.println(+driver.getWindowHandles().size());
			System.out.println("Only Parent window is opened");
		}

	}

}
