/**
 * 
 */
package cricbuzz;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author anand acharya
 * Program to navigate on the homepage and click team Australia
 */
public class HomePage {
	//create a static method to select the required team
	public static void teams(WebDriver driver, Properties xpath) throws InterruptedException{
		Actions act = new Actions(driver);
		//hover to the teams dropdown menu
		act.moveToElement(driver.findElement(By.xpath(xpath.getProperty("homepageteams")))).build().perform();
		//hardcode wait for 5 seconds
		Thread.sleep(5000);
	}
		
		public static void australia(WebDriver driver, Properties xpath){
			//click team Australia
			driver.findElement(By.xpath(xpath.getProperty("testteamaustralia"))).click();
			//wait till the page is opened
			WebDriverWait waitexplict = new WebDriverWait(driver, 5);
			waitexplict.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath.getProperty("header1")))));
		}
		
		public static void india(WebDriver driver, Properties xpath){
			//click team Australia
			driver.findElement(By.xpath(xpath.getProperty("testteamindia"))).click();
			//wait till the page is opened
			WebDriverWait waitexplict = new WebDriverWait(driver, 5);
			waitexplict.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath.getProperty("header2")))));
		}
}
