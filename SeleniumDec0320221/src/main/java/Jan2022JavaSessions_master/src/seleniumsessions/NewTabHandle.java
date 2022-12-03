package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTabHandle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com");
		String parentWidnowId = driver.getWindowHandle();

		driver.switchTo().newWindow(WindowType.TAB);//sel 4.x
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.close();//close child window
		
		//back to parent window:
		driver.switchTo().window(parentWidnowId);
		System.out.println(driver.getTitle());

		
		
	}

}
