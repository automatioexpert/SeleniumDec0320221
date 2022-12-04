package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest {

	@Test(priority = 1)
	public void logoTest() {
		boolean flag = driver.findElement(By.cssSelector("img[title='naveenopencart']")).isDisplayed();
		Assert.assertEquals(flag, true);
	}

	@Test(priority = 3)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(driver.findElement(By.linkText("Forgotten Password11")).isDisplayed());
	}

	@Test(priority = 2)
	public void loginNegativeTest() {
		driver.findElement(By.id("input-email")).sendKeys("testselenium123666@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String errorMesg = driver.findElement(By.cssSelector("div.alert-dismissible")).getText().trim();
		System.out.println(errorMesg);

		Assert.assertEquals(errorMesg, "Warning: No match for E-Mail Address and/or Password.");
	}

}
