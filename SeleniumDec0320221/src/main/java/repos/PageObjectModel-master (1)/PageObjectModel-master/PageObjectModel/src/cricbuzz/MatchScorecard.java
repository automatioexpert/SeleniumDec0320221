/**
 * 
 */
package cricbuzz;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author anand acharya
 *
 */
public class MatchScorecard {

	public static void viewScorecard(WebDriver driver, Properties xpath) throws InterruptedException{
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath(xpath.getProperty("scorecard")))).build().perform();
		Thread.sleep(5000);
	}
}
