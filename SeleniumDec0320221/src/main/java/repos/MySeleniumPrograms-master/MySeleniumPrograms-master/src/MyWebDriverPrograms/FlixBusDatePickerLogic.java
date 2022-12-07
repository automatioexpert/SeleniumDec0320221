package MyWebDriverPrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

   public class FlixBusDatePickerLogic {

	public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // launch chrome

        driver.get("https://global.flixbus.com/"); // enter URL
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);// dynamic wait

        driver.manage().window().maximize();     // Maximize window
        	          
        driver.findElement(By.xpath("//*[@id=\"cookie-policy\"]/div/div[2]/span")).click(); // delete all cookies


//From Field "Amsterdam"
driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[1]/div/div[1]/div/div[1]/div[1]/div/input")).sendKeys("Amsterdam",Keys.ENTER);	
              
//To Field Brussels		         
driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[1]/div/div[2]/div/div[1]/div/input")).sendKeys("Brussels", Keys.ENTER);

//Date Picker Logic

// Select the Departure Date 
String NextButtonxpath= "//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[1]/button[2]/img";
driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[1]/div/div/input")).click();
 for(int i=0; i<12; i++)
 {
	String month = "DayPicker-Caption";
	WebElement monthname = driver.findElement(By.className(month));
	String MonthValue = monthname.getText();
	System.out.println("Departure Date Month Value is: " +MonthValue);	
	String Monthselected = "September 2018";
	
                  if(MonthValue.equalsIgnoreCase(Monthselected))
                   {
	                 System.out.println("Selected Month for Departure Date is: " +MonthValue);
	   
	                   //Get all rows from the table
	                   WebElement Table = driver.findElement(By.className("DayPicker-Body"));
	               //    System.out.println("Table is :" + Table);
	                  // Get all rows from the table
	                  List<WebElement> TableRows = Table.findElements(By.className("DayPicker-Week"));
	                 // System.out.println("TableRows value is:" +TableRows);
	                         for(WebElement row:TableRows)
	                            {
	                        	// Retrieve each row value
	                        	// System.out.println("Row is :" +row);
	                        	 List<WebElement> Columns = row.findElements(By.className("DayPicker-Day"));
	                        //	 System.out.println("Columns Values are:" +Columns);
	                        	// Start loop for each value in the partiular rows
	                         
	                                       for(WebElement Column:Columns)
	                                        {
	                                    	 //System.out.println("Column Text Value is :" +Column.getText());    
	                        	              if(Column.getText().equals("15"))
	                        	              {
	                        	            	  driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[3]/div[6]/span")).click();
	                        	            //	  System.out.println("Single Column value is :" +Column);
	                        	              	  System.out.println("Departure Date is selected as:" + "15");
	                        	              }
	                                    	   
	                                        }
	
	                            }
	                break;
                  }
	               else
	                  {
	                   driver.findElement(By.xpath(NextButtonxpath)).click();
	                  }
	
                  
 }

//Select the Return Date 
//String NextButtonxpath= "//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[1]/button[2]/img";
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[2]/div/p/i")).click();
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[2]/div/div/input")).click();
for(int j=0; j<12; j++)
{
	String month = "DayPicker-Caption";
	WebElement monthname = driver.findElement(By.className(month));
	String MonthValue = monthname.getText();
	System.out.println("Month Value for Return Date is: " +MonthValue);	
	String Returndateselected = "October 2018";
	
                if(MonthValue.equalsIgnoreCase(Returndateselected))
                 {
	                 System.out.println("Selected Month for Return Date is: " +MonthValue);
	   
	                   //Get all rows from the table
	                   WebElement Table = driver.findElement(By.className("DayPicker-Body"));
	               //    System.out.println("Table is :" + Table);
	                  // Get all rows from the table
	                  List<WebElement> TableRows = Table.findElements(By.className("DayPicker-Week"));
	                //  System.out.println("TableRows value are:" +TableRows);
	                         for(WebElement row:TableRows)
	                            {
	                        	// Retrieve each row value
	                      //  	 System.out.println("Row is :" +row);
	                        	 List<WebElement> Columns = row.findElements(By.className("DayPicker-Day"));
	                     //   	 System.out.println("Columns Values are:" +Columns);
	                        	// Start loop for each value in the partiular rows
	                         
	                                       for(WebElement Column:Columns)
	                                        {
	                                    	 System.out.println("Column Text Value is :" +Column.getText());    
	                        	              if(Column.getText().equals("28"))
	                        	              {
	                        	            	  WebDriverWait wait = new WebDriverWait(driver, 10);
	                        	                  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\\\"search-mask-component\\\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div[4]/div[7]/span")));
	                        	            	  driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div[4]/div[7]/span")).click();
	                        
	                        	            	  //System.out.println("Single Column value is :" +Column);
	                        	              	  System.out.println("Return Date is selected as:" + "28");
	                        	              }
	                                    	   
	                                        }
	
	                            }
	                break;
                }
	               else
	                  {
	                   driver.findElement(By.xpath(NextButtonxpath)).click();
	                  }
	
                
}


//Click the Search Button
driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[4]/div/button")).click();

  }

}
