package seleniumsessions;

import java.net.MalformedURLException;
import java.net.URL;

public class AmazonTest {

	public static void main(String[] args) {

		
		BrowserUtil br = new BrowserUtil();
		br.launchBrowser("chrome");
		
		//br.launchUrl("https://www.amazon.com");
		
		try {
			br.launchUrl(new URL("https://www.amazon.com"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		String title = br.getPageTitle();
		System.out.println(title);
		if(title.contains("Amazon")) {
			System.out.println("correct title");
		}
		else {
			System.out.println("incorrect title");
		}
		
		System.out.println(br.getPageUrl());
		br.closeBrowser();
	}

}
