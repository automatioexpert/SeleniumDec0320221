package BrowserVendors;

import Browser.BrowserUtil;

public class Safari extends BrowserUtil {

	@Override
	public void click() {
		System.out.println("safari -- clicking....");
	}

	public void launchURL() {
		System.out.println("https://google.com");
	}

}
