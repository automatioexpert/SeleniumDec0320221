package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitOverview {

	public static void main(String[] args) {

		
		//wait -- sync -- bw selenium script and application
		
		//1. static wait: Thread.sleep(5000)-- 5 secs -- 2 secs --> 3 secs 
		//2. dynamic wait: wait dynamically
		//timeout = 10 secs, found = 2 secs
		//8 secs will be ignored
		
		//if element is not found after 10 secs:
		//then selenium will throw the exception
		
		//Dynamic Waits:
			//a. Implicitly Wait
			//b. Explictly Wait: 
						//b.1: WebDriverWait (Class)
						//b.2: FluentWait (Class)
						//WebDriverWait(C) extends FluentWait(C)implements Wait(I)
						//Wait(I) --> until();
						//FluentWait --> is having its own methods + until() implementation
		
		
		
		
		
		
		
		
	}

}
