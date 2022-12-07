package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPageObjects;

import java.util.concurrent.TimeUnit;

public class ParabankTestCases {

    WebDriver driver = null;
    String url = "https://parabank.parasoft.com/parabank/index.htm";
    String userName = "john";
    String password = "demo";

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize browser window
        driver.manage().deleteAllCookies(); // delete all cookies
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // set a maximum timeout for searching out the WebElements before throwing an exception
        driver.get(url);
    }

    @After
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void t_01_validate_parabank_login_success(){
        LoginPageObjects loginPageObjects = new LoginPageObjects(driver);
        loginPageObjects.enterUserName(userName);
        loginPageObjects.enterPassword(password);
        loginPageObjects.clickLoginButton();
        loginPageObjects.validatePageTitle("ParaBank | Accounts Overview");
        loginPageObjects.validateAccountTableIsDisplayed();
    }

   @Test
    public void t_02_enter_no_user_name_and_password(){
        LoginPageObjects loginPageObjects = new LoginPageObjects(driver);
        loginPageObjects.enterUserName("");
        loginPageObjects.enterPassword("");
        loginPageObjects.clickLoginButton();
        loginPageObjects.validateErrorMsgAsEnterUserNameAndPasswordIsDisplayed();

    }

}
