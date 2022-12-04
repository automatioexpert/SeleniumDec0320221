package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();

		br.initDriver("Chrome");
		br.lauchUrl("https://www.amazon.in");

		String title = br.getPageTitle();
		System.out.println("page title : " + title);

		if (title.contains("Online Shopping")) {
			System.out.println("correct title");
		}

		System.out.println(br.getPageUrl());
		br.closeBrowser();

	}

}
