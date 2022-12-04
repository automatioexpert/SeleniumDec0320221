package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By productHeaderName = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By quantity = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");

	private Map<String, String> productMap;

	ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getProductHeaderName() {
		return eleUtil.doGetText(productHeaderName).trim();
	}

	public int getProductImageCount() {
		return eleUtil.waitForElementsVisible(productImages, 10).size();
	}

	public Map<String, String> getProductInfo() {
		productMap = new TreeMap<String, String>();
		productMap.put("name", getProductHeaderName());
		productMap.put("totalimages", String.valueOf(getProductImageCount()));
		getProductMetaData();
		getProductPriceData();
		return productMap;
	}

//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: Out Of Stock
	private void getProductMetaData() {
		List<WebElement> metaDataList = eleUtil.getElements(productMetaData);
		for (WebElement e : metaDataList) {
			String text = e.getText();
			String meta[] = text.split(":");
			String key = meta[0].trim();
			String value = meta[1].trim();
			productMap.put(key, value);
		}
	}

	// $2,000.00//0
	// Ex Tax: $2,000.00//1
	private void getProductPriceData() {
		List<WebElement> metaPriceList = eleUtil.getElements(productPriceData);
		String price = metaPriceList.get(0).getText().trim();
		String exTaxPrice = metaPriceList.get(1).getText().trim();
		productMap.put("price", price);
		productMap.put("ExTaxPrice", exTaxPrice);
	}

}
