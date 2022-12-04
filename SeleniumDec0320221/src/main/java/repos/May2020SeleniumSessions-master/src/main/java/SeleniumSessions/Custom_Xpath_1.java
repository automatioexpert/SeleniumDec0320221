package SeleniumSessions;

public class Custom_Xpath_1 {

	public static void main(String[] args) {

		//xpath: address of webelement
		//1. absolute Xpath: //html/body/div/div[2]/div[3]/ul/li/input
		//2. Relative Xpath: Custom Xpath : Xpath Features and functions/Xpath Axes
		//input[@name='test']
		
		
		//tag[@attr='value']
		//input[@id='username']
		//input[@type='email']
		//button[@id='loginBtn']
		
		//tag[@attr1='value' and @attr2='value']
		//input[@type='email' and @id='username']
		//input[@type='email' and @id]
		//input[@type and @id]
		//input[@class='form-control private-form__control login-email']
		//input[@class='login-email'] -- not valid
		//form[@id='hs-login']//input[@id='username']
		//div[@class='private-form__input-wrapper']/input[@id='username']
		
		//ul[@class='footer-nav']/li/a
		
		//select[@id='Form_submitForm_Industry']/option -- 21 child (direct) elements
		//select[@id='Form_submitForm_Industry']//option -- 21 child (direct+indirect elements)
		
		//contains:
		//tag[contains(@id,'username')]
		//input[contains(@id,'username')]
		//input[@id='username']
		
//		<input id="username_123">
//		<input id="username_234">
//		<input id="username_344">
		
		//input[contains(@id,'username_')]

		//input[contains(@id,'user') and @type='email']
		//input[contains(@id,'user') and contains(@type,'email')]
		//input[contains(@id,'username') and @type]
		
		//text()
		//a[text()='Platform']
		//a[text()='Platform' and @class='nav-label']
		//a[@class='nav-label' and text()='Platform']
		//a[contains(text(),'Platform')]
		//a[contains(text(),'Platform') and @class='nav-label']
		
		//starts-with:
		//input[starts-with(@id,'user')]
		
		// (//div[@class='private-form__input-wrapper']//input)[1]
		// (//div[@class='private-form__input-wrapper']//input)[2]
		
		// (//div[@class='input-group']//input)[1]
		// (//div[@class='input-group']//input)[position()=1]
		// (//div[@class='input-group']//input)[last()]
		// (//input[@type='text'])[last()]
		
	}

}
