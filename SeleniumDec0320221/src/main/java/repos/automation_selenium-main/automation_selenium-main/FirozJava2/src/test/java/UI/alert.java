package UI;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		//driver.findElementByXPath("//a[contains(text(),'SwitchTo')]").click();
	//	driver.findElementByXPath("//a[contains(text(),'Alerts')]").click();
		driver.findElementByXPath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]").click();
		driver.findElementByXPath("//button[contains(text(),'alert box:')]").click();
		driver.switchTo().alert().accept();
		//driver.close();

		
	}

}
