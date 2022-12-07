package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class LoginFormPage extends CommonMethods{
	
    public LoginFormPage() {
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);	
    }
    

    @FindAll({
		@FindBy(xpath = "//a[contains(text(),'Sign in')]"),
		@FindBy(xpath = "//a[@title='Log in to your customer account']")
	})
	WebElement signIn;
	
    
    @FindBy(id="email")
    WebElement email;
    
    @FindBy(id="passwd")
    WebElement passwd;
    
    
    @FindBy(id="SubmitLogin")
    WebElement submitBtn;
    
    
	public void clickOnSignIn() {
		signIn.click();
		
	}
    
    public void login() {
		 sendText(email, "radwanahmed.learning@gmail.com");
		 sendText(passwd, "radw123");
		 submitBtn.click();
		 
		 timeOut(5000);
	}
    
}
