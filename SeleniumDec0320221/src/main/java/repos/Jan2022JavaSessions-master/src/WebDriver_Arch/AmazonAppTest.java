package WebDriver_Arch;

public class AmazonAppTest {

	static WebDriver driver;

	public static void main(String[] args) {

		// chrome
//		ChromeDriver driver = new ChromeDriver();
//		driver.getTitle();
//		driver.getUrl();
//		driver.findElement("email id");
//		driver.findElement("password");
//		driver.click();
//		driver.quit();

		// firefox/chrome/safari: cross browser

		// FirefoxDriver driver = new FirefoxDriver();
		// ChromeDriver driver = new ChromeDriver();
		// SafariDriver driver = new SafariDriver();

		String browser = "chrome";
		//cross browser logic : top casting
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("please pass the right browser...." + browser);
		}

		driver.getTitle();
		driver.getUrl();
		driver.findElement("email id");
		driver.findElement("password");
		driver.click();
		driver.quit();
		
		
	}

}
