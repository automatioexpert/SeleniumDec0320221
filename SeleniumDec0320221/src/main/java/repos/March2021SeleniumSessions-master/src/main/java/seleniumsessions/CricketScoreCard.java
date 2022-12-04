package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketScoreCard {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/sri-lanka-tour-of-bangladesh-2021-1262340/bangladesh-vs-sri-lanka-1st-odi-1262344/full-scorecard");
		Thread.sleep(5000);

		System.out.println(getWicketTakerName("Shakib Al Hasan"));
		getScoreCardList("Shakib Al Hasan").stream().forEach(e -> System.out.print(e+" "));
		
		//select checkbox for the common names:
		// (//a[text()='Contact User 1 New1'])/parent::td//preceding-sibling::td/input
	}

	public static String getWicketTakerName(String batsmanName) {
		return driver
				.findElement(
						By.xpath("//a[contains(text(),'" + batsmanName + "')]/parent::td/following-sibling::td/span"))
				.getText();
	}

	public static List<String> getScoreCardList(String batsmanName) {
		List<String> scoreValList = new ArrayList<String>();

		List<WebElement> scoreList = driver.findElements(By.xpath("//a[contains(text(),'" + batsmanName
				+ "')]/parent::td[contains(@class,'batsman-cell')]//following-sibling::td"));

		for (int i = 1; i < scoreList.size(); i++) {
			String scoreVal = scoreList.get(i).getText();
			scoreValList.add(scoreVal);
		}
		return scoreValList;
	}

}
