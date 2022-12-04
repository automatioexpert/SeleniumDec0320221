package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandleConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();//Browser

		driver.get("http://www.londonfreelance.org/courses/frames/index.html");//page
		
		//frame and iframe
		
		//driver.switchTo().frame(2);
		//driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.name("main")));

		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
		
		
		
	}

}
