package SeleniumSessions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Move {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");

//		WebElement ele = driver.findElement(By.linkText("Yukon"));
//		Actions act = new Actions(driver);
//		act.moveToElement(ele).perform();

		List<WebElement> cityList = driver.findElements(By.xpath("//div[@id='most_pollutedCitiesRank']//a"));
		List<WebElement> aqList = driver.findElements(By.xpath("//div[@id='most_pollutedCitiesAqi']/p"));
		Map<String, String> aqMap = new LinkedHashMap<String, String>();
		if (cityList.size() == aqList.size()) {
			for (int i = 0; i < cityList.size(); i++) {
				aqMap.put(cityList.get(i).getText(), aqList.get(i).getText());
				System.out.println(aqList.get(i).getCssValue("background-color"));
			}
		}
		aqMap.forEach((k, v) -> System.out.println(k + ":" + v));

		String name = driver.findElement(By.linkText("Williams-Lake, Canada")).getDomAttribute("hidden");
		System.out.println(name);
		Rectangle rect = driver.findElement(By.cssSelector("img[alt='live rank icon'][class='card-rank-icon']"))
				.getRect();
		System.out.println(rect.getHeight());
		System.out.println(rect.getWidth());

		WebElement ele = driver.findElement(By.linkText("Williams-Lake, Canada"));
		String text = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(text);
		text = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(text);
		
		text = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(text);
		
		text = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(text);
		
		text = driver.findElement(with(By.tagName("a")).near(ele)).getAttribute("href");
		System.out.println(text);
		System.out.println("bye");



	}

}
