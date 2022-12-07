package MyWebDriverPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithPopUpAlerts {

	public static void main(String[] args) {

		String url = "http://www.tizag.com/javascriptT/javascriptalert.php";
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // launch Chrome   
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//CLick on Confirmation Alert Button
		driver.findElement(By.xpath("//input[@value='Confirmation Alert']")).click();
		//Change the focus to Alert
		Alert AlertButton = driver.switchTo().alert();
		
		System.out.println("AlertButton:" + AlertButton);
		System.out.println("Button is Clickable");
	
		
		String AlertPopupMessage = AlertButton.getText();
		System.out.println("AlertPopupMessage:" +AlertPopupMessage);
		//Accept or Dismiss the PopUp
      //    AlertButton.accept();
          AlertButton.dismiss();
      //AlertButton.dismiss();
		
	}

}
