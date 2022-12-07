package MyWebDriverPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeGooglecom {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	    
	
  //System.setProperty("webdriver.gecko.driver","C:/geckodriver/geckodriver.exe");
  
    System.setProperty("webdriver.chrome.driver","C:/chromedriver/chromedriver.exe"); 
		
   // WebDriver driver = new FirefoxDriver();
 	  WebDriver driver = new ChromeDriver();
		
        driver.get("https://www.google.co.in");
        
        driver.manage().window().maximize();
        
        String TitleValue=driver.getTitle();
        
        System.out.println(TitleValue);
		
     int driverWindow=driver.manage().window().getSize().getWidth();
     
     System.out.println(driverWindow);
	   

	}
	
}
