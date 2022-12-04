package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCssSelector {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		//css selector:
		By.cssSelector("#input-email");
		
		//id --> #id
		//class --> .class
		
		// #input-email
		//tag#id
		// .form-control
		//tag.class
		
		// #input-email.form-control
		// .form-control#input-email
		
		// .c1.c2.c3...cn
		// .nav-input.nav-progressive-attribute		
		
		//input#input-email
		//input.form-control
		//input.form-control#input-email
		//a.btn-orange.contact-ohrm 
		
		By ele = By.cssSelector("a.btn-orange.contact-ohrm ");
		
		By.className("btn-orange contact-ohrm");//not a valid
		By.xpath("//a[@class='btn-orange contact-ohrm']");//correct
		By.cssSelector("a.btn-orange.contact-ohrm");//correct
		By.className("contact-ohrm");//valid
		By.className(".contact-ohrm");//not valid

		// form-control private-form__control login-email
		// form-control private-form__control login-password m-bottom-3
		
		//input.form-control.private-form__control.login-password.m-bottom-3
		By.className("form-control private-form__control login-password m-bottom-3");//not valid
		By.xpath("//input[@class='form-control private-form__control login-password m-bottom-3']");
		By.className("login-password");
		By.cssSelector("input.form-control.private-form__control.login-password.m-bottom-3");
		By.cssSelector("input.form-control.login-password");
		By.xpath("//button[contains(@class,'login-submit')]");
		By.xpath("//button[@class='login-submit']");//not valid
		
		//button.login-submit
		
		// htmltag[attr1='value']
		// input[type='submit']
		//input[@type='submit']
		
		// htmltag[attr1='value'][attr2='value'][attr3='value']
		// input[type='submit'][value='Login']--css
		//input[@type='submit' and @value='Login'] --xpath
		
		// input[id*='email'] -- contains
		// button[data-test-id^='password'] --starts-with
		// button[data-test-id$='button'] --ends with
		
		//parent to child:
		// div.private-form__input-wrapper > input#username --direct child
		// div.private-form__input-wrapper  input#username --(direct + indirect child)
		
		// ul.footer-nav > li > a
		
		// form#hs-login div -- 20(direct + indirect child)
		// form#hs-login > div --8(direct)
		
		//child to parent: not available
		//backward traversing is not allowed in css
		
		//following sibling: 
		// label.control-label + input#input-email
		
		//preceding-sibling: not available
		
		//not in css:
		//form-control private-form__control login-email
		//form-control private-form__control login-password m-bottom-3
		// input.form-control.private-form__control:not(#username)
		// input.form-control:not(.input-lg)
		
		//comma in css:
		// input#username,input#password,button#loginBtn,button#ssoBtn,input#remember
		int count = 
				driver.findElements(By.cssSelector("input#username,input#password,button#loginBtn,button#ssoBtn,input#remember")).size();
		
		//no text support
		
		//nth-of-type:
		// ul.footer-nav li:nth-of-type(5) > a -- for 5th index
		// ul.footer-nav li:nth-of-type(n) > a -- for all elements
		
		                //xpath            |        CssSelector
		  
		//1.syntax:     hard 			 	|         simple
		//2.backwards:  possible			|			NA
		//3.performance:  same               |          same
		//4. comma, not : NA                | 			available
		//5. text       : available         |            NA
		//6. sibling    :       available		|           only forward-sobling
		//7. index:     :   better fnctions    |        available -- but not simple
		//8. dynamic ele   :   yes            |         yes
		
		
	}

}
