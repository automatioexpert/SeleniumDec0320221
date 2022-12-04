package BrowserVendors;

import Browser.BrowserUtil;

public class TestBrowser {

	public static void main(String[] args) {

		Chrome c = new Chrome();
		c.click();
		c.launchURL();
		
//		BrowserUtil br = new Chrome();
//		br.click();
//		
//		BrowserUtil br1 = new Firefox();
//		br1.click();
//		
//		BrowserUtil br2 = new Safari();
//		br2.click();
		
		BrowserUtil br = null;
		
		String browserName = "chrome";
		//cross browser logic 
		if(browserName.equals("chrome")) {
			br = new Chrome();
		}
		else if(browserName.equals("firefox")) {
			br = new Firefox();
		}
		else if(browserName.equals("safari")) {
			br = new Safari();
		}
		else {
			System.out.println("please pass the right browser.....");
		}
		
		br.click();
		
		
	}

}
