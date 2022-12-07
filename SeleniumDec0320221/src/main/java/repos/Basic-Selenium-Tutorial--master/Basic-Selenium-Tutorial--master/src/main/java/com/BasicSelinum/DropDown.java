package com.BasicSelinum;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HASSEN\\workspace\\BasicSelinum_Tutorail_Suite\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoqa.com/select-menu");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Selecting the dropdown element by locating its ID
		Select select = new Select(driver.findElement(By.id("oldSelectMenu")));

		// Looping through the options and printing dropdown options
		List<WebElement> lst = select.getOptions();
		for (WebElement options : lst) {
			System.out.println(options.getText());
		}

		// Selecting the option as 'Purple' --selectByIndex
		System.out.println("Select the Option by Index 4");
		select.selectByIndex(4);
		System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

		// Selecting the option as 'Magenta' --selectByVisibleText
		System.out.println("Select the Option by Text ");
		select.selectByVisibleText("Magenta");
		System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

		// Selecting the option by it value
		System.out.println("Select the Option by value 6 ");
		select.selectByValue("6");
		System.out.println("Select value is: " + select.getFirstSelectedOption().getText());
		
		driver.quit();
	}
}
