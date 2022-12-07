package ui;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hellow java");
		//System.setProperty("webdriver.chrome.driver", "/Users/admin/Documents/BrowserDriver/chromedriver");
	    WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.ebay.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("mobiles");
		driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
		driver.close();
     //Frioz bhai
	}

}
