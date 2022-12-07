package com.tests;

import static com.reports.ExtentTestManager.startTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import java.lang.reflect.Method;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.listeners.TestListener;

//In order to eliminate attachment problem for Allure, you should add @Listener line.
//link: https://github.com/allure-framework/allure1/issues/730
@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login Tests")

public final class LoginTests extends BaseTest {
	
	@Test(priority = 0, description = "Invalid Login Scenario with wrong username and password.")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Login test with wrong username and wrong password.")
	@Story("Invalid username and password login test")
	public void invalidLoginTest_InvalidUserNameInvalidPassword(Method method) {
		startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");

		homePage.goToN11()
				.goToLoginPage()
				.loginToN11("onur@swtestacademy.com", "11122233444")
				.verifyLogError();
	}

	@Test(priority = 1, description = "Invalid Login Scenario with empty username and password.")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Login test with empty username and empty password.")
	@Story("Empty username and password login test")
	public void invalidLoginTest_EmptyUserEmptyPassword(Method method) {
		startTest(method.getName(), "Invalid Login Scenario with empty username and password.");

		homePage.goToN11().goToLoginPage()
						  .loginToN11("", "")
						  .verifyLoginUserName("Lütfen e-posta adresinizi girin.")
						  .verifyLoginPassword("WRONG MESSAGE FOR FAILURE!");
	}
}
