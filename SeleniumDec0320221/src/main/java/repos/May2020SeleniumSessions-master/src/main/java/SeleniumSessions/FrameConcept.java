package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.londonfreelance.org/courses/frames/index.html");

		// driver.switchTo().frame(2);
		// driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.name("main")));
		// frame
		// iframe

		WebElement header = driver.findElement(By.cssSelector("body > h2"));

		System.out.println(header.getText());

	}

}
