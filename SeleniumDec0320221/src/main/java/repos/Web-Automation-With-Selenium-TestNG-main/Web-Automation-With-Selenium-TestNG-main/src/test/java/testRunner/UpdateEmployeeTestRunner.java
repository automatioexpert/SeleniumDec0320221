package testRunner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UpdateEmployeePage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class UpdateEmployeeTestRunner extends Setup {

    UpdateEmployeePage updateEmployeePage;

    @BeforeTest
    public void doLogin() throws IOException, ParseException, InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com");
        Thread.sleep(3000);
        List data = Utils.readJsondata("./src/test/resources/employee.json");
        LoginPage loginPage = new LoginPage(driver);
        JSONObject userObj = (JSONObject) data.get(data.size() - 1);
        String userName = (String) userObj.get("userName");
        String password = (String) userObj.get("password");
        Thread.sleep(1000);
        loginPage.doLogin(userName, password);

    }

    @Test(priority = 1, description = "Updating the User Information")
    public void updateEmployeeInfo() throws InterruptedException {

        updateEmployeePage = new UpdateEmployeePage(driver);

        updateEmployeePage.myInfo.get(2).click();
        Thread.sleep(2000);

        Utils.waitForElement(driver, updateEmployeePage.headerTitle.get(0), 50);
        if (updateEmployeePage.headerTitle.get(0).isDisplayed()) {
            updateEmployeePage = new UpdateEmployeePage(driver);
            updateEmployeePage.EditNationality.get(0).click();
            updateEmployeePage.EditNationality.get(0).sendKeys("b");
            updateEmployeePage.EditNationality.get(0).sendKeys(Keys.ARROW_DOWN);
            updateEmployeePage.EditNationality.get(0).sendKeys(Keys.ARROW_DOWN);
            updateEmployeePage.EditNationality.get(0).sendKeys(Keys.ENTER);
            Thread.sleep(2000);

            updateEmployeePage.dateUpdate.get(0).click();
            Thread.sleep(1000);
            updateEmployeePage.dateUpdate.get(0).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
            updateEmployeePage.dateUpdate.get(0).sendKeys("2022-11-19");
            updateEmployeePage.dateUpdate.get(0).click();
            Thread.sleep(2000);

            updateEmployeePage.genderUpdate.get(0).click();
            Thread.sleep(2000);


            //Assertion

//            String actualDate = updateEmployeePage.dateUpdate.get(0).getText();
//            String expectedDate  = "2022-11-19";
//            Assert.assertTrue(actualDate.equals(expectedDate));
//            Thread.sleep(1000);

            String actualNationality = updateEmployeePage.AssertNatinality.get(0).getText();
            String expectedNationality = "Bangladeshi";

            Assert.assertTrue(actualNationality.contains(expectedNationality));
            Thread.sleep(1000);

            Assert.assertTrue(updateEmployeePage.genderUpdateAssertion.get(0).isEnabled());
            Thread.sleep(1000);

            Utils.doScroll(driver);
            updateEmployeePage.btnSubmit.get(1).click();

        }

    }

    @AfterTest
    public void logout(){
        updateEmployeePage = new UpdateEmployeePage(driver);
        updateEmployeePage.logout.click();
        driver.findElement(By.partialLinkText("Logout")).click();

    }
}
