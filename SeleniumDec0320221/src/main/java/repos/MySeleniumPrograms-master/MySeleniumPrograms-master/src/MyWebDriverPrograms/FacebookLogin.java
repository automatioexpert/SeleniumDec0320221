package MyWebDriverPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) {
		//Facebook Login
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // launch chrome
        driver.get("https://www.facebook.com/");  //Get URL
        
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Maximize window
        driver.manage().window().maximize();     
        
        String Title = driver.getTitle();
        System.out.println("Title is :" +Title);
        
        String URL = driver.getCurrentUrl(); //Get Current URL
        System.out.println("Current URL is :" +URL);
        
     //   String PageSource = driver.getPageSource();
       
       if(Title.equalsIgnoreCase("Facebook – log in or sign up"))
        {
        	System.out.println("Test case is : Passed");
        }
        else
        {
        	System.out.println("Test Case is : Failed");
        }
        
        driver.findElement(By.id("email")).sendKeys("tester");
        driver.findElement(By.id("pass")).sendKeys("testing");
		driver.findElement(By.id("loginbutton")).click();  
		
	
		
		
		

	}

}
