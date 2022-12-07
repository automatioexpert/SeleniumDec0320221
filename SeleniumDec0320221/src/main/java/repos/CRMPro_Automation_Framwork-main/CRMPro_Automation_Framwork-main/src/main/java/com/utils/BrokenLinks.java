package com.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BasePage;

public class BrokenLinks extends BasePage{
	
	public static void myBrokenLinks() {
		// Storing all elements with a tag in a list of WebElements
		List<WebElement> links = getDriver().findElements(By.tagName("a"));
		System.out.println("Total number of Images on the Page are " + links.size());
	
		// checking the links fetched.
		for (int index = 0; index < links.size(); index++) {
			WebElement link = links.get(index);
			String linkURL = link.getAttribute("href");
			System.out.println("URL of Link " + (index + 1) + " is: " + linkURL);
			verifyLinks(linkURL);
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
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
            ex.printStackTrace();
          }
	}
}
