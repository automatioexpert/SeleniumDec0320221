package com.LW.generics;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.LW.Pom.Login;
import com.LW.Pom.Logout;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;




public class LWBaseClass {

	public FirefoxOptions options1;
	public ChromeOptions options;
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public SoftAssert sa;
	public Actions actions ;
	public ExtentReports extent;
	public ExtentTest ExtentTest;
	public LWFilelibrary f = new LWFilelibrary();

	static {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriverManager.firefoxdriver().setup();
		
		WebDriverManager.edgedriver().setup();
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Active37\\git\\lawyer-wangu-Mavens\\LawyerWanguMavan\\src\\main\\resources\\drivers\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "/driver/geckodriver");
		//System.getProperty("webdriver.edge.driver", "/driver/msedgedriver");
	}


	@BeforeTest

	// @Parameters("browser")
	public void openBrowser() throws Exception {

		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);
		extent.addSystemInfo("Host Name", "ActiveMac03");
		extent.addSystemInfo("User Name", "Abhay Mac");
		extent.addSystemInfo("OS", "Mac OS X");
		extent.addSystemInfo("Enviroment", "QA");
		extent.addSystemInfo("Java Version", "14.0.2");
		
		options = new ChromeOptions();

		options1 = new FirefoxOptions();

		options1.addArguments("--disable-notifications");
		options.addArguments("--disable-notifications");
		
		String url = f.getPropertyData("url");

		/*
		 * String browser = f.getPropertyData("browser");
		 * 
		 * if (browser.equalsIgnoreCase("chrome")) {
		 * 
		 * driver = new ChromeDriver(options);
		 * 
		 * }
		 * 
		 * else if (browser.equalsIgnoreCase("firefox")) {
		 * 
		 * driver = new FirefoxDriver(options1);
		 * 
		 * } else if (browser.equals("safari")) { driver = new EdgeDriver(); //driver =
		 * new SafariDriver(); }
		 */
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); //Selenium 4
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Selenium 4

		actions = new Actions(driver);
		
		wait = new WebDriverWait(driver,20);//Selenium 3
		
		//wait = new WebDriverWait(driver,Duration.ofSeconds(10));//Selenium 4
		
		js = (JavascriptExecutor) driver;

		sa = new SoftAssert();
		driver.get(url);
	}



	@AfterTest
	public void closeBrowser() throws InterruptedException {
		
		Thread.sleep(500);
		
		extent.flush();
		extent.close();
		driver.close();
		Thread.sleep(200);
		sa.assertAll(); 

	}

	public static String getScreenShot(WebDriver driver , String ScreenShotName) throws IOException {
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot t=(TakesScreenshot) driver;

		File src = t.getScreenshotAs(OutputType.FILE);

		String dest=System.getProperty("user.dir")+"/FailedTestScreenShots/"+ScreenShotName+dateName+".png";

		File FinalDest = new File(dest);

		FileUtils.copyFile(src,FinalDest);
		
		return dest;



	}

	@BeforeMethod


	  public void login() throws IOException, InterruptedException {
		
	  Thread.sleep(1000);
	  String un = f.getPropertyData("username");
	  String pw =f.getPropertyData("password");
	  Login l=new Login(driver); 
	 
	  l.setLogin(un,pw);
	  
	  Thread.sleep(4000);
	  
	  }

	@AfterMethod
	public void LWUtility(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {

			ExtentTest.log(LogStatus.FAIL, "Test Case faild is"+ result.getName());//to add name in extend report

			ExtentTest.log(LogStatus.FAIL, "Test Case faild is"+ result.getThrowable());//to add error/exception in extend report

			//TenderUtility.captureScreenshot(driver, result.getName());

			String getScreenShot = LWBaseClass.getScreenShot(driver,result.getName());
			
			ExtentTest.log(LogStatus.FAIL,ExtentTest.addScreenCapture(getScreenShot));//to add screenshot in extend report
			
			//ExtentTest.log(LogStatus.FAIL,ExtentTest.addScreencast(getScreenShot));//to add screenshot in extend report
		}
		else if(result.getStatus()==ITestResult.SKIP) {

			ExtentTest.log(LogStatus.SKIP, "Test Case Skipped is"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {

			ExtentTest.log(LogStatus.PASS, "Test Case Passed is"+result.getName());
		}
		
		extent.endTest(ExtentTest);//ending test and ends the current test and prepare to create html report
	}


	

	@AfterMethod
	public void logout() throws InterruptedException  {
		Logout lg=new Logout(driver);
		Thread.sleep(300);
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//a[.=\"Sign Out\"]")));
		lg.Setlogout();
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//a[.=\"Log In\"]")));
		
		lg.logins();

	}


}




