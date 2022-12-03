package seleniumsessions;

import org.openqa.selenium.By;

public class Custom_Xpath_1 {

	public static void main(String[] args) {

		//xpath: address of the element inside DOM
		
		//htmltag[@attr = 'value']
		//input[@id='input-email']
		//*[@id='input-email']
		
		//input[@id]
		//input[@type='submit']
		
		//htmltag[@attr1 = 'value' and @attr2 = 'value']
		//input[@type='submit' and @value = 'Login']
		//input[@type='text' and @name='email']
		//input[@placeholder = 'E-Mail Address']
		
		//dynamic ids:
//		<input id = "test_123">
//		<input id = "test_456">
//		<input id = "test_908">
		
		//contains():
		//htmltag[contains(@attr,'value')]
		//input[contains(@id,'test_')]
		
		//contains() with multiple attributes:
		//htmltag[contains(@attr1,'value') and contains(@attr2='value')]
		//input[contains(@id,'email') and contains(@name,'email')]
		//input[contains(@id,'email') and contains(@name,'email') and contains(@placeholder,'E-Mail')]
		
		//one attr with contains and one without contains
		//input[contains(@id,'email') and @type='text']
		//input[@type='text' and contains(@id,'email')]
		
		//text():
		//htmltag[text()='value']
		//a[text()='My Account']
		//h2[text()='Returning Customer']
		
		//text() and @attr
		//htmltag[text()='value' and @attr='value']
		//a[text()='Buy Again' and @data-csa-c-content-id='nav_cs_buy_again']
		
		//contains() with text():
		//htmltag[contains(text(),'value')]
		//span[contains(text(),'internationally')]
		
		//a[contains(text(),'Gift') and contains(@href,'gift-cards')]
		
		//starts-with:
		//a[starts-with(text(),'Gift')]
		//a[starts-with(text(),'Amazon')]
		//input[starts-with(@class,'form-')]
		
		//indexing:
		// (//input[@class='form-control'])[2]
		By emailid = By.xpath("(//input[@class='form-control'])[1]");
		By password = By.xpath("(//input[@class='form-control'])[2]");
		
		// (//input[@class='form-control'])[position()=1]

		// (//div[@class='navFooterLinkCol navAccessibility'])[1]//a
		// (//div[@class='navFooterLinkCol navAccessibility'])[4]//a
		
		//last():
		// (//input[@type='text' or @type='email' or @type='tel' or @type='password'])[last()]
		// ((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]
		// (//a[starts-with(text(),'Amazon')])[last()-1]
		
		//parent to child:
		// (//div[@class='form-group'])[1]/input[contains(@id,'email')]
		// //ul[@class='footer-nav']//a
		// (/) --> direct child elements
		// (//) --> direct + indirect child elements
		
		 //form[@id='hs-login']/div -- 8
		 //form[@id='hs-login']//div --20
		
		//div[@class='private-form__input-wrapper']/child::input
		//form[@id='hs-login']//child::div
		
		//child to parent:
		//input[@id='username']/../../../../../../../../../..
		//input[@id='username']/parent::div
		//input[@id='username']/..
		//input[@id='username']/ancestor::div
		
		
	}

}
