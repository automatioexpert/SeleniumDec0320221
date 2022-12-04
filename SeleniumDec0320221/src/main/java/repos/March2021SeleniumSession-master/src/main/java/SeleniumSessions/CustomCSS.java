package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCSS {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//custom css:
		//id --> #{id}
		//class --> .{classname}
		
		// #input-email
		//tag#id
		//tag.classname
		
		// input#input-email
		// input#input-email.form-control
		// input.form-control#input-email
		// .form-control#input-email
		
		//.c1.c2.c3....cn
		// form-control private-form__control login-email
		// .form-control.private-form__control.login-email
		// input.form-control.private-form__control.login-email
		
		// input.form-control.private-form__control.login-email#username
		// input#username.form-control.private-form__control.login-email
		
		driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']"));
		//wrong: driver.findElement(By.className("form-control private-form__control login-email"));
		driver.findElement(By.className("login-email"));
		driver.findElement(By.cssSelector("input.form-control.private-form__control.login-email"));
		
		//htmltag[@attr = 'value']
		// htmltag[attr = 'value']
		// input[name='email']
		
		// input[name='email'][type='text']
		
		// input[id*='user'] -- contains (dynamic ids, attributes) 
		// input[id*='user'][type='email']
		// input[id^='user'] -- starts with
		// input[id$='name'] --ends with
		
		//parent to child:
		// div.private-form__input-wrapper > input
		// ul.footer-nav > li > a 
		// form#hs-login > div -- 8 (direct)
		// form#hs-login div --20 (direct + indirect child elements)
		// select#Form_submitForm_Industry > option
		
		//child to parent: NA
		//No backward traversing in css
		
		//not in css:
		// form-control private-form__control login-email
		// form-control private-form__control login-password m-bottom-3
		// input.form-control.private-form__control:not(#username)
		// input.form-control.private-form__control:not(#password)
		
		//comma in css:
		//button, link, text field, checkbox
		List<WebElement> impFields = 
				driver.findElements(By.cssSelector("input[name='username'], input[name='password'],input[value='Login'],a[href*='register']"));
		
		if(impFields.size() == 4) {
			
		}
		
		// 
		List<WebElement> hrmElements = 
				driver.findElements(By.cssSelector("input#Form_submitForm_subdomain, img.nav-logo, a[href*='contact-sales'], select#Form_submitForm_Industry"));
		
		if(hrmElements.size() == 4) {
			System.out.println("all imp fileds are present on the page");
			
			for(WebElement e : hrmElements)	{
				System.out.println(e.isEnabled());
			}
		}
		
		//nth-of-type:
		//	ul.footer-nav li:nth-of-type(4)
		// select#Form_submitForm_Industry > option:nth-of-type(1)
		// div.ac_results li:nth-of-type(1)
		
		//following sibling in CSS:
		// div.private-form__input-wrapper + div
		
		
	}

}
