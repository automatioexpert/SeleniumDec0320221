package com.selenium.testing;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SpotifyLogin {
	@Test
	public void login(){
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://accounts.spotify.com/en/login");
		driver.findElement(By.xpath("//*[@id=\"login-username\"]")).sendKeys("Rajkawale00@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys("Mietgondia712@1");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]/div[1]/p")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/button[2]")).click();
	}
}
