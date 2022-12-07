package MyWebDriverPrograms;

import java.util.List; // Import Statemment used when Lis<WebElements> option is used
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class WorkingWithDropDowns {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // launch chrome
        driver.get("https://www.facebook.com/");  //Get URL
        
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Maximize window
        driver.manage().window().maximize();     
        
        String Title = driver.getTitle();
        System.out.println("Title is :" +Title);
        
        // Handle Drop Downs with 'Select' Statement
        Select daydropdown = new Select(driver.findElement(By.id("day")));
  //      Select monthdropdown = new Select(driver.findElement(By.id("month")));
        
        // Select By Index
    /*  daydropdown.selectByIndex(8);
        monthdropdown.selectByIndex(3); */
        
        //Select by visible text
    /*  daydropdown.selectByVisibleText("31");
        monthdropdown.selectByVisibleText("Aug"); */
        
        List<WebElement> dropdowncount = daydropdown.getOptions();
        int daysize = dropdowncount.size();
        System.out.println("Total values in the Drop down : " +daysize);
        for(int i=0; i<daysize; i++)
        {
        	String StrValue = dropdowncount.get(i).getText();
        	System.out.println("StrValue :" +StrValue);
        	if(StrValue.equals("31"))
        	{
        		System.out.println("31 value is available in the list");
        		
        	}
        	else
        	{
        		System.out.println("31 value is not available in the list");
        		
        	}
        }
        
       

	}
}
