package SeleniumSessions;

public class RediffMailTest {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		br.launchBrowser("chrome");
		br.enterUrl("http://www.rediffmail.com");
		String title = br.getPageTitle();
		System.out.println(title);
		if(title.contains("Rediff")) {
			System.out.println("correct title");
		}
		
		String url = br.getAppCurrentUrl();
		System.out.println(url);
		
		br.closeBrowser();
		
	}

}
