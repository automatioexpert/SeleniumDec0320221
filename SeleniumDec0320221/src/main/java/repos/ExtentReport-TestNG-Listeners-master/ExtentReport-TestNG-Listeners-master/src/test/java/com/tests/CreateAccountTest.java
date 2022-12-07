package com.tests;

import com.google.base.ExtentTestManager;
import com.google.base.TestBase;
import com.google.pages.BasePage;
import com.google.pages.CreateAccountPage;
import com.google.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;
    private CreateAccountPage createAccountPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Test
    public void verifyCreateAnAccountPage() {
        System.out.println("Create An Account page test...");
        ExtentTestManager.getTest().assignAuthor("QA Tester 2").assignCategory("Create Account Test");
        basePage = new BasePage(driver);
        signInPage = basePage.clickSignInBtn();
        createAccountPage = signInPage.clickonCreateAnAccount();
        Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
        Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");

    }

    @Test
    public void createAccountExample1() {
        System.out.println("Hey im in example1 test");
        ExtentTestManager.getTest().assignAuthor("QA Tester 2").assignCategory("Create Account Test");
    }

    @Test
    public void createAccountExample2() {
        System.out.println("Hey im in Example2 test");
        ExtentTestManager.getTest().assignAuthor("QA Tester 2").assignCategory("Create Account Test");
    }
}
