package MyWebDriverPrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithTheLinks {

	public static void main(String[] args) {
	
				System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
		        WebDriver driver = new ChromeDriver(); // launch chrome
		        driver.get("http://newtours.demoaut.com");  //Get URL
		        
		        //Implicit wait
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        
		        // Maximize window
		        driver.manage().window().maximize();    
		        
		        //Retrieve all the links and store in "Links"
		        List <WebElement> Links = driver.findElements(By.tagName("a"));
		        //Total Number of links
		        int linkcount = Links.size();
		        System.out.println("Linkcount is :" +linkcount);
		        String[] texts = new String[linkcount];
		        for (int i=0; i<linkcount; i++)
		        {
		        	//get the name of the link
		        	texts[i] = Links.get(i).getText();
		        	System.out.println( i + "Link name is:" + texts[i]);
		        }
		        
		        for (int j=0; j<texts.length-1;j++)
		        {
		        	System.out.println("Texts Length = " + texts.length);
		        	driver.findElement(By.linkText(texts[j])).click();
		        	if(driver.getTitle().equalsIgnoreCase("404 not found"))
		        			{
		        				
		        				System.out.println("Link is broken : " + texts[j]);
		        				driver.navigate().back();
		        			}
		        			else
		        			{
		        			  driver.navigate().back();		
		                    }
		        			
		        }		
		 
		        driver.close();
	}
	
}
