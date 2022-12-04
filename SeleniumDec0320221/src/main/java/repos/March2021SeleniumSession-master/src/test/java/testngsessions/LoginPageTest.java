package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{

	@Test
	public void accountPageTitleTest() {
		String title = driver.getTitle();
		System.out.println("page title is : " + title);
		Assert.assertEquals(title, "Account Login");
	}

	@Test
	public void registerLinkTest() {
		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
	}

}
