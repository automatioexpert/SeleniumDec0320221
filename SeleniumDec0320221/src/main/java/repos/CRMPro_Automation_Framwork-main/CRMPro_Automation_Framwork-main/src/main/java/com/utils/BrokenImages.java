package com.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.base.BasePage;

public class BrokenImages extends BasePage {

	public static void validateInvalidImages() {
		// Storing all elements with img tag in a list of WebElements
		List<WebElement> images = getDriver().findElements(By.tagName("img"));
		System.out.println("Total number of Images on the Page are " + images.size());

		// checking the links fetched.
		for (int index = 0; index < images.size(); index++) {
			WebElement image = images.get(index);
			String imageURL = image.getAttribute("src");
			System.out.println("URL of Image " + (index + 1) + " is: " + imageURL);
			verifyLinks(imageURL);

			// Validate image display using JavaScript executor
			try {
				boolean imageDisplayed = (Boolean) ((JavascriptExecutor) getDriver()).executeScript(
						"return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);",
						image);
				if (imageDisplayed) {
					System.out.println("DISPLAY - OK");
				} else {
					System.out.println("DISPLAY - BROKEN");
				}
			} catch (Exception e) {
				System.out.println("Error Occured");
			}
		}
	}

	public static void verifyLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			// Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
			}

			// Fetching and Printing the response code obtained
			else {
				System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
