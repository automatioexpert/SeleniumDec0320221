package UI;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cookies1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leetcode.com/problem-list/top-interview-questions/?difficulty=EASY&page=1");
		Set <Cookie> list = driver.manage().getCookies();
		System.out.println(list.size());
		for(Cookie cook : list)
		{
			System.out.println(cook.getName() + " : " + cook.getValue());
			
		}
		System.out.println();
		System.out.println(driver.manage().getCookieNamed("csrftoken"));
		Cookie cookie = new Cookie("2345","fgjhbj");
		driver.manage().addCookie(cookie);
		//System.out.println(driver.manage().getCookieNamed("firoz"));
		for(Cookie cook : list)
		{
			System.out.println(cookie.getName() + " : " + cookie.getValue());
			
		}
		driver.manage().deleteCookieNamed("2345");
		for(Cookie cook : list)
		{
			System.out.println("after deletion" + cookie.getName() + " : " + cookie.getValue());
			
		}
	}

}
