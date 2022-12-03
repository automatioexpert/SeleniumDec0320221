package seleniumsessions;

import org.openqa.selenium.By;

public class CustomXpath {

	public static void main(String[] args) {

		
		//By loc = By.xpath("xpath value");
		//xpath: its not an attribute
		//its an address of the element in the DOM
		//1. absolute xpath: /html/div/div[3]/div[4]/div/div/ul//div/li[2]/a
		//2. relative/custom xpath: with the help of attributes, xpath functions
		
		//htmltag[@attr='value']
		//input[@id='input-email']--> 100-->20-->1
		//input[@name='email']
		//input[@placeholder='E-Mail Address']
		
		//htmltag[@attr1='value' and @attr2='value']
		//input[@name='email' and @type='text']
		//input[@name='email' and @type='text' and @class='form-control']
		//input[@name='email' or @type='text']
		
		//input
		//a
		//input[@id]
		//a[@href]
		
		//text():
		//htmltag[text()='value']
		//a[text()='Login']
		//h2[text()='Returning Customer']
		//label[text()='First Name']
		
		//contains(): used it for dynamic elements with dynamic attributes
		//htmltag[contains(@attr,'value')]
		//input[contains(@id,'firstname')]
		
//		input <id = test_123>
//		<id = test_345>
//		<id = firstname_abc>
//		<id = firstname_abcdff>
//		<id = firstname_abc123>
		
		By.id("test_123");//Not recommended
		By.xpath("//input[contains(@id,'test_')]");
		By.xpath("//input[contains(@id,'firstname_')]");
		
		//htmltag[contains(@attr,'value') and contains(@attr,'value')]
		//input[contains(@id,'firstname') and contains(@name,'first')]
		//input[contains(@id='input-firstname')] --Invalid xpath
		
		//input[contains(@id,'firstname') and @name='firstname']
		//input[contains(@id,'firstname') and @name='firstname' and @type='text']
		
		//contains() with text():
		//htmltag[contains(text(),'value')]
		//h2[contains(text(),'Delight')]
		
		//contains() with text() and with attribute:
		//htmltag[contains(text(),'value') and contains(@attr,'value')]
		//a[contains(text(),'Customers') and contains(@href,'customers')]
		
		//htmltag[contains(text(),'value') and contains(@attr,'value') and @attr='value']
		
		//starts-with():
		//htmltag[starts-with(@attr,'value')]
		//p[starts-with(text(),'If you already')]
		
		//ends-with():deprecated in xpath3.0
		
		//index:
		// (//input[@class='form-control'])[6]
		// (//input[@class='form-control'])[position()=6]
		By.xpath("(//input[@class='form-control'])[6]");
		
		// (//input[@class='form-control'])[last()]
		// (//input[@class='form-control'])[last()-5]
		
		// ((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]
		
		By.xpath("((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]");

		
		
		
		
	}

}
