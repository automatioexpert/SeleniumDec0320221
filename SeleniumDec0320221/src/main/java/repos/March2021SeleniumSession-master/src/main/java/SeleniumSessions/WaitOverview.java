package SeleniumSessions;

public class WaitOverview {

	public static void main(String[] args) {

		//wait - sync between script and the app
		
		//static wait: Thread.sleep(5000) --> 5 secs -- pause
		//dynamic wait: total time = 10 secs -- found = 2 secs
			//left our time = 8 secs (ignored)
		
			//a. Implicitly Wait: is a global wait only for web elements
			//b: Explicit Wait: custom wait 
					//b.1: WebDriverWait (Class)
					//b.2: FluentWait (Class)
			//WebDriverWait (c) --> extends FluentWait(c) --> implements -- [Wait(I) --until();]
		
			
		//Wait(I) --until();
		//FluentWait -- class -- @override until(){} + other methods also + timeOutExcetpion()
		//	WebDriverWait -- class --- only one overriden method -- timeOutExcetpion()
		
		
		
	}

}
