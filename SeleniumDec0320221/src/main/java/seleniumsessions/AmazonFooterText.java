package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFooterText {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		System.out.println(getHeaderValue("Careers"));
		System.out.println(getHeaderValue("Advertise Your Products"));
		System.out.println(getHeaderValue("Reload Your Balance"));
		System.out.println(getHeaderValue("Help"));

		//label[text()='Phone Number']/parent::div//input
		
	}
	
	public static String getHeaderValue(String footerLinkText) {		
		String header = driver
				.findElement(By.xpath("//a[text()='"+footerLinkText+"']/ancestor::div[@class='navFooterLinkCol navAccessibility']/div"))
						.getText();
		return header;
	}
	
	
	
	

}
