package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

	public void doLogin() {
		driver.findElement(By.id("input-email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Test
	public void homePageTitleTest() {
		doLogin();
		String title = driver.getTitle();
		System.out.println("page title is : " + title);
		Assert.assertEquals(title, "My Account");
	}

}
