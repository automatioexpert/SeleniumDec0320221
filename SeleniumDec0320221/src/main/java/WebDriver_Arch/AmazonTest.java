package WebDriver_Arch;

public class AmazonTest {
	static WebDriver driver;//null

	public static void main(String[] args) {

		//chrome:
		//firefox:
		//safari:
		
		//ChromeDriver driver = new ChromeDriver();
		//FirefoxDriver driver = new FirefoxDriver();
		//SafariDriver driver = new SafariDriver();
		
		String browser = "ie";
		
		//cross browser logic
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		else {
			System.out.println("please pass the right browser name : " + browser);
		}
		
		driver.get("https://www.amazon.com");
		
		driver.click("Sign In");
		
		driver.sendKeys("emailID", "naveen@gmail.com");
		driver.sendKeys("password", "naveen@123");
		driver.click("Login");
		String title = driver.getTitle();
		System.out.println("page title is : " + title);
		
		//act vs exp result: checkpoint/ verification point
		if(title.equals("Amazon Shopping")) {
			System.out.println("correct title: PASS");
		}
		else {
			System.out.println("in correct title: FAIL");
		}
		//Automation testing = Automation Steps + Checkpoint(verfiction/Assertion/Soft/Hard/Act vs Exp Result) 
		
		driver.close();
		
		
	}

}
