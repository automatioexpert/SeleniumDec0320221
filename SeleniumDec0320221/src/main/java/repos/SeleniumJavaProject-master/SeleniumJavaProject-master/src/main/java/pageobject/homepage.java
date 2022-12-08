package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homepage {
	
	
	
	
	public WebDriver driver;
	
	By searchbar = By.className("desktopOldAutosuggestTheme-input");
	By findproduct = By.xpath("//*[@class='SearchBoxOld-buttonContainer' and text()='ARA']");
	
	By chooseproduct= By.xpath("//*[@id=\"i0\"]/div/a/div[3]/h3");
	
	//yeni element
	By preminum= By.linkText("Hepsiburada Premium");
	
	public homepage (WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement getsearchbar() {
		
		return driver.findElement(searchbar);
	}
	
public WebElement getfindproduct() {
		
		return driver.findElement(findproduct);
	}
	
public WebElement getchooseproduct() {
	
	return driver.findElement(chooseproduct);
}

public WebElement getpreminum() {
	
	return driver.findElement(preminum);
}

}
