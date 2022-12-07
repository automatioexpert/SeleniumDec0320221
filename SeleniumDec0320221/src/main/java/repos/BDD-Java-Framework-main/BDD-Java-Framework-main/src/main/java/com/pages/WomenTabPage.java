package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WomenTabPage {
	
	private WebDriver driver;
	
	private By subCategoriesList = By.xpath("//div[@id='subcategories']//h5");
	
	public WomenTabPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getWomenTabPageTitle() {
		return	driver.getTitle();
	}
	
	public int getsubCatCount() {
		return driver.findElements(subCategoriesList).size();
	}
	
	public List<String> getSubCatList() {
		List<WebElement> scat = driver.findElements(By.xpath("//div[@id='subcategories']//h5"));
		List<String> sc = new ArrayList<String>();
		for(WebElement ele: scat) {
			sc.add(ele.getText());
		}
		System.out.println("Actual subcategories in the method: "+sc);
		return sc;
	}

}
