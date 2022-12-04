package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelector {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		//CSSSelector: is a locator, not an attribute
		
		//By.cssSelector("#username")
		//id --> #id
		//#username
		//input#username
		//class --> .class
		//.login-email
		
		//class -- c1 c2 c3....cn
		//.c1.c2.c3....cn
		//.form-control.private-form__control.login-email
		//input.form-control.private-form__control.login-email
		//input.private-form__control.login-email
		//input#username.login-email
		//input.login-email#username
		//input.form-control.private-form__control.login-email#username
		//input#username.form-control.private-form__control.login-email
		
		// htmltag[attr='value']
		// input[id='username']--css
		//input[@id='username']--xpath
		// input[type='email']
		
		// htmltag[attr1='value'][attr2='value']--css
		//htmltag[@attr1='value' and @attr2='value']--xpath

		// input[type='email'][id='username']
		
		// input[id*='user'] --contains
		// input[name*='name']
		// input[name*='name'][type='text']
		// input[name^='user'] ---starts-with
		// input[name$='name'] --ends-with
		
		//parent to child:
		// div.private-form__input-wrapper input --2
		// div.private-form__input-wrapper > input --2
		
		// form#hs-login div --20 (direct+indirect)
		// form#hs-login > div --8 (only direct)
		
		//child to parent: not allowed
		//backward traversing
		
		//following-sibling:
		// div#navbar-collapse ul li + li
		
		//comma in css:
		//input, button, a, form, span, div, img
		By loginEle = 
					By.cssSelector("input#username,input#password,button#loginBtn,input#remember");
		
		if(driver.findElements(loginEle).size()==4) {
			
		}
		
		//nth-of-type:
		// div#navbar-collapse li:nth-of-type(n) --collect all the elements
		// div#navbar-collapse li:nth-of-type(2) --  go the 2nd li
		// div.navFooterVerticalRow div.navFooterLinkCol:nth-of-type(7) a
		
//		
//		       xpath       css
//1. syntax:	  complex	 simple
//2. functions:   better     limited
//3. backward:    possible     NP
//4. performance: good		good
//5. webtable:     much btter limited options
//6. dynamic attr: good		good
//7. different tags: NA		comma	
		
		
		
	}

}
