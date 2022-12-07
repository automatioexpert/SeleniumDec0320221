/**
 * 
 */
package cricbuzz;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author anand acharya
 * 
 */
public class Matches {

	public static void results(WebDriver driver, Properties xpath) throws InterruptedException{
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		//click the results
		act.click(driver.findElement(By.xpath(xpath.getProperty("results")))).build().perform();
		//wait for 3 seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
