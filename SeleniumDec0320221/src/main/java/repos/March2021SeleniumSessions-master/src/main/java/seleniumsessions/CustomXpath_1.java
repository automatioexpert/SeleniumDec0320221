package seleniumsessions;

public class CustomXpath_1 {

	public static void main(String[] args) {

		//Xpath:
		//1. Absolute Xpath : //html/body/div[3]/div/div[]/ul/li/a
		//html/body/div[2]/div/div/div/div[1]/div/h2
		
		//2. Relative Xpath or custom xpath: 
		//input
		//input[@attr]
		//htmtag[@attr='value']
		//input[@id='input-email']
		//input[@name='email']
		
		//htmltag[@attr1='value' and @attr2='value']
		//input[@name='email' and @type='text']
		//input[@name='email' or @type='text']

		//input[@value='Login' and @type='submit']
		
		//input[@type='text'] -- 3
		//*[@type='text'] -- 3
		
		//text() function:
		//h2[text()='Refreshing business software that your teams will love']
		//a[text()='Login']
		
		//contains() function:
		//htmltag[contains(@attr,'value')]
		//input[contains(@name,'username')]
		//input[contains(@name,'user')]
		//input[contains(@name,'name')]
		
		//htmltag[contains(@attr1,'value') and contains(@attr2='value')]
		//input[contains(@name,'name') and contains(@type,'text')]
		
		//contains() with text():
		//htmltag[contains(text(),'value')]
		//h2[contains(text(),'Refreshing')]
		//h2[contains(text(),'business software')]
		
		//contains() with text() and attribute:
		//htmltag[contains(text(),'value') and contains(@attr,'value')]
		//a[contains(text(),'Gift Cards') and contains(@data-csa-c-slot-id,'nav_cs_3')]
		//a[contains(text(),'About Us') and contains(@href,'aboutamazon')]
		
		//contains with links, span, p, small
		//small[contains(text(),'tracking tool and sales pipeline')]
		
		//String xpath = "//small[contains(text(),\"tracking tool and sales pipeline\")]";
		
		//position() function:
		// (//input[@type='text'])[position()=1]
		// (//input[@class='form-control'])[position()=1]
		// (//input[@class='form-control'])[1]
		// (//ul[@class='footer-nav'])[1]//a
		
		//last():
		// (//input[@class='form-control'])[last()]
		
		//dynamic ids or any attribute:
//		<input id="username_123">
//		<input id="username_345">
//		<input id="username_567">
		//EXT JS 
		//input[contains(@id,'username_')]
		
		//starts-with():
		// (//div[starts-with(@class,'navFooterLinkCol')])
		//input[starts-with(@id,'username_')]

		
		
	}

}
