package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UpdateEmployeePage {
    @FindBy(className = "oxd-main-menu-item")
    public List<WebElement> myInfo;

    @FindBy(className = "orangehrm-main-title")
    public List<WebElement> headerTitle;

    @FindBy(className = "oxd-select-text-input")
    public List<WebElement> EditNationality;

    @FindBy(css = "[type=submit")
    public List<WebElement> btnSubmit;

    @FindBy(css = "[placeholder=yyyy-mm-dd]")
    public List<WebElement> dateUpdate;

    @FindBy(className = "oxd-radio-input")
    public List<WebElement> genderUpdate;

    @FindBy(className = "oxd-radio-input")
    public List<WebElement> genderUpdateAssertion;

    @FindBy(className = "oxd-select-text-input")
    public List<WebElement> AssertNatinality;

    @FindBy(className = "oxd-userdropdown-tab")
    public WebElement logout;

    
    public UpdateEmployeePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

}
