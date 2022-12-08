package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "username")
    WebElement txtUserName;
    @FindBy(css = "[type=password]")
    WebElement txtPassword;
    @FindBy(css = "[type=submit]")
    WebElement btnSubmit;

    @FindBy(tagName = "h6")
    public WebElement AssertLoginSuccessful;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void doLogin(String adminUser, String adminPassword){

        txtUserName.sendKeys(adminUser);
        txtPassword.sendKeys(adminPassword);
        btnSubmit.click();

    }

}
