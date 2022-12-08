package testRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import setup.Setup;

public class DashboardTestRunner extends Setup {

    DashboardPage dashboardPage;
    LoginPage loginPage;

    @Test(priority = 1, description = "User Can Not Login with Wrong Credentials")
    public void doLoginWithWrongCreds() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com");
        loginPage = new LoginPage(driver);

        String adminUser = "Admin";
        String adminPassword = "admin12345";

        loginPage.doLogin(adminUser, adminPassword);

        String actualErrorMessage = driver.findElement(By.className("oxd-alert-content-text")).getText();
        String expectedErrorMessage = "Invalid credentials";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Thread.sleep(2000);

    }


    @Test(priority = 2,description = "user can login with Valid credentials")
    public void doLogin() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com");
        loginPage = new LoginPage(driver);

        String adminUser = "Admin";
        String adminPassword = "admin123";
        Thread.sleep(1000);

        loginPage.doLogin(adminUser, adminPassword);
        Thread.sleep(3000);


        //Assertion

        String actualResult = loginPage.AssertLoginSuccessful.getText();
        String expectedResult = "Dashboard";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test(priority = 3, description = "Dashboard Page is Routed")
    public void dashboardTexAssertion() {

        dashboardPage = new DashboardPage(driver);

        String actualText = dashboardPage.txtDashboard.getText();
        String expectedText = "Dashboard";

        Assert.assertTrue(actualText.contains(expectedText));
    }

    @Test(priority = 4, description = "Checking the Profile Image is Exist or not")
    public void isImageProfileExist() {

        Assert.assertTrue(dashboardPage.imgProfile.isDisplayed());

    }

    @Test(priority = 5, description = "Time Sheets option is Clickable or not")
    public void timeSheetsOptionCLickable() throws InterruptedException {

        WebElement option = dashboardPage.timeSheetsOption.get(0);
        option.click();
        Thread.sleep(3000);

        String actualText = dashboardPage.txtRecruitment.getText();
        String expectedText = "Time";

        Assert.assertTrue(actualText.contains(expectedText));
        Thread.sleep(1000);

    }

}
