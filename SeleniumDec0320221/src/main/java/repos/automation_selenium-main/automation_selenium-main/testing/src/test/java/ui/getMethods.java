package ui;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		String text=driver.findElementByXPath("//*[@id=\"content\"]/div/div/div/div[1]/h2").getText();
		System.out.println(text);
		driver.close();	
	}

}
