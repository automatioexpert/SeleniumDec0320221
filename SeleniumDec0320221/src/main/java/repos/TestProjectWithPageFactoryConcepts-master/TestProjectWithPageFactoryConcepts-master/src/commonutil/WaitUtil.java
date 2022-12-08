/**
 * 
 */
package commonutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author rohitnegi
 *
 */
public class WaitUtil {
	
	public static WebDriver driver;
	
	public static void waitForElementVisibility(WebDriver driver, int seconds, WebElement elmt){
		
		WebDriverWait wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(elmt));
		
		
	}
	
	public static void waitForElementToBeClickable(WebDriver driver, int seconds, WebElement elmt){
		
		WebDriverWait wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(elmt));
		
		
	}
	
	public static void simpleWait(int seconds) throws InterruptedException{
		
		Thread.sleep(seconds*1000);
		
	}

}
