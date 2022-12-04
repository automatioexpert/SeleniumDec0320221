package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCSSSelector {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		Thread.sleep(5000);


		//id --> #id or htmltag#id
		//class -> .class or htmltag.class
		
		// #username
		// input#username
		
		// form-control private-form__control login-email
		
		// .form-control.private-form__control.login-email
		// input.form-control.private-form__control.login-email
		// .c1.c2.c3...cn
		// tag.c1.c2.c3...cn
		//.login-email
		// input.login-email
		// input.login-email#username
		// input#username.login-email
		// input.form-control.private-form__control.login-email#username
		
		
		//driver.findElement(By.className("form-control private-form__control login-email")).sendKeys("naveen");
		//driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']")).sendKeys("naveen");
		//driver.findElement(By.cssSelector(".form-control.private-form__control.login-email")).sendKeys("naveen");
		
		//htmltag[@prop='value']
		// htmltag[prop='value']
		
		// input[id='username']
		// input[id='username'][type='email']
		// input[id][type='email']
		// input[id][type][tabindex]
		
		// input[type='email']
		// input[name='username']
		
		// div.input-group input --> 3
		// div.input-group > input --> 2
		
//		List<WebElement> footerLinks = driver.findElements(By.cssSelector("ul.footer-nav>li>a"));
//		System.out.println(footerLinks.size());
//		
//		for(int i=0; i<footerLinks.size(); i++){
//			System.out.println(footerLinks.get(i).getText());
//		}
		
		// input[id*='user'] --contains
		// input[id^='user'] --starts with
		// input[id$='name'] --ends with
		
		//comma in css:
		// input#username, input#password, button#loginBtn
		int mandatoryFieldsCount = driver.findElements(By.cssSelector("#username, #password, #loginBtn, .private-checkbox__text")).size();
		if(mandatoryFieldsCount == 4){
			System.out.println("login form is displayed with username, password and login button");
		}
		
		// #username, #password, #loginBtn, .private-checkbox__text
		
		// ul.list-unstyled li:nth-of-type(n)
		// ul.list-unstyled li:nth-of-type(4) a -- specific index
		// ul.list-unstyled li:nth-of-type(n) a -- all elements
		
		// ul.nav.navbar-nav.navbar-right li:nth-of-type(n) a
		
		// div.private-form__input-wrapper + div --> following sibling
		
		//not operator in css:
		
		//form-control private-form__control login-email
		//form-control private-form__control login-password m-bottom-3
		// input.form-control.private-form__control:not(.login-password)
		// input.form-control.private-form__control:not(#username)
		
		
	}

}
