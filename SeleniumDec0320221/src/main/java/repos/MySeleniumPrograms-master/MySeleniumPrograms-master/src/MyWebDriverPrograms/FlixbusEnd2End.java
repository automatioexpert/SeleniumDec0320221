package MyWebDriverPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Check the Search functionality for onward journey and Return Journey travel with 2 Adults and 2 Children

public class FlixbusEnd2End {

	public static void main(String[] args) {
	
	/* System.setProperty("webdriver.gecko.driver","C:/geckodriver/geckodriver.exe");
		 WebDriver driver = new FirefoxDriver(); */
		 
	   	System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // launch chrome   
		 
        
        driver.navigate().to("https://global.flixbus.com/");// enter URL
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();     // Maximize window
        	          
         // delete all cookies
 //From Paris
      driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[1]/div/div[1]/div/div[1]/div[1]/div/input")).sendKeys("Paris",Keys.ENTER);
     
 // To London
         driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[1]/div/div[2]/div/div[1]/div/input")).sendKeys("London",Keys.ENTER);
         
 // Select Departure Date 31-Aug-2018
         driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[1]/div/div/input")).click();
 // Click the arrow button ">"
         driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[1]/button[2]/img")).click();
 // Select date 31-August-2018         
         driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[5]/div[5]")).click();
         
// Click Buttons on Calendar for Return Date 28-Nov-2018
         driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[2]/div/p/i")).click();
         driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[1]/button[2]/img")).click();
         driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[1]/button[2]/img")).click();
         driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div[5]/div[3]")).click();
                                     
// Select Passengers 2 Adults 
         driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[1]/div/div/input")).click();
         driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/button[2]/i")).click();
         
// Select Passengers 2 Children
         driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button[2]/i")).click();
         driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button[2]/i")).click();

// Click the Search Button
         driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[4]/div/button")).click();
         
//Reserve 4 Seats Button 
         driver.findElement(By.xpath("//*[@id=\"results-group-container-direct\"]/div[8]/div/div[2]/div[2]/div/div[2]/div/div[2]/form/input[11]")).click();
         
//Book 4 tickets: 2 Adults, 2 CHildren
          boolean Button = driver.findElement(By.id("book-button")).isEnabled();
          System.out.println("Button:" +Button);
//unknown error: Element <div class="iti-flag in"></div> is not clickable at point (637, 7). Other element would receive the click      
          // Solution Below
          WebDriverWait wait = new WebDriverWait(driver, 20);
          wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("book-button")));  
        
   /*     WebDriverWait wait1 = new WebDriverWait(driver, 20);
          wait1.until(ExpectedConditions.elementToBeClickable(By.id("book-button")));*/
 
   /*     WebDriverWait wait2 = new WebDriverWait(driver, 30);
          wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("book-button")));  */

          System.out.println("Button:" +Button);
      
          driver.findElement(By.id("book-button")).click();
    
   // Passengers Details Page
          
   
    // Enter First name and last name of Passengers - Passenger 1 - Adult 1
              driver.findElement(By.id("booking_passenger_passengers_0_items_0_firstname")).sendKeys("Jay Kishore");
    
              driver.findElement(By.id("booking_passenger_passengers_0_items_0_lastname")).sendKeys("Duvvuri");
   
              // Select Flags Dropdown
              driver.findElement(By.xpath("//*[@id=\"passengers-form\"]/div[2]/div/div[2]/div/div[3]/div/div[1]/div/div/div[3]/div/div[2]/div[1]/div/div/div[1]")).click();
              driver.findElement(By.xpath("//*[@id=\"passengers-form\"]/div[2]/div/div[2]/div/div[3]/div/div[1]/div/div/div[3]/div/div[2]/div[1]/div/ul/li[129]/span[1]")).click();
              driver.findElement(By.id("booking_passenger_passengers_0_items_0_phone")).sendKeys("9959794383");             
              
           
  // Enter First name and last name of Passengers - Passenger 2 - Adult 2
              driver.findElement(By.id("booking_passenger_passengers_0_items_1_firstname")).sendKeys("Anuradha");
              
              driver.findElement(By.id("booking_passenger_passengers_0_items_1_lastname")).sendKeys("Duvvuri");

              // Select Flags Dropdown
              driver.findElement(By.xpath("//*[@id=\"passengers-form\"]/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div/div[1]")).click();
              driver.findElement(By.xpath("//*[@id=\"passengers-form\"]/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div/div[3]/div/div[2]/div[1]/div/ul/li[14]/div/div")).click();
              driver.findElement(By.id("booking_passenger_passengers_0_items_1_phone")).sendKeys("7565648484");
              driver.findElement(By.name("booking_passenger[passengers][0][items][2][phone]")).click();
              
                                                              
  // Enter First name and last name of Passengers - Passenger 3 -Child 1
              driver.findElement(By.id("booking_passenger_passengers_0_items_2_firstname")).sendKeys("Ankith Chakravarthy");
              
              driver.findElement(By.id("booking_passenger_passengers_0_items_2_lastname")).sendKeys("Duvvuri");

              // Select Flags Dropdown
              driver.findElement(By.xpath("//*[@id=\"passengers-form\"]/div[2]/div/div[2]/div/div[3]/div/div[3]/div[1]/div/div[3]/div/div[2]/div[1]/div/div")).click();
              driver.findElement(By.xpath("//*[@id=\"passengers-form\"]/div[2]/div/div[2]/div/div[3]/div/div[3]/div[1]/div/div[3]/div/div[2]/div[1]/div/ul/li[129]/div/div")).click();
              driver.findElement(By.id("booking_passenger_passengers_0_items_2_phone")).sendKeys("9959794383");             
      
              driver.findElement(By.id("booking_passenger_passengers_0_items_2_birthdate")).sendKeys("24.09.2008");
              driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[3]/a")).click();
              
    
                                                
 //           Enter First name and last name of Passengers - Passenger 3 -Child 2
              driver.findElement(By.id("booking_passenger_passengers_0_items_3_firstname")).sendKeys("Aashritha Satya Krishna");
              
              driver.findElement(By.id("booking_passenger_passengers_0_items_3_lastname")).sendKeys("Duvvuri");
              WebDriverWait wait3 = new WebDriverWait(driver,30);
              wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passengers-form\"]/div[2]/div/div[2]/div/div[3]/div/div[4]/div[1]/div/div[3]/div/div[2]/div[1]/div/div"))).click();

              // Select Flags Dropdown
              driver.findElement(By.xpath("//*[@id=\"passengers-form\"]/div[2]/div/div[2]/div/div[3]/div/div[4]/div[1]/div/div[3]/div/div[2]/div[1]/div/ul/li[1]/div/div")).click();
              driver.findElement(By.xpath("//*[@id=\"passengers-form\"]/div[2]/div/div[2]/div/div[3]/div/div[4]/div[1]/div/div[3]/div/div[2]/div[1]/div/div")).click();
              driver.findElement(By.xpath("//*[@id=\"passengers-form\"]/div[2]/div/div[2]/div/div[3]/div/div[4]/div[1]/div/div[3]/div/div[2]/div[1]/div/ul/li[14]")).click();
              driver.findElement(By.id("booking_passenger_passengers_0_items_3_phone")).sendKeys("7565645684");      
              driver.findElement(By.id("booking_passenger_passengers_0_items_3_birthdate")).sendKeys("15.12.2010");
              driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]/a")).click();
          
              //Proceed to payment
              driver.findElement(By.id("passengers_registration_submit")).click();
              
              //Choose a Payment method (Visa/Mastercard)
              driver.findElement(By.id("payment_email")).sendKeys("jaykishore999@gmail.com");
              driver.findElement(By.id("payment_register")).click();
              driver.findElement(By.id("payment_method_submit")).click();
              
              driver.close();

	}

}
