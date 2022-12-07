package com.selenium.testing;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AutoIT {
	@Test
	public void uploadFileAlert() {
		try {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver();
			
			//WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			
			driver.get("C:\\Users\\Raj Kawale\\OneDrive\\Desktop\\QA Testing\\Selenium\\SeleniumPrograms\\FileUpload Popup.html");
			Actions actions = new Actions(driver);
			
			WebElement element = driver.findElement(By.xpath("//input[@id='myFile']"));
			actions.moveToElement(element).click().perform();
			Thread.sleep(3000);
			
			Runtime.getRuntime().exec("C:\\Users\\Raj Kawale\\OneDrive\\Desktop\\QA Testing\\Selenium\\SeleniumPrograms\\src\\main\\resources\\repository\\AutoIT1.exe");
			Thread.sleep(3000);
				
			
			driver.findElement(By.xpath("//input[@type=\"submit\"]")).submit();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	//@Test
//	public void UploadByAction() {
//		
//		System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
//		
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		
//		driver.findElement(By.name("username")).sendKeys("Admin");
//		driver.findElement(By.name("password")).sendKeys("admin123");
//        driver.findElement(By.xpath("//button[@class = \"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
//		
//		WebElement uploadPhotoBtn = driver.findElement(By.xpath("//input[@id='file-upload']"));
//	
//	}
	@Test
	public void UploadResume() throws IOException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
	    driver.get("http://demo.guru99.com/test/autoit.html");			
	    driver.findElement(By.id("postjob")).click();			

	    driver.findElement(By.id("input_3")).sendKeys("Raj");                                 					
	    driver.findElement(By.id("id_4")).sendKeys("Rajkawale712@gmail.com");					
	    driver.findElement(By.id("input_4")).click();			
	    
	    // below line execute the AutoIT script .
	    Runtime.getRuntime().exec("C:\\Users\\Raj Kawale\\OneDrive\\Desktop\\FileUpload.exe");		
	    driver.findElement(By.id("input_6")).sendKeys("AutoIT in Selenium");					
	    driver.findElement(By.id("input_2")).click();
	    driver.close();
	     }
	}


