package testSauceDemo;
import org.testng.annotations.Test;

import pagefiles_SauceDemo.CheckoutPage;
import pagefiles_SauceDemo.CompleteCheckout;
import pagefiles_SauceDemo.LoginPage;
import pagefiles_SauceDemo.ProductsPage;
import pagefiles_SauceDemo.UserInfoPage;
import testBase.testBase;
import utililty.*;


public class TestValidCompleteFlow extends testBase{
	
	
	@Test(priority = 1)
	public void validloginpage() throws Exception
	{ 
	    
		LoginPage loginpage = new LoginPage();
		test.get().info("Navigated to Url");
		Thread.sleep(2000);
		
		loginpage.sendUsername(ReadProperties.getData("UserName"));
		Thread.sleep(2000);
		test.get().info("Standard User Username Entered");
		loginpage.sendPassword(ReadProperties.getData("Password"));
		
		Thread.sleep(2000);
		test.get().info("Password Entered");
		loginpage.Login();
		test.get().info("Clicked Login");
	}
	
	@Test(priority = 2)
	public void addProductToCart() throws Exception {
	ProductsPage Prdpage = new ProductsPage();
	test.get().info("Navigated to Product Page");
	Thread.sleep(2000);
	Prdpage.clickBackpack();
	
	Thread.sleep(2000);
	test.get().info("Selected BackPack");
	Prdpage.clickAdd_to_Cart();
	
	Thread.sleep(2000);
	test.get().info("BackPack Added to Cart");
	test.get().addScreenCaptureFromPath(TakeSnap.capturescreen("BackPack Added to Cart_"+timeStamp+".png"));
	Prdpage.clickShopping_cart_link();
	test.get().info("Clicked on Cart");
	Thread.sleep(2000);
	Prdpage.clickCheckout();
	test.get().info("Clicked Checkout");

}

	@Test(priority = 3)
	public void enterUserInfo() throws Exception
	{
	   
		UserInfoPage uip = new UserInfoPage();
		test.get().info("Navigated to User Info Page");
		
		uip.sendFirstName(ReadProperties.getData("firstname"));
		Thread.sleep(2000);
		test.get().info("Entered First Name");
		uip.sendLastName(ReadProperties.getData("lastname"));
		Thread.sleep(2000);
		test.get().info("Entered Last Name");
		uip.sendPostCode(ReadProperties.getData("postalcode"));
		Thread.sleep(2000);
		test.get().info("Entered Postal Code");
		test.get().addScreenCaptureFromPath(TakeSnap.capturescreen("UserDetails_"+timeStamp+".png"));
		uip.clickContinue();
		test.get().info("Clicked Continue");
		
	}
	
	@Test(priority = 4)
	public void Checkout() throws Exception
	{
	    
		CheckoutPage chk = new CheckoutPage();
	    test.get().info("Navigated to Checkout Page");
		chk.ScrollTotal();
		
		chk.ValidateTotal();
		test.get().info("Validated Total");
		Thread.sleep(1000);
		test.get().addScreenCaptureFromPath(TakeSnap.capturescreen("Validated Total_"+timeStamp+".png"));
		chk.clickFinish();
		test.get().info("Clicked on Finish");
		
	}
	
	@Test(priority = 5)
	public void completeCheckout() throws Exception
	{
		
		CompleteCheckout compchk = new CompleteCheckout();
		test.get().info("Navigated to Checkout Complete");
		compchk.ValidateCheckout();
		test.get().info("Validated Checkout Message");
		test.get().addScreenCaptureFromPath(TakeSnap.capturescreen("Validated Checkout_"+timeStamp+".png"));
		Thread.sleep(1000);
		compchk.Logout();
		test.get().info("Logout Successfully");
	
	}
}