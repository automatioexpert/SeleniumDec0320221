package IFrame;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IFrameTest {

	WebDriver driver;
	WebDriverWait wait;

	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void setUp(String browser, String url) {
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Test Suite/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/Test Suite/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@Parameters("expectedTitle") // Login to Application as an Already Existing User
	// @Test(priority = 5)
	public void ValidateIFrameinFinanzen(String expectedTitle) {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jaykishore999@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("bonify@123");
		driver.findElement(By.xpath("//button[@type='submit']//div[@class='ripple-wrapper']")).click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Angebote')]")))
				.click();

		driver.findElement(By
				.xpath("//li[contains(@id,'/my-products/financial-products')]//div[contains(@class,'ripple-wrapper')]"))
				.click();

		List<WebElement> total_frames = driver.findElements(By.tagName("iframe"));
		int Size = total_frames.size();
		System.out.println("Total Number of iFrames in Application is:" + Size);

		// Handling IFrame
		WebElement iframeElement = driver.findElement(By.xpath("//*[@id=\"main-body\"]/div[2]/section/section/iframe"));
		driver.switchTo().frame(iframeElement);// Login to First Frame

		// Second Frame ID is @id="vxcp_frame"
		driver.switchTo().frame("vxcp_frame");// Login to Second Frame

		driver.findElement(By.xpath("//input[contains(@name,'umsatzeuroland')]")).clear();
		driver.findElement(By.xpath("//input[contains(@name,'umsatzeuroland')]")).sendKeys("1000");

		driver.findElement(By.xpath("//input[contains(@name,'umsatznichteuroland')]")).clear();
		driver.findElement(By.xpath("//input[contains(@name,'umsatznichteuroland')]")).sendKeys("500");

		Select cardtype = new Select(driver.findElement(By.name("kartengesellschaft")));
		cardtype.selectByVisibleText("Visa");

		Select Status = new Select(driver.findElement(By.name("anzeige")));
		Status.selectByValue("2");

		Select Payment = new Select(driver.findElement(By.name("zahlungsart")));
		Payment.selectByValue("3");

		driver.findElement(By.xpath("//input[contains(@name,'submit')][@class='btn fa_button_submit btn-block']"))
				.click();

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div[2]/section/div/div/div[3]/div/div[2]/a"))).click();

		String Parentwindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String currentwindow : allWindows) {
			if (!Parentwindow.equalsIgnoreCase(currentwindow)) {
				driver.switchTo().window(currentwindow);
			}
		}
		driver.close();
		driver.switchTo().window(Parentwindow);

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[contains(text(),'Einstellungen')]")).click();

		WebElement Element = driver.findElement(By.xpath("//*[@id='main-body']//ul[1]//li[4]//button//span"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Element);

		String ActualTitle = driver.getTitle();
		String ExpectedTitle = expectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	@Parameters("href")
	@Test(priority = 6)
	public void ValidateIFrameinMobilFunk(String href) {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jaykishore999@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("bonify@123");
		driver.findElement(By.xpath("//button[@type='submit']//div[@class='ripple-wrapper']")).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Angebote')]")))
				.click();

		driver.findElement(
				By.xpath("//li[contains(@id,'/my-products/mobile')]//div[contains(@class,'ripple-wrapper')]")).click();

		List<WebElement> total_frames = driver.findElements(By.tagName("iframe"));
		int Size = total_frames.size();
		System.out.println("Total Number of iFrames in Application is:" + Size);

		// Handling IFrame
		WebElement iframeElement = driver.findElement(By.xpath("//*[@id=\"main-body\"]/div[2]/section/section/iframe"));
		driver.switchTo().frame(iframeElement);// Login to First Frame */

		// Go to Second Frame ID
		WebElement iframe_Element = driver.findElement(By.xpath(
				"//iframe[contains(@src,'https://tools.communicationads.net/calc.php?tp=dif&cl=bundle&h=1&wf=10865&country=DE&subid=')]"));
		driver.switchTo().frame(iframe_Element);// Login to Second Frame

		Select deviceID = new Select(driver.findElement(By.id("deviceid")));
		deviceID.selectByValue("183");

		Select devicememory = new Select(driver.findElement(By.id("device_memory")));
		devicememory.selectByVisibleText("Ab 256 GB");

		Select phonevolume = new Select(driver.findElement(By.name("phone_volume")));
		phonevolume.selectByValue("250");

		Select numberport = new Select(driver.findElement(By.name("numberporting")));
		numberport.selectByValue("1");

		Select colorID = new Select(driver.findElement(By.id("device_colorid")));
		colorID.selectByVisibleText("Gold");

		Select cost = new Select(driver.findElement(By.name("cost_setup_max")));
		cost.selectByValue("300");

		Select volume = new Select(driver.findElement(By.name("mobileweb_volume")));
		volume.selectByVisibleText("Ab 2 GB");

		driver.findElement(By.name("submit")).click();

		// To get and select the correct Product Item in the list for the links available - Tag 'a' and href.
		List<WebElement> Links = driver.findElements(By.xpath("//a[contains(@href,'product=31924370&subid=389179')]"));
		// Total Number of links
		int Linkcount = Links.size();
		System.out.println("Linkcount is :" + Linkcount);
		String[] Texts = new String[Linkcount];
		for (int i = 0; i < Linkcount; i++) {
			// Get the name of the link
			Texts[i] = Links.get(i).getText();
			System.out.println(i + ":" + "Link name is:" + Texts[i]);
			if (Texts[i].equalsIgnoreCase(href)) {
				driver.findElement(By.linkText(Texts[1])).click();
				System.out.println("Text Name: " + Texts[i]);
			}
		}
		String Parentwindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String currentwindow : allWindows) {
			if (!Parentwindow.equalsIgnoreCase(currentwindow)) {
				driver.switchTo().window(currentwindow);
			}
		}
		driver.close();
		driver.switchTo().window(Parentwindow);

		driver.switchTo().defaultContent();
		WebElement Element = driver.findElement(By.xpath("//*[@id='main-body']//ul[1]//li[4]//button//span"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Element);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
