package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/india-women-in-sri-lanka-2022-1319706/sri-lanka-women-vs-india-women-3rd-t20i-1319711/full-scorecard");
		
		// xpath axes:

		// parent to child:
		// form[@id='hs-login']//input[@id='username']
		// div[@class='private-form__input-wrapper']/input[@id='username']
		// div[@class='private-form__input-wrapper']/child::input[@id='username']
		// select[@id='Form_submitForm_Country']/option
		// select[@id='Form_submitForm_Country']/child::option

		// child to parent:
		// backward traversing in xpath:
		// input[@id='username']/../../../../../../../../../..
		// input[@id='username']/parent::div

		// child to ancestor:
		// input[@id='username']/ancestor::form
		
		
		
//		System.out.println(getWicketTakerName("Shafali Verma"));	
//		System.out.println(getWicketTakerName("Pooja Vastrakar"));	

		System.out.println(getPlayerScoreCardList("Sabbhineni Meghana"));
		System.out.println(getPlayerScoreCardList("Pooja Vastrakar"));

	}
	
	
	public static String getWicketTakerName(String playerName) {
		String wickettaker = driver.findElement
				(By.xpath("//span[text()='"+playerName+"']/ancestor::td/following-sibling::td")).getText();
		return wickettaker;
	}
	
	public static List<String> getPlayerScoreCardList(String playerName) {
		System.out.println("player name : " + playerName);
		List<WebElement> scoreList = 
					driver.findElements(By.xpath("//span[text()='"+playerName+"']/ancestor::td//following-sibling::td"));
		List<String> scoreCardList = new ArrayList<String>();
		for(WebElement e : scoreList) {
			String text = e.getText();
			scoreCardList.add(text);
		}
		return scoreCardList;
	}
	
	
	

}
