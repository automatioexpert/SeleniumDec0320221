package UI;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertWithOkCancle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.findElementByXPath("//a[contains(text(),'Alert with OK & Cancel')]").click();
		driver.findElementByXPath("//button[contains(text(),'click the button to display a confirm box')]").click();
		driver.switchTo().alert().accept();
		String text = driver.findElementByXPath("//p[@id='demo']").getText();
		if(text.contains("You pressed Ok"))
			 System.out.println("Test case passed");
		
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.findElementByXPath("//a[contains(text(),'Alert with OK & Cancel')]").click();
		driver.findElementByXPath("//button[contains(text(),'click the button to display a confirm box')]").click();
		driver.switchTo().alert().dismiss();
		String text1 = driver.findElementByXPath("//p[@id='demo']").getText();
		if(text1.contains("You Pressed Cancel"))
			 System.out.println("Test case passed");
		



		
		
		 driver.close();

	}
}
