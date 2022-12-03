package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/afghanistan-in-bangladesh-2021-22-1299826/bangladesh-vs-afghanistan-1st-t20i-1299832/full-scorecard");

		String wkName = getWicketTakerName("Yasir Ali");
		System.out.println(wkName);
		
		System.out.println(getScoreCardList("Yasir Ali"));
		System.out.println(getScoreCardList("Mahedi Hasan"));


	}

	public static String getWicketTakerName(String name) {
		return driver
				.findElement(By.xpath("//a[contains(text(),'" + name + "')]/parent::td/following-sibling::td/span"))
				.getText();
	}

	public static List<String> getScoreCardList(String name) {
		List<String> scoreVal = new ArrayList<String>();
		List<WebElement> scoreList = driver
				.findElements(By.xpath("//a[contains(text(),'" + name + "')]/parent::td/following-sibling::td"));
		for (int i = 1; i < scoreList.size(); i++) {
			String score = scoreList.get(i).getText();
			scoreVal.add(score);
		}
		return scoreVal;
	}

}
