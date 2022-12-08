package testRunner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class EmployeeTestRunner extends Setup {

    LoginPage loginPage;
    EmployeePage employeePage;

    @BeforeTest
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
        Thread.sleep(1000);

    }

    @Test(priority = 1, description = "Check if user is Exist or not")
    public void checkIfUserExist() throws IOException, ParseException, InterruptedException {
        EmployeePage employeePage = new EmployeePage(driver);
        employeePage.pim.get(1).click();
        employeePage.addButton.get(2).click();
        Thread.sleep(3000);
        employeePage.toggleButton.click();
        List employee = Utils.readJsondata("./src/test/resources/employee.json");
        JSONObject userObj = (JSONObject) employee.get(employee.size() - 1);
        String existingUserName = (String) userObj.get("userName");
        Thread.sleep(1000);
        String validationMessageActual = employeePage.checkIfUserExist(existingUserName);
        String validationMessageExpected = "Username already exists";

        Assert.assertTrue(validationMessageActual.contains(validationMessageExpected));
        Thread.sleep(1000);
    }


    @Test(priority = 2, description = "Admin Can create Employee")
    public void createEmployee() throws InterruptedException, IOException, ParseException {

        employeePage = new EmployeePage(driver);
        Utils utils = new Utils();

        for (int i = 0; i < 2; i++) {
            employeePage.addEmployee.get(2).click();
            Thread.sleep(1000);

            utils.generateRandomData();
            String firstName = utils.getFirstname();

            String lastName = utils.getLastname();

            String randomEmployeeId = String.valueOf(Utils.generateRandomNumber(1000, 9999));
            employeePage.txtUserCred.get(4).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
            String employeeId = randomEmployeeId;
            Thread.sleep(3000);

            employeePage.toggleButton.click();
            Thread.sleep(1000);

            int randomUserId = Utils.generateRandomNumber(1000, 9999);
            employeePage.txtUserCred.get(5).sendKeys(Keys.CONTROL + "a");
            employeePage.txtUserCred.get(5).sendKeys(Keys.BACK_SPACE);
            String userName = utils.getFirstname() + randomUserId;

            String password = "Password@1234";

            String confirmPassword = password;


            employeePage.createEmployee(firstName, lastName, userName, password, confirmPassword, employeeId);
            Thread.sleep(3000);


            Utils.waitForElement(driver, employeePage.headerTitle.get(0), 50);
            if (employeePage.headerTitle.get(0).isDisplayed()) {
                utils.saveJsonList(userName, password, employeeId);


                //Assertion
                String actualResult = employeePage.AssertCreateEmployee.get(2).getText();
                String expectedResult = "Personal Details";
                Assert.assertTrue(actualResult.contains(expectedResult));
                Thread.sleep(2000);

            }

        }
    }

    @Test(priority = 3, description = "Searching with Invalid Employee Id")
    public void searchInvalidEmployeeId() throws InterruptedException {

        employeePage = new EmployeePage(driver);

        employeePage.pim.get(1).click();
        Thread.sleep(1000);

        String randomEmployeeId = String.valueOf(Utils.generateRandomNumber(1000, 9999));
        employeePage.txtUserCred.get(1).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        String employeeId = randomEmployeeId;
        employeePage.searchEmployeeById(employeeId);
        Thread.sleep(2000);


        //Assertion
        String DataActual = employeePage.AssertSearchInvalidId.get(13).getText();
        String DataExpected = "No Records Found";
        Assert.assertTrue(DataActual.contains(DataExpected));
        Thread.sleep(1000);

    }


    @Test(priority = 4, description = "Searching with valid Employee Id")
    public void searchEmployeeById() throws IOException, ParseException, InterruptedException {

        String file = "./src/test/resources/employee.json";

        List employees = Utils.readJsondata(file);

        employeePage = new EmployeePage(driver);
        employeePage.txtUserCred.get(1).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        JSONObject employeeObject1 = (JSONObject) employees.get(employees.size() - 1);
        String employeeId1 = (String) employeeObject1.get("employeeId");
        employeePage.searchEmployeeById(employeeId1);
        Thread.sleep(5000);


        //Assertion
        String actualId1 = employeePage.searchResultId.get(1).getText();
        String expectedId1 = (String) employeeObject1.get("employeeId");
        Assert.assertTrue(actualId1.contains(expectedId1));


        employeePage.txtUserCred.get(1).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        JSONObject employeeObject2 = (JSONObject) employees.get(employees.size() - 2);
        String employeeId2 = (String) employeeObject2.get("employeeId");
        employeePage.searchEmployeeById(employeeId2);
        Thread.sleep(2000);


        //Assertion
        String actualId2 = employeePage.searchResultId.get(1).getText();
        String expectedId2 = (String) employeeObject2.get("employeeId");
        Assert.assertTrue(actualId2.contains(expectedId2));

    }
}
