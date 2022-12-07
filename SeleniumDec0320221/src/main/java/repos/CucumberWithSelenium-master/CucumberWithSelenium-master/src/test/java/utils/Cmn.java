package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import parabank.po.PO_Login;

public class Cmn {
	
	public static WebDriver InvokeBrowser(String browserType) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void NavigateToUrl(WebDriver driver,String url) {
		driver.get(url);
	}

}

