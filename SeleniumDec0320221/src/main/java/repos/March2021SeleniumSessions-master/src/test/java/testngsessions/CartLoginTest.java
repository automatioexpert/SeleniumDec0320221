package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartLoginTest extends BaseTest {

	@DataProvider
	public Object[][] loginTestData() {
		return new Object[][]  {
			{"test@gmail.com", "test@123"},
			{" " , "test@123"},
			{" ", " "}
					};	
	}
	
	@Test(dataProvider = "loginTestData")
	public void loginTest(String userName, String password) {
		Assert.assertTrue(doLogin(userName, password));
	}

	public boolean doLogin(String un, String pwd) {
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(un);
		
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String error = driver.
				findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible"))
					.getText();
		if (error.contains("No match for E-Mail Address and/or Password")) {
			return true;
		}
		return false;

	}

}
