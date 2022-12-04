package SeleniumSessions;

public class HubSpotLoginPage {

	public static void main(String[] args) throws InterruptedException {

		String browser = "chrome";
		String url = "https://app.hubspot.com/login";

		WebDriverFactory wf = new WebDriverFactory();

		wf.launchBrowser(browser);
		wf.launchUrl(url);

		Thread.sleep(5000);

		String title = wf.getPageTitle();
		System.out.println("page title is: " + title);

		if (title.equals("HubSpot Login")) {
			System.out.println("correct title");
		} else {
			System.out.println("in-correct title");
		}

		wf.closeBrowser();

	}

}
