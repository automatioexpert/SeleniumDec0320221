package base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utils.ExcelReader;
import utils.ExtentManager;

public class BaseClass {
	
	
	public static WebDriver driver = null;
	Properties config = null;
	public static Properties objectRepo = null;
	FileInputStream fis = null;
	FileInputStream fis2 = null;
	Map<String,String> data =  new HashMap();
	Logger logger = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports repo = ExtentManager.getInstance();
	public static ExtentTest test;

	public Map getDriverString() throws IOException {
		config = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		data.put("browser",config.getProperty("browser"));
		data.put("url",config.getProperty("testsiteurl"));
		return data;
		
	}
	
	
	@BeforeSuite
	public void setUp() {
		
		String webdriverString = null;
		String url = null;
		try {
			webdriverString =  (String) getDriverString().get("browser");
			url =  (String) getDriverString().get("url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if(webdriverString.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			
			driver = new ChromeDriver();
			logger.debug("Chrome is Launched!!");
			
		}else if(webdriverString.equalsIgnoreCase("firefox")){
			driver  = new FirefoxDriver();
			logger.debug("Firefox is Launched!!");

		}else {
			System.out.println("Driver is Not Mentioned in the Properties File");
			
		}
		
		
		
		
		
		
		try {
			fis2 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objectRepo =  new Properties();
		try {
			objectRepo.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		logger.debug("Open URL!! - "+url);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 1);
		
	}
	
	@AfterSuite
	public void tearDown() {
		try {
		if(driver!=null){
					driver.quit();
		  		}
		
		}catch(Exception e){
			
		}
		
	}
	
	
	

}
