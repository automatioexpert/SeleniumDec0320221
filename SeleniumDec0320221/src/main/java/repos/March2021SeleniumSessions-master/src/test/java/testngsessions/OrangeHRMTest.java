package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest{

	@Test(priority = 2)
	public void orangeHRMTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Free Human Resource Management Software | 30 Day Trial Creation");
	}

	@Test(priority = 1)
	public void logoTest() {
		Assert.assertEquals(driver.findElement(By.className("nav-logo")).isDisplayed(), true);
	}

}
