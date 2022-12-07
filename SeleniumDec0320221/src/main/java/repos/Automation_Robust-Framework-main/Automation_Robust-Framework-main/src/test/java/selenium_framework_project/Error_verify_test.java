package selenium_framework_project;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import selenium_framework_pageobjects.Cartpage;
import selenium_framework_pageobjects.ProductCatalogue;
import selenium_framework_testComponents.BaseTest;
import selenium_framework_testComponents.Retry_testng;

public class Error_verify_test extends BaseTest {
	@Test(groups="ErrorHandling",retryAnalyzer=Retry_testng.class)
	public void Login_error() throws InterruptedException {
		Thread.sleep(3000);
		landingPage.loginApplication("srilekha12@gmail.com", "@Srilekha18");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	@Test()
	public void  ProductValidation() throws  IOException,InterruptedException  {
		String productName = "ZARA COAT 3";
		
		ProductCatalogue productCatalogue=landingPage.loginApplication("rahulshetty@gmail.com", "Iamking@000");
	
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		Cartpage cartPage =productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
	}
	
	

}
