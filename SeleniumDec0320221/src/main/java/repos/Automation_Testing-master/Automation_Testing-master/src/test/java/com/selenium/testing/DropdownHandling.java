package com.selenium.testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownHandling {
	@Test
	public void selectOption() {
		try {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver(); //initialize the driver
			
			driver.get("C:\\Users\\Raj Kawale\\OneDrive\\Desktop\\QA Testing\\Selenium\\SeleniumPrograms\\Dropdown Element_Food.html");
			
			WebElement element = driver.findElement(By.id("dropdown"));
			Select select = new Select(element);
			
			List<WebElement> options = select.getOptions();
			int size = options.size();
			System.out.println("Number of food items are present: " + size);
			
			for (WebElement webElement : options) {
				String text = webElement.getText();
				System.out.println("Food Items are: " + text);
				System.out.println("----------------------------");
			}
			select.selectByIndex(8);    //indexing starting with zeroth position
			Thread.sleep(1000);
			select.selectByValue("2");  //It will print n-1 index position
			Thread.sleep(1000);
			select.selectByVisibleText("Macrons");  //It will get the selected
			Thread.sleep(1000);
			
			//To print the item which has been called and storing into in List
			List <WebElement> AllSelectedItem = select.getAllSelectedOptions();
			System.out.println("Number of Selected Food Items: " + AllSelectedItem.size());
			
			for (WebElement webElement : AllSelectedItem) {
				System.out.println("Selected food Items: " + webElement.getText());
			}
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
