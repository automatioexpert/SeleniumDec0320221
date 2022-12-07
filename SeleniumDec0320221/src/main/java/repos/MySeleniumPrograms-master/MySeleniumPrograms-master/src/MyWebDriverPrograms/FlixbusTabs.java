package MyWebDriverPrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Program to find the Total Number of links available and navigate to the tab "Travel Tips"

public class FlixbusTabs {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // launch chrome   
		 
        
        driver.navigate().to("https://global.flixbus.com/");// enter URL
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();     // Maximize window
        driver.findElement(By.xpath("//*[@id=\"cookie-policy\"]/div/div[2]/span")).click(); // Delete Cookies
       
        // To find the total Number of links on the Page
        List <WebElement> ListCount = driver.findElements(By.tagName("a"));
        int TotalLinks = ListCount.size();
        System.out.println("Total number of Links :" +TotalLinks);
        
        // Write an array to print all links
        String[] text = new String[TotalLinks];
      
        for (int i=0; i<TotalLinks; i++)
        {
        	text[i] = ListCount.get(i).getText();
        	System.out.println( i + "Link name is:" + text[i]);
        
             if (text[i].equalsIgnoreCase("Travel Tips"))
	    	       {
	    	        WebElement Element = driver.findElement(By.linkText("Travel Tips"));
	                String LabelName = Element.getText();
	                System.out.println("Label Name is :" +LabelName);
	                System.out.println("Available in the list");                     
	                }
             else       
	                { 
	                	 System.out.println("Not available in the list");
	                 }
        }   
        
                  driver.findElement(By.linkText("Travel Tips")).click();
                  

       
          
	}
        
}

