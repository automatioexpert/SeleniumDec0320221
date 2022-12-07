/**
 * 
 */
package dataDrivenFwk;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelUtility.ExcelDataConfig;


/**
 * @author anand acharya
 * login to facebook using data driven framework
 */
public class LoginPage {

	/**
	 * @param args
	 */
WebDriver driver;
	
	@Test(dataProvider="facebooklogin")
	public void FacebookLoginExcel(String username, String password) throws Exception {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(ffprofile);
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(12000);
		Assert.assertTrue(driver.getTitle().contentEquals("Facebook"),"Invalid login Crendentials");
		System.out.println("Succesful login");

	}

	@DataProvider(name="facebooklogin")
	public Object[][] passData() throws Exception
	{
		ExcelDataConfig excel = new ExcelDataConfig(System.getProperty("user.dir")+"/excelData/datadriven_data.xlsx");
		
		int rowcount = excel.getRows(0);
		
		Object[][] data = new Object[rowcount][2];
		
		for(int i=0;i<rowcount;i++) //make i=1 if excel data has header rows that should not be read
		{
			data[i][0] = excel.getData(0, i, 0);
			data[i][1] = excel.getData(0, i, 1);
		}
		
		return data;
	}
	
	/*@AfterMethod
	public void teardown()
	{
		driver.quit();
	}*/
	

}
