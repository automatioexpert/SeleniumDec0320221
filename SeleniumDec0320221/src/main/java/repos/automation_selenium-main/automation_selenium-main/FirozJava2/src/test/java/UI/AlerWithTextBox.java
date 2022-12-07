package UI;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlerWithTextBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.findElementByXPath("//a[contains(text(),'Alert with Textbox')]").click();
		driver.findElementByXPath("//button[contains(text(),'click the button to demonstrate the prompt box')]").click();
		driver.switchTo().alert().sendKeys("baba ji");
		driver.switchTo().alert().accept();
		String text = driver.findElementByXPath("//p[@id='demo1']").getText();
		if(text.contains("baba ji"))
			System.out.println("test case passed");
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.findElementByXPath("//a[contains(text(),'Alert with Textbox')]").click();
		driver.findElementByXPath("//button[contains(text(),'click the button to demonstrate the prompt box')]").click();
		driver.switchTo().alert().dismiss();
		
		
		
		

		

	}

}
