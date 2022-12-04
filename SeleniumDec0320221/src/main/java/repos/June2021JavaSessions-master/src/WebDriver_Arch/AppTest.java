package WebDriver_Arch;

public class AppTest {

	public static void main(String[] args) {

		WebDriver driver = null;

		String browser = "chrome";

		//cross browser testing -- top casting
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("no browser found....");
		}

		driver.get("http://www.xyz.com");
		String title = driver.getTitle();
		System.out.println(title);
		
		System.out.println(driver.getUrl());
		driver.click();
		driver.sendKeys("admin@gmail.com");
		driver.quit();

	}

}
