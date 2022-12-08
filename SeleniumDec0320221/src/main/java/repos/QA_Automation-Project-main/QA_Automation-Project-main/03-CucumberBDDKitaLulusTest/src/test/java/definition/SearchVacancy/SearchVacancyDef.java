package definition.SearchVacancy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchVacancyDef {
	WebDriver driver;
	String baseURL = "https://kerja.kitalulus.com/id";
	WebElement search;

	@Given("User on the Home Page")
	public void user_on_the_Home_Page() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.get(baseURL);

	}

	@When("User type job vacancy {string}")
	public void user_type_job_vacancy(String string) {
		this.search = driver.findElement(By.xpath("//input[@placeholder='Cari posisi dan perusahaan impianmu']"));
		search.sendKeys(string);
	}

	@When("User click search job")
	public void user_click_search_job() {
		this.search.sendKeys(Keys.ENTER);
	}

	@Then("User get validate {string}")
	public void user_get_validate(String string) {
		Boolean state = true;
		while (state) {
			try {
				String result = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div[3]/div[2]/p/strong[2]"))
						.getText();
				Assert.assertEquals(result.contains(string), true);
				driver.close();
				state = false;
			} catch (Exception e) {
			}
		}
	}

}
