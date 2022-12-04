package SeleniumSessions;

public class ExplcitWaitConcept {

	public static void main(String[] args) {

		
		//ExplicitWait: is a high level wait concept
		//its a concept
		//its dynamic
		//not a global wait
		//it can be applied for a specific element
		//it can be customized for a specific element as per the use case
		//e1 --> 5 secs
		//e2 --> no wait
		//e3 --> 10 secs
		
		//it can be applied for all non web elements : alert, url, title
		
		//WebDriverWait(C) -extends-> FluentWait (C) -implements-> Wait(I) -->until() methods
		
		//FluentWait(C) --> imp --> Wait(I) --until(); method
		//1. until -- overridden
		//2. individual methods: ignoring(), withMessage(), pollingEvery()
		
		//WebDriverWait(C) -extends-> FluentWait (C) 
		//timeoutException() -- protected
		//1. until() -- inherited
		//2. inherited methods: ignoring(), withMessage(), pollingEvery()

		
		
	}

}
