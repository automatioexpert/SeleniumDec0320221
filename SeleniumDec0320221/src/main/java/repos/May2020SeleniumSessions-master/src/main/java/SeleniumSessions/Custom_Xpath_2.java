package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_Xpath_2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();//launch chrome
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        driver.get("https://app.hubspot.com/login");//enter url
        
        driver.findElement(By.id("username")).sendKeys("naveenanimation30@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Test@1234");
        driver.findElement(By.id("loginBtn")).click();
        
        Thread.sleep(5000);
        driver.navigate().to("https://app.hubspot.com/contacts/6329229/contacts/list/view/all/");
        Thread.sleep(5000);

        selectContact(driver, "kan ob");
        selectContact(driver, "monica T");
       System.out.println(getContactEmailId(driver, "kan ob"));
		
		//input[@id='username']/../../../../../../../../../..
		//input[@id='username']//parent::div
		//div[@class='private-form__input-wrapper']//child::input
		// (//div[@class='input-group']//child::input)[position()=1]
		//input[@name='username']//ancestor::div
		
		//a[text()='abhi sahu']//parent::td//preceding-sibling::td/input[@type='checkbox']
		//a[text()='Aashiq Limbu']//parent::td//preceding-sibling::td/input[@type='checkbox']
		
		//span[text()='kan ob']//ancestor::td//preceding-sibling::td//input[@type='checkbox']
       //i18n-string[contains(text(),'Contacts')]
     //tr[2]//td[1]//div[1]//label[1]//span[1]//span[1]//span[2]//*[local-name()='svg']
       //https://www.espncricinfo.com/series/14222/scorecard/299004/pakistan-vs-south-africa-1st-test-south-africa-tour-of-pakistan-2007-08
	}
	
	public static void selectContact(WebDriver driver, String name){
		 driver.findElement(
	        		By.xpath("//span[text()='"+name+"']//ancestor::td//preceding-sibling::td//input[@type='checkbox']/.."))
	        			.click();
	}
	
	public static String getContactEmailId(WebDriver driver, String name){
		return driver.findElement(By.xpath("//span[text()='"+name+"']//ancestor::td//following-sibling::td/a")).getText();
	}

}
