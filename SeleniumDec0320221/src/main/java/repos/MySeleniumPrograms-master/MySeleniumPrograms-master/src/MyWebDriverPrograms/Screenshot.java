package MyWebDriverPrograms;

//import org.apache.commons.io.FileUtils;--> For Java 8 and Selenium 3.0
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.io.FileHandler; -->  For Java 10 and Selenium 3.0
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Screenshot {

	public static void main(String[] args) throws IOException {

		WebDriver driver;
		String URL = "http:/amazon.in";
	    System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver(); // launch chrome   
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
        try {
        	 
        	driver.findElement(By.id("Username")).sendKeys("Testname");
        }
        catch (Exception e)
        {
        	System.out.println("No such element found with the given element locator");
            File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("F:\\Screenshot.png")); 
            // For java version 10 - Use FileHandler, For Java 8 Use - FileUtils
            // FileHandler.copy(srcFile, new File("src/MyWebDriverPrograms/Screenshot.png"))
            // FileUtils will not work for Selenium 3, Java 10 or above currently we use "FileHandler" instead
        }
       
        driver.close();
	}

}
