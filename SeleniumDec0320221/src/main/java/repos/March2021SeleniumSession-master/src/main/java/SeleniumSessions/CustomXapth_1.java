package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXapth_1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//By.xpath("")
		// xpath: address of the element
		//1. absolute: parent to child to child: /html/body/div[2]/div[3]/div[1]/ul/li/a
		//relative/custom: use with xpath functions, with attributes
		
		//htmltag[@attr='value']
		//input[@id='input-email']
		//input[@name='email']
		
		//htmltag[@attr1='value' and @attr2='value']
		//input[@id='input-email' and @name='email']
		//input[@id='input-email' or @name='email']
		//input[@value='Login']
		
		//text(): links, header, span, label
		//htmltag[text()='value']
		//h2[text()='New Customer']
		//h3[text()='Group Calendar']
		
		//contains(): can be applied with text() and any attribute
		//htmltag[contains(@id,'value')]
		//input[contains(@id,'input-email')]
		//input[contains(@id,'email')]
		
		//dynamic attributes(id):
//		<input id=firstname_123>
//		<input id=firstname_345>
//		<input id=firstname_456>
		//input[contains(@id,'firstname_')]

		//contains() with text():
		//htmltag[contains(text(),'value')]
		//h2[contains(text(),'business software')]
		
		//htmltag[contains(text(),'value') and contains(@attr,'value')]
		//a[contains(text(),'Summit') and contains(@href,'first-summit')]
		
		//htmltag[@attr1='value' and contains(@attr2,'value')]
		//input[@type='submit' and contains(@value,'Login')]
		
		//starts-with():
		//h2[starts-with(text(),'Refreshing business')]
		//input[starts-with(@type,'sub')]
		
		//tag[contains(@attr1,'value') and starts-with(@attr2, 'value') and @attr3='value']
		
		//index:
		// (//input[@type='text'])[1]
		// (//input[@type='text'])[position()=1]
		// (//input[@type='text'])[5]
		
		// (//input[@type='text'])[last()]
		// (//input[@type='text'])[last()-1]
		
		// (//ul[@class='footer-nav'])[1]//a
		
		// (//ul[@class='footer-nav'])[position()=1]//a
		// ((//ul[@class='footer-nav'])[1]//a)[last()]
		// ((//ul[@class='footer-nav'])[4]//a)[last()]
		
		for(int i=1; i<=4; i++) {
			String xpath = "((//ul[@class='footer-nav'])[" + i + "]//a)[last()]";
			System.out.println(xpath);
		}
		
		driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']"));
		//wrong: driver.findElement(By.className("form-control private-form__control login-email"));
		driver.findElement(By.className("login-email"));
		
		//backward traversing:
		//child to parent: //input[@id='username']/../../../../../../../../../..
		//immediate parent:
		//input[@id='username']/parent::div
		
		//child to parent to parent: //input[@id='username']/../../
		//child to ancestors:  //input[@id='username']/ancestor::div
		
		//parent to child:
		//div[@class='form-group']/label[text()='E-Mail Address']
		//div[@class='form-group']/input[@name='email']
		//div[@class='form-group']/child::input[@name='email']
		
		
		
		
		
		
		
		
		
	}

}
