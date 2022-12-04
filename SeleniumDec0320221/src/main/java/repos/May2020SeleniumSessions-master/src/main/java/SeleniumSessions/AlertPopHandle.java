package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopHandle {

	public static void main(String[] args) throws InterruptedException {

		//JS Pop Up - Alert
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(4000);
		
		Alert alert = driver.switchTo().alert();
		
		String text  = alert.getText();
		System.out.println(text);
		
		if(text.equals("Please enter a valid user name")){
			System.out.println("correct alert messg");
		}else{
			System.out.println("incorrect alert messg");
		}
		
		alert.accept();//click on Ok button
		//alert.dismiss();//click on cancel button
		
		driver.switchTo().defaultContent();
		
		
		
	}

}
