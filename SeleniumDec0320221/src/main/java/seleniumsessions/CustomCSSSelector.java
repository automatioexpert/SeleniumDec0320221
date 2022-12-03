package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCSSSelector {
	
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By email  = By.cssSelector("#input-email");
		//id --> #id or tag#id
		//class --> .class or tag.class
		
		// #input-email
		// input#input-email
		// input.form-control
		// .c1.c2.c3....cn
		// tag.c1.c2.c3....cn

		// .form-control.private-form__control.login-email
		// input.form-control.private-form__control.login-email
		
		// input.form-control#input-email
		// input#input-email.form-control
		// input.form-control.private-form__control.login-email#username
		// input#username.form-control.private-form__control.login-email
		// select#Form_submitForm_Country
		
		// tag[attr='value']
		// input[name='email'] -- css
		//input[@name='email'] -- xpath
		
		// tag[attr1='value'][attr2='value']
		// input[name='email'][type='text'][id='input-email']
		// input[name='email'][type='text']#input-email
		
		//tag[attr*='value'] --contains
		// input[id*='email'] --css
		//input[contains(@id,'email')] --xpath
		
		// input[placeholder^='E-Mail'] --startswith
		// input[placeholder^='E-Mail'][id^=input]
		// input[placeholder^='E-Mail'][id*=email]
		
		//input[placeholder$='Address'] -- endswith
		
		// input[placeholder$='Address'][id*='email'][class^='form']
		
		//no support for text in CSS
		
		//parent to child:
		
		// div#content input --> direct + indirect child elements --3
		// div#content > input --only direct child elements --0
		
		// div#content  div --7
		// div#content > div --1
		
		// select#Form_submitForm_Country > option
		// form#hs-login input#username
		
		//child to parent: NA
		//backward traversing in CSS: NA
		
		//sibling in css:
		// div.form-group > label[for='input-email'] + input
		
		//comma in css:
		// img[title='naveenopencart'],
//			input[name='search'],
//				input[id='input-email'],
//					button[data-toggle='dropdown']
							
		By impEles = By.cssSelector("img[title='naveenopencart'],input[name='search'],input[id='input-email'],button[data-toggle='dropdown']");					
		
		//for imporant mandatory webelements on the page
		
		int count = driver.findElements(impEles).size();
		if(count == 5) {
			System.out.println("all imp elements are present on the page");
		}
		
		
		//xpath vs css:
		//1. syntax:  css is btr than xpath
		//2. performance: both are good to go
		//3. backward: xpath 
		//4. siblings: xpath
		//5. webtable: xpath
		//6. comma: css
		//7. text: xpath
		//8. dynamic: both
		//9. SVG Elements: xpath
		//10. shadow dom : css selector
		//11. index: both
		//12. Relative Locators
		
		
	}
	
	
	
	

}
