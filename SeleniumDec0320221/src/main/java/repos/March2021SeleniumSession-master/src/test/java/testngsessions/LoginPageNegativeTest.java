package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageNegativeTest extends BaseTest{
	
	//paramterization of test
	//data driven approach using data provider
	
	@DataProvider()
	public Object[][] loginNegativeData() {
		return new Object[][]  {
			{"test@gmail.com", "test@123"},
			{" " , "test@123"},
			{"test@gmail.com" , " "},
			{" ", " "},
			{"",""}
					};	
					
	}
	
	
	@Test(dataProvider = "loginNegativeData")
	public void doLogin(String username, String password) {
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(username);
		
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(
				driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible"))
				.isDisplayed());
	}

}
