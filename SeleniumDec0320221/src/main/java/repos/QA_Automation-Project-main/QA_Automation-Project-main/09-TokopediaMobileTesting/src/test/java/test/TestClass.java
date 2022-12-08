package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;

public class TestClass extends BaseClass {

	@Test(priority=1)
	public void onBoardingPage() throws Exception {
		Thread.sleep(1000);
		// Mobile Element
		MobileElement GabungSekarangBtn = driver.findElement(By.id("com.tokopedia.tkpd.df_base:id/buttonGlobalDynamicOnbaording"));
		MobileElement LewatiSekarangBtn = driver.findElement(By.id("com.tokopedia.tkpd.df_base:id/skipDynamicOnbaording"));
		MobileElement SelanjutnyaBtn = driver.findElement(By.id("com.tokopedia.tkpd.df_base:id/nextDynamicOnbaording"));
		
		//Assert
		assertTrue(GabungSekarangBtn.isDisplayed());
		assertTrue(LewatiSekarangBtn.isDisplayed());
		assertTrue(SelanjutnyaBtn.isDisplayed());

	}
	
	@Test(priority=2)
	public void homePage() throws Exception {
		// Mobile Element
		MobileElement LewatiBtn = driver.findElement(By.id("com.tokopedia.tkpd.df_base:id/skipDynamicOnbaording"));
		LewatiBtn.click();
		
		Thread.sleep(1000);
		MobileElement HomeBtn = driver.findElement(By.id("com.tokopedia.tkpd:id/menu_home"));
		//Assert
		assertTrue(HomeBtn.isDisplayed());

	}
	
	@Test(priority=3)
	public void SearchBar() throws Exception {
		// Mobile Element
		MobileElement Search = driver.findElement(By.id("com.tokopedia.tkpd:id/et_search"));
		Search.click();
		
		Thread.sleep(1000);
		MobileElement SearchView = driver.findElement(By.id("com.tokopedia.tkpd:id/searchTextView"));
		SearchView.sendKeys("ipad pro");
		
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();

		//Price Product
		Thread.sleep(1000);
		List<MobileElement> PriceView = driver.findElements(By.id("com.tokopedia.tkpd:id/textViewPrice"));
		
		//Assert
		assertNotNull(PriceView);

	}
	

}
