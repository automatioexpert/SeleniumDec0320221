package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		
		By username = By.name("username");
		
		//name: can be duplicate
		//driver.findElement(By.name("username")).sendKeys("testing");
		
		//className: can be duplicate
		//driver.findElement(By.className("abc")).sendKeys("testing");
		
		//xpath: is not an attribute
		//address of the element in HTML DOM
		//driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/input[1]")).sendKeys("testing");
		
		//css Selector: not an attribute
		//CSS: Cascaded Style Sheet
		driver.findElement(By.cssSelector("#loginForm > div > input:nth-child(1)")).sendKeys("testing");
		
		//partialLinkText: only for links : tag : <a>
		//Forgotten Password
		//Forgotten UserName
		driver.findElement(By.partialLinkText("Forgotten")).click();
		
		
	}

}
