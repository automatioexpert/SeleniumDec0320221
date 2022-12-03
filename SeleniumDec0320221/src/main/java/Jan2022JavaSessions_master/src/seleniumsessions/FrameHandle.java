package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");

		//driver.switchTo().frame(2);
		//driver.switchTo().frame("main");
		//frame is also a web element:
		//frame has its own HTML DOM : #document
		//html tags: frame, iframe
		//NoSuchFrameException: no such frame : In case frame is not present
		driver.switchTo().frame(driver.findElement(By.name("main")));
		
		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);
		
		//driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();//main page
		
		//Salesforce UI 
		
		//random pop up: limitation
		//QA : disable adv. pop ups
		
		
		
	}

}
