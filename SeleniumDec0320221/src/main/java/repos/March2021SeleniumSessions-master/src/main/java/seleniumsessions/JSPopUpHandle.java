package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSPopUpHandle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		
		//alert pop will be there:
		//to handle alerts: use alert API
		
		Alert alert = driver.switchTo().alert();
		//this method will switch tothe alert (if alert is present)
		//...if not there--> throw NoAlertFoundException
		
		String text = alert.getText();
		System.out.println(text);
		
		alert.accept(); //click on OK button
		
		//alert.dismiss(); //cancel the alert
		
		
		
		
	}

}
