package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver Driver = new ChromeDriver();
		Driver.get("https://www.saucedemo.com/");
		Driver.findElementByXPath("//*[@id=\"user-name\"]").sendKeys("standard_user");
		Driver.findElementById("password").sendKeys("secret_sauce");
		Driver.findElementByXPath("//*[@id=\"login-button\"]").click();
		Driver.close();

	}

}
