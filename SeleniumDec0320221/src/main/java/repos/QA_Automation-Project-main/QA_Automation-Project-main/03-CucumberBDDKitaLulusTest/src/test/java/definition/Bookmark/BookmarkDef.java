package definition.Bookmark;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookmarkDef {
	WebDriver driver;
	String baseURL;
	WebElement bookmark;
	// Type it first on your terminal
	//	cd C:\Program Files (x86)\Google\Chrome\Application
	// chrome.exe --remote-debugging-port=9222 --user-data-dir=C:\chromeData

	@Given("User on the browser {string}")
	public void user_on_the_browser(String string) {

		// set the driver path- You can also use WebDriverManager for drivers
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

		// Create object of ChromeOptions Class
		ChromeOptions opt = new ChromeOptions();

		// pass the debuggerAddress and pass the port along with host. Since I am
		// running test on local so using localhost
		opt.setExperimentalOption("debuggerAddress", "localhost:9222 ");

		// pass ChromeOptions object to ChromeDriver constructor
		this.driver = new ChromeDriver(opt);

		// now you can use now existing Browser
		driver.get(string);

	}

	@When("User search job vacancy {string}")
	public void user_search_job_vacancy(String string) {

		// Find Job
		try {

			WebElement search = driver
					.findElement(By.xpath("//input[@placeholder='Cari posisi dan perusahaan impianmu']"));
			search.sendKeys(string);
			search.sendKeys(Keys.ENTER);

		} catch (Exception e) {

		}

	}

	@When("User click one of the search job")
	public void user_click_one_of_the_search_job() {
		// click job
		Boolean state = true;
		while (state) {
			try {
				WebElement job = driver
						.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/a[1]"));
				job.click();
				state = false;
			} catch (Exception e) {
			}
		}

	}

	@When("User bookmark a job")
	public void user_bookmark_a_job() {
		Boolean state = true;
		while (state) {
			try {
				WebElement loveBookmark = driver
						.findElement(By.xpath("//button[@class='BookmarkButton___StyledButton-sc-10f0at4-1 cpgooR']"));
				loveBookmark.click();

				state = false;
			} catch (Exception e) {
			}
		}
		// return value for assertion
		this.bookmark = driver.findElement(By.xpath("//img[@alt='bookmark active']"));

	}

	@Then("The mark job already saved")
	public void the_mark_job_already_saved() {
		// Assert bookmark
		try {
			System.out.println("here's" + bookmark + " iya disini xpathnya");
			Assert.assertNotNull(bookmark.isDisplayed());
			
			//repeat click for next test
			WebElement loveBookmark = driver
					.findElement(By.xpath("//button[@class='BookmarkButton___StyledButton-sc-10f0at4-1 cpgooR']"));
			loveBookmark.click();
			driver.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
