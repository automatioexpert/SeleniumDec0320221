/**
 * 
 */
package cricbuzz;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * @author anand acharya
 * Main class to instantiate the properties files and run tests with static methods
 */
public class Main {
	WebDriver driver;
	Properties p;
	Properties xpath;
	
	@BeforeTest
	public void navigate()
	{
		//create object of path properties file
		p = new Properties();
		//create file reader object to read the path properties file
		FileReader i = null;
		try {
			i = new FileReader(System.getProperty("user.dir")+"/properties/path.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//load the path properties file
		try {
			p.load(i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create object of xpath properties file
		xpath = new Properties();
		//create file reader object to read the xpath properties file
		FileReader j = null;
		try {
			j = new FileReader(System.getProperty("user.dir")+"/properties/xpath.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//load the xpath properties file
		try {
			xpath.load(j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//identify the required browser from the path properties file
		switch(p.getProperty("browser").toLowerCase())
		{
		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			FirefoxProfile ffprofile = new FirefoxProfile();
			ffprofile.setPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(ffprofile);
			break;
			
		case "chrome":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
	}
	
	//Execute the test by calling methods for each page
	@Test
	public void test1() throws Exception
	{
		HomePage.teams(driver, xpath);
		HomePage.australia(driver, xpath);
		Matches.results(driver, xpath);
		MatchDetails.firstmatch(driver, xpath);
		MatchScorecard.viewScorecard(driver, xpath);		
	}
	
	@Test
	public void test2() throws InterruptedException
	{
		HomePage.teams(driver, xpath);
		HomePage.india(driver, xpath);
		Matches.results(driver, xpath);
		MatchDetails.firstmatch(driver, xpath);
		MatchScorecard.viewScorecard(driver, xpath);
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
		driver.quit();
	}
}
