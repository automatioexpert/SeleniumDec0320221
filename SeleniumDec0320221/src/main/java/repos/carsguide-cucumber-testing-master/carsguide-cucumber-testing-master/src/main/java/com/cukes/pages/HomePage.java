package com.cukes.pages;

import org.automation.base.BasePage;
import org.automation.elements.HyperLink;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

	public final HyperLink buyAndSell = new HyperLink("Buy and Sell", By.cssSelector("a[href='/buy-a-car/all-new-and-used']"));

	public void openPage(String url) {
		super.openUrl(url);
	}

	public void clickElementWithLinkText(String linkText) {
		HyperLink link = new HyperLink(linkText, By.linkText(linkText));
		link.click();
	}

}
