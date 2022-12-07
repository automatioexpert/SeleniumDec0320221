	
	package MyWebDriverPrograms;

	import java.util.concurrent.TimeUnit;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver; 

    //Check the Search functionality for onward journey travel with only 5 Children and without Adults
	//From : Amsterdam 	To: Brussels Departure Date: Thu 18 Oct Passengers/Bikes : Adults: 0, Children: 5

	public class FlixbusBookTicketForChildren { 
 
		public static void main(String[] args) {

			
		         System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
		         WebDriver driver = new ChromeDriver(); // launch chrome

		         driver.get("https://global.flixbus.com/"); // enter URL
		         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);// dynamic wait

		         driver.manage().window().maximize();     // Maximize window
		         	          
		         driver.findElement(By.xpath("//*[@id=\"cookie-policy\"]/div/div[2]/span")).click(); // delete all cookies
 

//From Field "Amsterdam"
  driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[1]/div/div[1]/div/div[1]/div[1]/div/input")).sendKeys("Amsterdam",Keys.ENTER);	
                                                   // Use Above OR Below
//driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[1]/div/div[1]/div/div[1]/div[1]/div/input")).sendKeys("Amsterdam");
//driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[1]/div/div[1]/div/div[1]/div[2]/div/div[2]/div/div[1]/div/div/div/button/span/mark")).click();
	                   
//To Field Brussels		         
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[1]/div/div[2]/div/div[1]/div/input")).sendKeys("Brussels");
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div/div/button/span/mark")).click();

 // Date Field set and click today's date
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[1]/div/div/input")).click();
 
 // Then clicking side buttons of calendar until it reaches to October month
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[1]/button[2]/img")).click();
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[1]/button[2]/img")).click();
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[1]/button[2]/img")).click();
 
 //Select the date as Thursday October 18th
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[3]/div[4]/span")).click();
 
 // CLick the Passengers/Bikes Field
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[1]/div/div/input")).click();
 
 //Click Children title
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button[2]/i")).click();

 //Children count set to 5
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/button[1]/i")).click();
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/div/input")).click();
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button[2]/i")).click(); 
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button[2]/i")).click();  
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button[2]/i")).click();
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/button[2]/i")).click();
 
 //Click the Search Button
 driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[4]/div/button")).click();
 
 
   // driver.close();
   
   
     }

}
