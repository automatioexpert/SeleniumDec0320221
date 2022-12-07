package MyWebDriverPrograms;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionBuilder {

	public static void main(String[] args) {
	
		WebDriver driver;
		String URL = "http:/amazon.in";
	    System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver(); // launch chrome   
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions value = new Actions(driver);
        // Move the mouse cursor to the required object
        WebElement test = driver.findElement(By.id("twotabsearchtextbox"));
        //Move the cursor to the Category Objects
        value.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-shopall']//span[@class='nav-line-2']"))).build().perform();
        //Click on Text Box
        driver.findElement(By.id("twotabsearchtextbox")).click();
        // Enter the values as iPhone X
        //Shift Keys will not work in Latest IE, FF Browswers and it is considered as Browser Control Issue
        // Press Shift key down + text as iPhone X + Press Shift keyUp to release + Double click on text + Right Click
         value.moveToElement(test).click()
        .keyDown(test, Keys.SHIFT)
        .sendKeys(test, "iPhone X")
        .keyUp(test, Keys.SHIFT)
        .doubleClick().contextClick().build().perform();
        
        
        
        
        
        
        
        
        
	


	}

}
