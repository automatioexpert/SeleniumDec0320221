#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import driver.DriverFactory;

import java.util.concurrent.TimeUnit;

public class GoogleHomePO extends LoadableComponent<GoogleHomePO>{
	
	@FindBy(name = "q")
	private WebElement searchTextBox;
	
	public GoogleHomePO() {
		DriverFactory.getDriver().get("http://www.google.com");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public GoogleSearchPO performSearch(String search) {
		searchTextBox.sendKeys(search);
		searchTextBox.submit();
		return new GoogleSearchPO();
	}

	public void writeInputSearchBox(String search){
		searchTextBox.sendKeys(search);
	}

	public void submitSearchBox(){
		searchTextBox.submit();
	}

	@Override
	protected void load() {
	}

	@Override
	protected void isLoaded() throws Error {
		
	}
}
