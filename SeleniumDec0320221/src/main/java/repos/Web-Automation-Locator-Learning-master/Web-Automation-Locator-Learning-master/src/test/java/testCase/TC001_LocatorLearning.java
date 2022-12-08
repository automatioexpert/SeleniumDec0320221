package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.DriverSetup;

@Test
public class TC001_LocatorLearning extends DriverSetup {

public static String baseUrl = "https://rahulshettyacademy.com/locatorspractice/";
	
public void locatorLearning() throws InterruptedException {
	
	driver.get(baseUrl);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	driver.findElement(By.id("inputUsername")).sendKeys("Saimum");
	Thread.sleep(2000);
	
	driver.findElement(By.name("inputPassword")).sendKeys("Saimum");
	Thread.sleep(2000);
	
	driver.findElement(By.className("signInBtn")).click();
	Thread.sleep(2000);
	
	System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
	Thread.sleep(2000);
	
	driver.findElement(By.linkText("Forgot your password?")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Saimum");
	
	driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("saimumisalm2@gmail.com");
	
	driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("01738002113");
	Thread.sleep(2000);
	
	driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
	
	driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Saimum");
	
	driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
	
	driver.findElement(By.id("chkboxOne")).click();
	
	driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	
	Thread.sleep(2000);
	
	
}
}
