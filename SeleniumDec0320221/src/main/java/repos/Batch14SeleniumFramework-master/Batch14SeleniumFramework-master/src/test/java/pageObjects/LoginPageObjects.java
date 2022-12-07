package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

    // Step 1: Declare a driver
    private WebDriver driver;

    //Step 2: Param Cons
    public LoginPageObjects(WebDriver driver){
        this.driver = driver;
    }

    //Step 3 : Locator def
    private By userName = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.xpath("//input[@value='Log In']");
    private By accountTable = By.id("accountTable");
    private By errorMessageLocator =  By.xpath("//p[text()='Please enter a username and password.']");

    // Step 4: Methods to perform ops
    public void enterUserName(String arg){
        driver.findElement(userName).sendKeys(arg);
    }

    public void enterPassword(String arg){
        driver.findElement(password).sendKeys(arg);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void validatePageTitle(String expected){
        Assert.assertEquals(expected,driver.getTitle());
    }

    public void validateAccountTableIsDisplayed(){
        boolean actualTableDisplayed = driver.findElement(accountTable).isDisplayed();
        Assert.assertEquals(true,actualTableDisplayed);
    }

    public void validateErrorMsgAsEnterUserNameAndPasswordIsDisplayed(){
        WebElement errorMessage = driver.findElement(errorMessageLocator);
        Assert.assertEquals(true,errorMessage.isDisplayed());

    }





}
