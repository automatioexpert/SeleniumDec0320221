package BrowserVendors;

import Browser.BrowserUtil;

public class Chrome extends BrowserUtil {

	@Override
	public void click() {
		System.out.println("chrome -- clicking....");
	}

	public void launchURL() {
		System.out.println("https://google.com");
	}

}
