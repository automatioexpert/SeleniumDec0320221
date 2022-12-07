package com.BasicSelinum;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CockiesHandling {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\HASSEN\\workspace\\BasicSelinum_Tutorail_Suite\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		
		Set<Cookie> abc=driver.manage().getCookies();
		System.out.println(abc.size());
		System.out.println(abc);
		
		driver.manage().deleteAllCookies();
		Set<Cookie> abcd=driver.manage().getCookies();
		System.out.println(abcd.size());
		System.out.println(abcd);
		
		driver.close();
	}
}
