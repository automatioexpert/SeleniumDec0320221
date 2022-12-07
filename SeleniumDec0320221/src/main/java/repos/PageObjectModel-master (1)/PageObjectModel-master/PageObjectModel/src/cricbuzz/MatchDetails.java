/**
 * 
 */
package cricbuzz;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author anand acharya
 *
 */
public class MatchDetails {
	public static void firstmatch(WebDriver driver, Properties xpath) throws InterruptedException{
		driver.findElement(By.xpath(xpath.getProperty("firstmatch"))).click();
		Thread.sleep(5000);
	}
}
