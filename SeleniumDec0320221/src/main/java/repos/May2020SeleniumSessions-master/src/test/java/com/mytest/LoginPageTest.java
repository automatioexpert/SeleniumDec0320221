package com.mytest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

	@Test
	public void getGoogleTitleTest() {
		Assert.assertEquals(driver.getTitle(), "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

}
