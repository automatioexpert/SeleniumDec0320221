package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsAlertPopUp {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		//driver.findElement(By.name("proceed")).click();
		
		//if alert is not there: NoAlertPresentException: no such alert
		
		Alert alert = driver.switchTo().alert(); //JS popup, confirmation, prompt
		
		String text = alert.getText();
		System.out.println(text);
		
		//alert.sendKeys("testing");
		
		alert.accept();//click on ok button
		
		//alert.dismiss(); //click on cancel button
		
		
	}

}
